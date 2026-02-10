package gcdani271.yt;

public class Camera {

    private float x, y, z;
    private float pitch; // rotación vertical
    private float yaw; // rotación horizontal

    public Camera(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void move(float dx, float dy, float dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    public void rotate(float dPitch, float dYaw) {
        pitch += dPitch;
        yaw += dYaw;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
        if (this.pitch > 89f)
            this.pitch = 89f;
        if (this.pitch < -89f)
            this.pitch = -89f;
    }

}
