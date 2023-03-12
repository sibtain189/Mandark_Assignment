package Companies.Mandark;

import java.util.*;

public class CombinationSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] L1 = new String[n];
        String[] L2 = new String[L1.length];

        for (int i = 0; i < L1.length; i++) {
            L1[i] = sc.next();
        }

        sortL1(L1, 0, n - 1);
        System.out.println("L1 : " + Arrays.toString(L1));

        sortL2(L2, L1);
        System.out.println("L2 : " + Arrays.toString(L2));
    }

    private static void sortL1(String[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sortL1(arr, l, mid);
            sortL1(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(String[] arr, int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;

        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        /* copy data to temp arrays */
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (leftArray[i].charAt(0) <= rightArray[j].charAt(0)) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void sortL2(String[] l2, String[] l1) {

        char c = '0';
        int i2 = 0;
        String temp = "";
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < l1.length; i++) {

            if (i == 0) {
                c = l1[i].charAt(0);
                for (int k = 1; k < l1[i].length(); k++) {
                    temp += l1[i].charAt(k);
                }
                list.add(Integer.parseInt(temp));
                temp = "";
            } else {
                if (l1[i].charAt(0) == c) {
                    for (int k = 1; k < l1[i].length(); k++) {
                        temp += l1[i].charAt(k);
                    }
                    list.add(Integer.parseInt(temp));
                    temp = "";
                } else {
                    Collections.sort(list);
                    Collections.reverse(list);
                    for (Integer array : list) {
                        l2[i2] = c + String.valueOf(array);
                        i2++;
                    }
                    list.clear();
                    c = l1[i].charAt(0);
                    for (int k = 1; k < l1[i].length(); k++) {
                        temp += l1[i].charAt(k);
                    }
                    list.add(Integer.parseInt(temp));
                    temp = "";
                }
            }
        }

        if (!list.isEmpty()) {
            Collections.sort(list);
            Collections.reverse(list);
            for (Integer array : list) {
                l2[i2] = c + String.valueOf(array);
                i2++;
            }
            list.clear();
        }
    }

}
