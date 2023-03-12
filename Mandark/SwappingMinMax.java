package Companies.Mandark;

import java.util.Scanner;
import java.util.Stack;

public class SwappingMinMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLength = sc.nextInt();

        long[] list1 = new long[arrayLength];
        long[] list2 = new long[arrayLength];
        Stack<Long> stack = new Stack<>();
        stack.push(0L);
        long temp;

        for (int i = 0; i < arrayLength; i++) {
            list1[i] = sc.nextInt();
        }
        for (int i = 0; i < arrayLength; i++) {
            list2[i] = sc.nextInt();
        }

        for (int i = 0; i < arrayLength; i++) {
            if ((list2[i] > list1[i]) && stack.peek() < list2[i]) {
                temp = list1[i];
                list1[i] = list2[i];
                list2[i] = temp;
                if (stack.peek() < list2[i]) {
                    stack.push(list2[i]);
                }
            } else {
                if (stack.peek() < list2[i]) {
                    stack.push(list2[i]);
                }
            }
        }

        long result = getMaxFromList(list1, list2);
        System.out.println(result);

        sc.close();
    }

    private static long getMaxFromList(long[] list1, long[] list2) {

        long maxList1 = 0, maxList2 = 0;

        for(int i=0; i<list2.length; i++){
            maxList1 = Math.max(list1[i],maxList1);
            maxList2 = Math.max(list2[i],maxList2);
        }
        return maxList1*maxList2;
    }
}

/*
6
1 2 6 5 1 2
3 4 3 2 2 5

12
1 2 3 2 3 4 5 3 5 6 7 8
2 1 5 3 4 6 4 3 2 3 1 2

25
8 7 9 6 5 6 6 5 6 4 6 7 8 5 4 3 2 1 4 5 6 7 8 7 8
2 4 5 6 7 6 7 8 9 8 7 6 7 6 5 4 3 2 3 4 5 5 5 4 5

10
35 12 45 12 45 78 1 54 2 5
9 34 56 12 34 89 2 4 8 10
 */