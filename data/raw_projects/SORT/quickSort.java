import java.util.*;

class quickSort {
    static int N;

    void input(int arr[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements: ");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    void display(int arr[]) {
        int i;
        for (i = 0; i < N; i++) {
            System.out.printf("%d  ", arr[i]);
        }
        System.out.printf("\n");
    } // end of display()

    void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    int partition(int arr[], int l, int h) {
        int pivot = arr[l], low = l, high = h, temp;
        while (low < high) {
            while (pivot >= arr[low] && low < arr.length-1)
                low++;

            while (pivot < arr[high])
                high--;
            if (low < high) {
                // swap(arr[low], arr[high]);
                temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }
        // swap(arr[l], arr[high]);
        temp = arr[l];
        arr[l] = arr[high];
        arr[high] = temp;
        return high;
    }

    void sort(int arr[], int l, int h) // function to sort array elements in ascending order
    {
        int pvi;
        if (l < h) {
            pvi = partition(arr, l, h); // stores the pivot element index
            sort(arr, l, pvi - 1);
            sort(arr, pvi + 1, h);
        }
    } // end of sort()

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter list size: ");
        N = sc.nextInt();
        int arr[] = new int[N];
        quickSort q = new quickSort();
        q.input(arr);
        q.display(arr);
        q.sort(arr, 0, N-1);
        System.out.print("\nSorted array:   ");
        q.display(arr);
        sc.close();
    }
}