import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private long window;
    private int shaderProgram;
    private int vaoId;
    private int vboId;

    private int uTimeLocation; // uniform animación

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        initWindow();
        initOpenGL();
        loop();
        cleanup();
    }

    private void initWindow() {

        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("No se pudo inicializar GLFW");
        }

        // OpenGL 3.3 Core
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE); // macOS

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        int width = 800;
        int height = 600;
        String title = "Fernando";

        window = glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (window == MemoryUtil.NULL) {
            throw new RuntimeException("No se pudo crear la ventana GLFW");
        }

        long primaryMonitor = glfwGetPrimaryMonitor();
        var vidMode = glfwGetVideoMode(primaryMonitor);
        if (vidMode != null) {
            glfwSetWindowPos(window, 
                    (vidMode.width() - width) / 2, 
                    (vidMode.height() - height) / 2);
        }

        glfwSetKeyCallback(window, (win, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                glfwSetWindowShouldClose(win, true);
            }
        });

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1); // v-sync
        glfwShowWindow(window);
    }

    private void initOpenGL() {

        GL.createCapabilities();

        // Vértices con posición + color
        float[] vertices = new float[]{
                // posición         color
                 0.0f,  0.5f, 0.0f,   1.0f, 0.0f, 0.0f, // arriba rojo
                -0.5f, -0.5f, 0.0f,   0.0f, 1.0f, 0.0f, // izquierda verde
                 0.5f, -0.5f, 0.0f,   0.0f, 0.0f, 1.0f  // derecha azul
        };

        // ------------------------------
        //         SHADERS
        // ------------------------------

        String vertexShaderSrc =
                "#version 330 core\n" +
                "layout (location = 0) in vec3 aPos;\n" +
                "layout (location = 1) in vec3 aColor;\n" +
                "out vec3 vColor;\n" +
                "void main() {\n" +
                "    vColor = aColor;\n" +
                "    gl_Position = vec4(aPos, 1.0);\n" +
                "}\n";

        String fragmentShaderSrc =
                "#version 330 core\n" +
                "in vec3 vColor;\n" +
                "out vec4 FragColor;\n" +
                "uniform float uTime;\n" +
                "\n" +
                "// Paleta animada arcoíris\n" +
                "vec3 palette(float t) {\n" +
                "    vec3 a = vec3(0.5, 0.5, 0.5);\n" +
                "    vec3 b = vec3(0.5, 0.5, 0.5);\n" +
                "    vec3 c = vec3(1.0, 1.0, 1.0);\n" +
                "    vec3 d = vec3(0.00, 0.10, 0.20);\n" +
                "    return a + b * cos(6.28318 * (c * t + d));\n" +
                "}\n" +
                "\n" +
                "void main() {\n" +
                "    float t = uTime * 0.15; // velocidad\n" +
                "    vec3 animated = palette(t);\n" +
                "    vec3 finalColor = mix(vColor, animated, 0.5);\n" +
                "    FragColor = vec4(finalColor, 1.0);\n" +
                "}\n";

        int vertexShader = compileShader(GL_VERTEX_SHADER, vertexShaderSrc);
        int fragmentShader = compileShader(GL_FRAGMENT_SHADER, fragmentShaderSrc);

        shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexShader);
        glAttachShader(shaderProgram, fragmentShader);
        glLinkProgram(shaderProgram);

        if (glGetProgrami(shaderProgram, GL_LINK_STATUS) == GL_FALSE) {
            throw new RuntimeException("Error al enlazar programa: " + glGetProgramInfoLog(shaderProgram));
        }

        // obtener uniform DESPUÉS del link
        uTimeLocation = glGetUniformLocation(shaderProgram, "uTime");
        if (uTimeLocation == -1) {
            System.err.println("Advertencia: no se encontró el uniform uTime.");
        }

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);

        // ------------------------------
        //         VAO / VBO
        // ------------------------------

        vaoId = glGenVertexArrays();
        glBindVertexArray(vaoId);

        vboId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboId);

        var vertexBuffer = MemoryUtil.memAllocFloat(vertices.length);
        vertexBuffer.put(vertices).flip();
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
        MemoryUtil.memFree(vertexBuffer);

        int stride = 6 * Float.BYTES;

        // posición (location 0)
        glVertexAttribPointer(0, 3, GL_FLOAT, false, stride, 0L);
        glEnableVertexAttribArray(0);

        // color (location 1)
        glVertexAttribPointer(1, 3, GL_FLOAT, false, stride, 3L * Float.BYTES);
        glEnableVertexAttribArray(1);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);

        glClearColor(0.1f, 0.1f, 0.15f, 1.0f);
    }

    private int compileShader(int type, String src) {
        int shader = glCreateShader(type);
        glShaderSource(shader, src);
        glCompileShader(shader);

        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE) {
            throw new RuntimeException("Error compilando shader: " + glGetShaderInfoLog(shader));
        }
        return shader;
    }

    private void loop() {

        while (!glfwWindowShouldClose(window)) {

            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);

            glUseProgram(shaderProgram);

            // enviar tiempo al shader
            glUniform1f(uTimeLocation, (float) glfwGetTime());

            glBindVertexArray(vaoId);
            glDrawArrays(GL_TRIANGLES, 0, 3);

            glfwSwapBuffers(window);
        }
    }

    private void cleanup() {
        glDeleteVertexArrays(vaoId);
        glDeleteBuffers(vboId);
        glDeleteProgram(shaderProgram);

        glfwDestroyWindow(window);
        glfwTerminate();

        GLFWErrorCallback callback = glfwSetErrorCallback(null);
        if (callback != null) callback.free();
    }
}

