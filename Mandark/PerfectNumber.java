package Companies.Mandark;

import java.util.Scanner;

public class PerfectNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        boolean isPerfect = checkPerfect(number);
        System.out.println(isPerfect);
    }

    private static boolean checkPerfect(long number) {
        long sum = 0;

        for (long i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return (sum == number) ? true : false;
    }
}
