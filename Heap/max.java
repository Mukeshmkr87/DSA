import java.util.*;

public class maxK {
    public static class maxHeap {
        int n;
        int arr[];
        int count = 0;

        maxHeap(int n) {
            this.n = n;
            arr = new int[n];
        }

        void add(int data) { // Addition of element in the last position of an array.
            if (count == n) {
                System.out.println("Overflow Occur");
                return;
            }
            arr[count] = data;
            int idx = count;

            while (idx > 0 && arr[idx] > arr[(idx - 1) / 2]) {
                // Swap current element with its parent
                int temp = arr[idx];
                arr[idx] = arr[(idx - 1) / 2];
                arr[(idx - 1) / 2] = temp;
                idx = (idx - 1) / 2; // Move to parent index
            }
            count++;
        }

        void delete() { // Deletion happens at the root of the tree
            if (count <= 0) {
                System.out.println("Heap is empty");
                return;
            }
            arr[0] = arr[count - 1]; // Replace root with last element
            count--; // Reduce size
            int idx = 0;

            while ((2 * idx + 1) < count) { // Ensure left child exists
                int left = 2 * idx + 1;
                int right = 2 * idx + 2;
                int largest = left;

                if (right < count && arr[right] > arr[left]) {
                    largest = right; // Right child is larger
                }

                if (arr[idx] >= arr[largest]) {
                    break; // Heap property restored
                }

                // Swap
                int temp = arr[idx];
                arr[idx] = arr[largest];
                arr[largest] = temp;

                idx = largest; // Move down
            }
        }

        void print() {
            for (int i = 0; i < count; i++) { // Only print filled elements
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        maxHeap hp = new maxHeap(n);
        hp.add(32);
        hp.add(31);
        hp.print();
        hp.add(35);
        hp.print();
        hp.add(76);
        hp.print();
        hp.add(89);
        hp.print();
        hp.add(1); // This will cause "Overflow Occur" message
        hp.delete();
        hp.add(2);
        hp.print();
    }
}
