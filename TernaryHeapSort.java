import java.util.Arrays;

public class TernaryHeapSort {

    private void swap(int[] list, int i, int j) {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }

    private void siftDown(int[] list, int start, int end) {
        int root = start;

        while(root * 3 + 1 <= end) {
            int swap = root;
            int child = root * 3 + 1;

            if(list[swap] < list[child]) {
                swap = child;
            }

            if(child + 1 <= end && list[swap] < list[child + 1]) {
                swap = child + 1;
            }

            if(child + 2 <= end && list[swap] < list[child + 2]) {
                swap = child + 2;
            }

            if(swap != root) {
                swap(list, root, swap);
                root = swap;
            } else {
                return;
            }
        }
    }

    private void heapify(int[] list) {
        int start = (list.length - 3) / 2;
        while(start >= 0) {
            siftDown(list, start, list.length - 1);
            start -= 1;
        }
    }

    public void sort(int[] list) {
        heapify(list);
        int end = list.length - 1;
        while(end > 0) {
            swap(list, end, 0);
            end -= 1;
            siftDown(list, 0, end);
        }
    }

    public static void main(String... args) {
        int[] list = {5, 6, 4, 9, 1, 2, 8, 7, 3};
        System.out.println("before: " + Arrays.toString(list));
        new TernaryHeapSort().sort(list);
        System.out.println("after: " + Arrays.toString(list));
    }
}
