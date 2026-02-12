


import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import org.joml.Matrix4f;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryUtil.*;

public class CubeRenderer {

    private long window;
    private int program;
    private int vao;
    private int vboVertices;
    private int vboColors;
    private int ebo;
    private FloatBuffer fb;
    private boolean wireframe = false;
    private float cubeX = 0, cubeY = 0, cubeZ = 0;
    private float camYaw = 0, camPitch = 0;
    private double lastX, lastY;
    private boolean firstMouse = true;

    private float[] vertices = {
        // Front face
        -0.5f, -0.5f,  0.5f,
         0.5f, -0.5f,  0.5f,
         0.5f,  0.5f,  0.5f,
        -0.5f,  0.5f,  0.5f,
        // Back face
        -0.5f, -0.5f, -0.5f,
         0.5f, -0.5f, -0.5f,
         0.5f,  0.5f, -0.5f,
        -0.5f,  0.5f, -0.5f,
    };

    private float[] colors = {
        // Front - red
        1.0f, 0.0f, 0.0f,
        1.0f, 0.0f, 0.0f,
        1.0f, 0.0f, 0.0f,
        1.0f, 0.0f, 0.0f,
        // Back - green
        0.0f, 1.0f, 0.0f,
        0.0f, 1.0f, 0.0f,
        0.0f, 1.0f, 0.0f,
        0.0f, 1.0f, 0.0f,
        // Right - blue (for vertices 1,5,6,2)
        // But since colors are per vertex, and indices reference them, we assign per vertex
        // Actually, to make it per face, we can set colors accordingly, but for simplicity, assign per vertex as is.
        // For right face (vertices 1,5,6,2), but since it's shared, it's ok as long as we don't mind.
        // To properly color faces, we need to duplicate vertices or use flat shading, but for this, we'll use vertex colors.
        // Let's assign colors per vertex for each face.
        // Front: red, Back: green, Right: blue, Left: yellow, Top: cyan, Bottom: magenta
        // But since vertices are shared, colors will interpolate. For simplicity, we'll set as above, and note that it's approximate.
    };

    private int[] indices = {
        // Front
        0,1,2, 2,3,0,
        // Right
        1,5,6, 6,2,1,
        // Back
        5,4,7, 7,6,5,
        // Left
        4,0,3, 3,7,4,
        // Top
        3,2,6, 6,7,3,
        // Bottom
        4,5,1, 1,0,4
    };

    public void run() {
        init();
        loop();
        cleanup();
    }

    private void init() {
        if (!glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        window = glfwCreateWindow(800, 600, "Cube", NULL, NULL);
        if (window == NULL) throw new RuntimeException("Failed to create the GLFW window");

        glfwMakeContextCurrent(window);
        glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
        glfwSetCursorPosCallback(window, this::mouseCallback);
        glfwSetKeyCallback(window, this::keyCallback);

        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);

        String vertexShaderSource = """
            #version 330 core
            layout (location = 0) in vec3 aPos;
            layout (location = 1) in vec3 aColor;
            out vec3 ourColor;
            uniform mat4 mvp;
            void main() {
                gl_Position = mvp * vec4(aPos, 1.0);
                ourColor = aColor;
            }
            """;

        String fragmentShaderSource = """
            #version 330 core
            in vec3 ourColor;
            out vec4 FragColor;
            void main() {
                FragColor = vec4(ourColor, 1.0);
            }
            """;

        int vertexShader = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexShader, vertexShaderSource);
        glCompileShader(vertexShader);
        checkShaderCompile(vertexShader);

        int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentShader, fragmentShaderSource);
        glCompileShader(fragmentShader);
        checkShaderCompile(fragmentShader);

        program = glCreateProgram();
        glAttachShader(program, vertexShader);
        glAttachShader(program, fragmentShader);
        glLinkProgram(program);
        checkProgramLink(program);

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);

        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vboVertices = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboVertices);
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertices.length);
        vertexBuffer.put(vertices).flip();
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(0);

        vboColors = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColors);
        FloatBuffer colorBuffer = BufferUtils.createFloatBuffer(colors.length);
        colorBuffer.put(colors).flip();
        glBufferData(GL_ARRAY_BUFFER, colorBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(1);

        ebo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
        IntBuffer indexBuffer = BufferUtils.createIntBuffer(indices.length);
        indexBuffer.put(indices).flip();
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL_STATIC_DRAW);

        glBindVertexArray(0);

        fb = BufferUtils.createFloatBuffer(16);
    }

    private void checkShaderCompile(int shader) {
        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE) {
            throw new RuntimeException("Shader compilation failed: " + glGetShaderInfoLog(shader));
        }
    }

    private void checkProgramLink(int program) {
        if (glGetProgrami(program, GL_LINK_STATUS) == GL_FALSE) {
            throw new RuntimeException("Program linking failed: " + glGetProgramInfoLog(program));
        }
    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            processInput();
            render();
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    private void processInput() {
        float speed = 0.01f;
        if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) cubeZ -= speed;
        if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS) cubeZ += speed;
        if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS) cubeX -= speed;
        if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS) cubeX += speed;
        if (glfwGetKey(window, GLFW_KEY_LEFT_SHIFT) == GLFW_PRESS) cubeY -= speed;
        if (glfwGetKey(window, GLFW_KEY_SPACE) == GLFW_PRESS) cubeY += speed;
    }

    private void keyCallback(long window, int key, int scancode, int action, int mods) {
        if (key == GLFW_KEY_F1 && action == GLFW_PRESS) {
            wireframe = !wireframe;
        }
    }

    private void mouseCallback(long window, double xpos, double ypos) {
        if (firstMouse) {
            lastX = xpos;
            lastY = ypos;
            firstMouse = false;
        }
        float xoffset = (float)(xpos - lastX);
        float yoffset = (float)(lastY - ypos);
        lastX = xpos;
        lastY = ypos;
        float sensitivity = 0.1f;
        xoffset *= sensitivity;
        yoffset *= sensitivity;
        camYaw += xoffset;
        camPitch += yoffset;
        if (camPitch > 89.0f) camPitch = 89.0f;
        if (camPitch < -89.0f) camPitch = -89.0f;
    }

    private void render() {
        glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        if (wireframe) {
            glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        } else {
            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        }

        glUseProgram(program);

        Matrix4f proj = new Matrix4f().perspective((float)Math.toRadians(45), 800f / 600f, 0.1f, 100f);
        Matrix4f view = new Matrix4f().identity().rotate((float)Math.toRadians(camPitch), 1, 0, 0).rotate((float)Math.toRadians(camYaw), 0, 1, 0);
        Matrix4f model = new Matrix4f().identity().translate(cubeX, cubeY, cubeZ);
        Matrix4f mvp = new Matrix4f(proj).mul(view).mul(model);

        mvp.get(fb);
        int mvpLoc = glGetUniformLocation(program, "mvp");
        glUniformMatrix4fv(mvpLoc, false, fb);

        glBindVertexArray(vao);
        glDrawElements(GL_TRIANGLES, indices.length, GL_UNSIGNED_INT, 0);
        glBindVertexArray(0);
    }

    private void cleanup() {
        glDeleteVertexArrays(vao);
        glDeleteBuffers(vboVertices);
        glDeleteBuffers(vboColors);
        glDeleteBuffers(ebo);
        glDeleteProgram(program);
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public static void main(String[] args) {
        new CubeRenderer().run();
    }
}