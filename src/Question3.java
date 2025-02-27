import java.util.Scanner;

interface Color {
    void printColorValue();
    void flipColor();
}

class RGB implements Color {
    private int red, green, blue;

    public RGB(int red, int green, int blue) {
        this.red = clampRGB(red);
        this.green = clampRGB(green);
        this.blue = clampRGB(blue);
    }

    private int clampRGB(int value) {
        return Math.max(0, Math.min(255, value));
    }

    @Override
    public void printColorValue() {
        System.out.println("RGB Color: (" + red + ", " + green + ", " + blue + ")");
    }

    @Override
    public void flipColor() {
        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;
    }
}

class CMYK implements Color {
    private int cyan, magenta, yellow, black;

    public CMYK(int cyan, int magenta, int yellow, int black) {
        this.cyan = clampCMYK(cyan);
        this.magenta = clampCMYK(magenta);
        this.yellow = clampCMYK(yellow);
        this.black = clampCMYK(black);
    }

    private int clampCMYK(int value) {
        return Math.max(0, Math.min(100, value));
    }

    @Override
    public void printColorValue() {
        System.out.println("CMYK Color: (" + cyan + ", " + magenta + ", " + yellow + ", " + black + ")");
    }

    @Override
    public void flipColor() {
        cyan = 100 - cyan;
        magenta = 100 - magenta;
        yellow = 100 - yellow;
        black = 100 - black;
    }
}

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Color[] colors = new Color[5];

        System.out.println("[Color Keeper]");
        for (int i = 0; i < 5; i++) {
            System.out.print("Color " + i + ": RGB or CMYK? ");
            String type = scanner.nextLine().toUpperCase();

            if (type.equals("RGB")) {
                System.out.print("Enter Red (0-255): ");
                int red = scanner.nextInt();
                System.out.print("Enter Green (0-255): ");
                int green = scanner.nextInt();
                System.out.print("Enter Blue (0-255): ");
                int blue = scanner.nextInt();
                scanner.nextLine();
                colors[i] = new RGB(red, green, blue);
            } else if (type.equals("CMYK")) {
                System.out.print("Enter Cyan (0-100): ");
                int cyan = scanner.nextInt();
                System.out.print("Enter Magenta (0-100): ");
                int magenta = scanner.nextInt();
                System.out.print("Enter Yellow (0-100): ");
                int yellow = scanner.nextInt();
                System.out.print("Enter Black (0-100): ");
                int black = scanner.nextInt();
                scanner.nextLine();
                colors[i] = new CMYK(cyan, magenta, yellow, black);
            } else {
                System.out.println("Invalid color type. Please enter 'RGB' or 'CMYK'.");
                i--;
            }
        }

        System.out.println("\nPrinting all colors:");
        for (int i = 0; i < 5; i++) {
            colors[i].printColorValue();
        }

        System.out.println("\nFlipping all colors:");
        for (int i = 0; i < 5; i++) {
            colors[i].flipColor();
            colors[i].printColorValue();
        }
    }
}