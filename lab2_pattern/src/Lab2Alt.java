import java.util.Scanner;

public class Lab2Alt {
    static int n;

    static String getPadding(int rightBound) {
        String s = "";

        for (int i = 1; i <= rightBound; i++) {
            for (int j = 0; j < String.valueOf(i).length()+1; j++) {
                s += " ";
            }
        }

        return s;
    }

    static void launchB() {
        int i = 1, j = 1;

        while (i <= n*2-1) {
            if (i <= n) {
                System.out.print(getPadding(i-1));
                while (j <= n) {
                    if (j >= i) {
                        System.out.printf("%d ", j);
                    }
                    j++;
                }
            } else {
                System.out.print(getPadding(n-1));
                while (j <= i-n) {
                    System.out.printf("%d ", n-j);
                    j++;
                }
            }
            System.out.println();
            i++;
            j = 0;
        }
    }

    static void launchBDoWhile() {
        int i = 1, j = 1;

        do {
            if (i <= n) {
                System.out.print(getPadding(i-1));
                while (j <= n) {
                    if (j >= i) {
                        System.out.printf("%d ", j);
                    }
                    j++;
                }
            } else {
                System.out.print(getPadding(n-1));
                while (j <= i-n) {
                    System.out.printf("%d ", n-j);
                    j++;
                }
            }
            System.out.println();
            i++;
            j = 0;
        } while (i <= n*2-1);
    }

    public static void main(String[] args) {
        System.out.print("Введите N: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        launchB();
        System.out.println();
        launchBDoWhile();
    }
}

