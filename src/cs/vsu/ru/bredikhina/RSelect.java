package cs.vsu.ru.bredikhina;

import java.util.Random;

public class RSelect {


    public static int RSelect(int[] a, int l, int r, int D) {
        int pivotIndex = RandomElement(l, r);
        pivotIndex = partition(a, l, r, pivotIndex);
        if (D == pivotIndex) return a[pivotIndex];
        else if (D > pivotIndex) return RSelect(a, pivotIndex + 1, r, D);
        else return RSelect(a, l, pivotIndex - 1, D);
    }

    private static int RandomElement(int l, int r) {
        r -= l;
        return (int) (Math.random() * ++r) + l;
    }

    public static int partition(int[] a, int l, int r, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        swap(a, pivotIndex, r);
        int storeIndex = l;
        for (int i = l; i <= r; i++) {
            if (a[i] < pivotValue) {
                swap(a, storeIndex, i);
                storeIndex++;
            }
        }
        swap(a, r, storeIndex);
        return storeIndex;
    }

    public static void swap(int[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = rnd.nextInt(10000);
        }
        System.out.print("данный массив: ");
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.println(i + 1 + " - " + RSelect(a.clone(), 0, 99, i));

        }
    }

}
