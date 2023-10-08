import java.util.Scanner;

public class MergeSort3Way {

    public static void merge(int[] gArray, int low, int mid1, int mid2, int high, int[] destArray) {
        int i = low;
        int j = mid1;
        int k = mid2;
        int l = low;

        while ((i < mid1) && (j < mid2) && (k < high)) {
            if (gArray[i] < gArray[j]) {
                if (gArray[i] < gArray[k]) {
                    destArray[l] = gArray[i];
                    l++;
                    i++;
                } else {
                    destArray[l] = gArray[k];
                    l++;
                    k++;
                }
            } else {
                if (gArray[j] < gArray[k]) {
                    destArray[l] = gArray[j];
                    l++;
                    j++;
                } else {
                    destArray[l] = gArray[k];
                    l++;
                    k++;
                }
            }
        }

        while ((i < mid1) && (j < mid2)) {
            if (gArray[i] < gArray[j]) {
                destArray[l] = gArray[i];
                l++;
                i++;
            } else {
                destArray[l] = gArray[j];
                l++;
                j++;
            }
        }

        while ((j < mid2) && (k < high)) {
            if (gArray[j] < gArray[k]) {
                destArray[l] = gArray[j];
                l++;
                j++;
            } else {
                destArray[l] = gArray[k];
                l++;
                k++;
            }
        }

        while ((i < mid1) && (k < high)) {
            if (gArray[i] < gArray[k]) {
                destArray[l] = gArray[i];
                l++;
                i++;
            } else {
                destArray[l] = gArray[k];
                l++;
                k++;
            }
        }

        while (i < mid1) {
            destArray[l] = gArray[i];
            l++;
            i++;
        }

        while (j < mid2) {
            destArray[l] = gArray[j];
            l++;
            j++;
        }

        while (k < high) {
            destArray[l] = gArray[k];
            l++;
            k++;
        }
    }

    public static void mergeSort3WayRec(int[] gArray, int low, int high, int[] destArray) {
        if (high - low < 2) {
            return;
        }

        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;

        mergeSort3WayRec(destArray, low, mid1, gArray);
        mergeSort3WayRec(destArray, mid1, mid2, gArray);
        mergeSort3WayRec(destArray, mid2, high, gArray);

        merge(destArray, low, mid1, mid2, high, gArray);
    }

    public static int[] mergeSort3Way(int[] gArray) {
        int n = gArray.length;

        if (n == 0) {
            return gArray;
        }

        int[] fArray = new int[n];
        System.arraycopy(gArray, 0, fArray, 0, n);

        mergeSort3WayRec(fArray, 0, n, gArray);

        System.arraycopy(fArray, 0, gArray, 0, n);

        return gArray;
    }

    public static void main(String[] args) {
        int[] data = new int[10];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            // You can replace this with your input method.
            // Here, I'm just setting the values manually.
            data[i] = s.nextInt();
        }

        data = mergeSort3Way(data);

        System.out.print("After 3-way merge sort: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(data[i] + " ");
        }
        s.close();
    }
}
