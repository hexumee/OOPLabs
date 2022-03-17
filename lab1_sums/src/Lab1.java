import java.util.Scanner;

public class Lab1 {
    static int n;

    static float launch() {
        float s = 0, i = 1;

        while (i <= n) {
            s += 1/i;
            i++;
        }

        return s;
    }

    static float launchDW() {
        float s = 0, i = 1;

        do {
            s += 1/i;
            i++;
        } while (i <= n);

        return s;
    }

    public static void main(String[] args) {
        System.out.print("Введите N: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        System.out.println(launch());
        System.out.println();
        System.out.println(launchDW());
    }
}

