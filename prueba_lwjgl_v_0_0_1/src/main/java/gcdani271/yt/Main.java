package gcdani271.yt;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class Main {
    private CrosshairRenderer crosshair;
    private long window;
    private Camera camera;
    private InputHandler input;
    private StbFont stbFont;
    private HudRenderer hud;
    private World world;
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        try {
            init();
            loop();
        } finally {
            GLFW.glfwTerminate();
        }
    }

    private void init() {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("No se pudo inicializar GLFW");
        }

        // Opcional: hints de ventana
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        window = GLFW.glfwCreateWindow(640, 360, "jijijija", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Error al crear la ventana GLFW");
        }

        // Hacer el contexto actual ANTES de llamar a cualquier función OpenGL
        GLFW.glfwMakeContextCurrent(window);

        // ¡Obligatorio! Carga las funciones de OpenGL para este contexto
        GL.createCapabilities();

        // Sincronización vertical
        GLFW.glfwSwapInterval(1);

        // Estado de OpenGL
        glEnable(GL_DEPTH_TEST);
        glClearColor(0.1f, 0.12f, 0.15f, 1.0f);
        // Evitar artefactos de caras traseras y mejorar z:
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glFrontFace(GL_CCW);

        // (Opcional) un pequeño polygon offset si más tarde dibujas wireframes encima:
        glEnable(GL_POLYGON_OFFSET_FILL);
        glPolygonOffset(1.0f, 1.0f);
        // --- IMPORTANTE: Inicializar tus instancias aquí ---
        camera = new Camera(0f, 0f, 5f);
        input = new InputHandler(); // <<<< Esto evita tu NPE
        crosshair = new CrosshairRenderer();
        stbFont = new StbFont("/fonts/Monospace.ttf", 20, 512);
        hud = new HudRenderer(stbFont);
        world = new World(4); // 4×4 chunks => 64 chunks => 16×16×16 bloques c/u
        
        // Capturar el cursor para mirar con el ratón (tipo Minecraft)
        GLFW.glfwSetInputMode(window, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_DISABLED);
    }

    private void renderHUD(double delta, int width, int height) {

        double fps = 1.0 / delta;

        hud.begin2D(width, height);

        // ===== FONDO TIPO MINECRAFT =====
        glDisable(GL_TEXTURE_2D); // muy importante
        glColor4f(0f, 0f, 0f, 0.6f); // negro transparente (0.6)
        glBegin(GL_QUADS);
        glVertex2f(0, 0);
        glVertex2f(width, 60);
        glVertex2f(width, 0);
        glVertex2f(0, 60);
        glEnd();

        glEnable(GL_TEXTURE_2D); // volver a activar para el texto

        // ===== TEXTO =====
        String line1 = String.format("X: %.2f  Y: %.2f  Z: %.2f", camera.getX(), camera.getY(), camera.getZ());

        String line2 = String.format("Yaw: %.1f°   Pitch: %.1f°   |   FPS: %.0f", camera.getYaw(), camera.getPitch(),
                fps);

        hud.drawText(10, 20, line1);
        hud.drawText(10, 45, line2);

        hud.end2D();
       
    }

    private void loop() {

        double lastTime = GLFW.glfwGetTime();

        while (!GLFW.glfwWindowShouldClose(window)) {

            double now = GLFW.glfwGetTime();
            double delta = now - lastTime;
            lastTime = now;

            input.update(camera, window, delta);

            float t = (float) (Math.sin(GLFW.glfwGetTime() * 0.5) * 0.1f);
            glClearColor(0.1f, 0.12f + t, 0.22f + t, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glMatrixMode(GL_MODELVIEW);
            glLoadIdentity();

            // Cámara
            glRotatef(camera.getPitch(), 1, 0, 0);
            glRotatef(camera.getYaw(), 0, 1, 0);
            glTranslatef(-camera.getX(), -camera.getY(), -camera.getZ());

            // --- DIBUJO 3D ---
            // 3D (con greedy mesh). Tu voxel mide 2 unidades de mundo:
            world.render(camera, 2.0f);

            // Crosshair
            int[] w = new int[1], h = new int[1];
            GLFW.glfwGetWindowSize(window, w, h);
            crosshair.drawCrosshair(w[0], h[0]);

            // HUD
            renderHUD(delta, w[0], h[0]);

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

    }
}
