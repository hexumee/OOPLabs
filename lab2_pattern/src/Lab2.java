import java.util.Scanner;

public class Lab2 {
    static int n;

    static void launchA() {
        int i = 0, j = 0;

        while (i < n) {
            while (j < n) {
                System.out.printf("%d ", (n-i)+(n-i)*j);
                j++;
            }
            System.out.println();
            i++;
            j = 0;
        }
    }

    static void launchADoWhile() {
        int i = 0, j = 0;

        do {
            while (j < n) {
                System.out.printf("%d ", (n-i)+(n-i)*j);
                j++;
            }
            System.out.println();
            i++;
            j = 0;
        } while (i < n);
    }


    public static void main(String[] args) {
        System.out.print("Введите N: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        launchA();
        System.out.println();
        launchADoWhile();
    }
}

