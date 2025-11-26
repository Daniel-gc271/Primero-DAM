package cacharreo;


public class SpinningDonut {
    public static void main(String[] args) throws InterruptedException {
        double A = 0, B = 0;
        double i, j;
        int width = 40, height = 40;
        double[] zBuffer = new double[width * height];
        char[] output = new char[width * height];
        char[] chars = {'.', ',', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@'};

        while (true) {
            // Clear buffers
            for (int k = 0; k < width * height; k++) {
                output[k] = ' ';
                zBuffer[k] = 0;
            }

            for (j = 0; j < 6.28; j += 0.07) {
                for (i = 0; i < 6.28; i += 0.02) {
                    double sinI = Math.sin(i);
                    double cosI = Math.cos(i);
                    double sinJ = Math.sin(j);
                    double cosJ = Math.cos(j);

                    double sinA = Math.sin(A);
                    double cosA = Math.cos(A);
                    double sinB = Math.sin(B);
                    double cosB = Math.cos(B);

                    double h = cosJ + 2;
                    double D = 1 / (sinI * h * sinA + sinJ * cosA + 5);
                    double t = sinI * h * cosA - sinJ * sinA;

                    int x = (int) (width / 2 + 30 * D * (cosI * h * cosB - t * sinB));
                    int y = (int) (height / 2 + 15 * D * (cosI * h * sinB + t * cosB));
                    int o = x + width * y;
                    int N = (int) (8 * ((sinJ * sinA - sinI * cosJ * cosA) * cosB - sinI * cosJ * sinA - sinJ * cosA - cosI * cosJ * sinB));
                    if (height > y && y > 0 && x > 0 && width > x && D > zBuffer[o]) {
                        zBuffer[o] = D;
                        output[o] = chars[Math.max(N, 0)];
                    }
                }
            }

            // Print frame
            System.out.print("\u001b[H"); // ANSI escape to move cursor to top
            for (int k = 0; k < width * height; k++) {
                System.out.print(k % width != 0 ? output[k] : '\n');
            }

            A += 0.04;
            B += 0.02;
            Thread.sleep(30);
        }
    }
}
