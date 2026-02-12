package gcdani271.yt;

import org.lwjgl.glfw.GLFW;

public class InputHandler {

    private double lastMouseX, lastMouseY;
    private boolean firstMouse = true;

    
public void update(Camera cam, long window, double dt) {

    // Salir con ESC
    if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_ESCAPE) == GLFW.GLFW_PRESS)
        GLFW.glfwSetWindowShouldClose(window, true);

    // Apuntar al cubo con Q
    if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_Q) == GLFW.GLFW_PRESS) {
        float dx = -cam.getX();
        float dy = -cam.getY();
        float dz = -cam.getZ();

        float yaw = (float)Math.toDegrees(Math.atan2(dx, -dz));
        float dist = (float)Math.sqrt(dx*dx + dz*dz);
        float pitch = (float)Math.toDegrees(Math.atan2(dy, dist));

        cam.setYaw(yaw);
        cam.setPitch(pitch);
    }

    float speed = (float)(dt * 5.0); // 5 unidades por segundo

    // Movimiento tipo Minecraft
    if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS)
        cam.move((float)Math.sin(Math.toRadians(cam.getYaw())) * speed, 
                 0, 
                 (float)-Math.cos(Math.toRadians(cam.getYaw())) * speed);

    if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS)
        cam.move((float)-Math.sin(Math.toRadians(cam.getYaw())) * speed,
                 0,
                 (float)Math.cos(Math.toRadians(cam.getYaw())) * speed);

    if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS)
        cam.move((float)-Math.cos(Math.toRadians(cam.getYaw())) * speed, 
                 0, 
                 (float)-Math.sin(Math.toRadians(cam.getYaw())) * speed);

    if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS)
        cam.move((float)Math.cos(Math.toRadians(cam.getYaw())) * speed, 
                 0, 
                 (float)Math.sin(Math.toRadians(cam.getYaw())) * speed);

    // Rotación con ratón
    double[] mx = new double[1];
    double[] my = new double[1];
    GLFW.glfwGetCursorPos(window, mx, my);

    if (firstMouse) {
        lastMouseX = mx[0];
        lastMouseY = my[0];
        firstMouse = false;
    }

    float dx = (float)(mx[0] - lastMouseX);
    float dy = (float)(my[0] - lastMouseY);
    lastMouseX = mx[0];
    lastMouseY = my[0];

    float sensitivity = 0.1f;
    cam.rotate(dy * sensitivity, -dx * sensitivity);
}

}