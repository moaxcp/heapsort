import java.util.Arrays;

public class HeapSortSelectHeapSelectDary {

    public enum Heap { MINHEAP, MAXHEAP };

    private Heap heap;
    private int dary;

    public HeapSortSelectHeapSelectDary(Heap heap, int dary) {
        this.heap = heap;
        this.dary = dary;
    }

    private void swap(int[] list, int i, int j) {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }

    private void siftDown(int[] list, int start, int end) {
        switch(heap) {
            case MINHEAP:
                siftDownMin(list, start, end);
                break;
            case MAXHEAP:
                siftDownMax(list, start, end);
                break;
        }
    }

    private void siftDownMin(int[] list, int start, int end) {
        int root = start;

        while(root * dary + 1 <= end) {
            int swap = root;
            for(int i = 1; i <= dary; i++) {
                int child = root * dary + i;

                if(child <= end && list[swap] > list[child]) {
                    swap = child;
                }
            }

            if(swap != root) {
                swap(list, root, swap);
                root = swap;
            } else {
                return;
            }
        }
    }



    private void siftDownMax(int[] list, int start, int end) {
        int root = start;

        while(root * dary + 1 <= end) {
            int swap = root;
            for(int i = 1; i <= dary; i++) {
                int child = root * dary + i;

                if(child <= end && list[swap] < list[child]) {
                    swap = child;
                }
            }

            if(swap != root) {
                swap(list, root, swap);
                root = swap;
            } else {
                return;
            }
        }
    }

    public void heapify(int[] list) {
        int start = (list.length - dary) / 2;
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

    public static void runList(int[] list, Heap heap, int dary) {
        System.out.println("before: " + Arrays.toString(list));
        HeapSortSelectHeapSelectDary s = new HeapSortSelectHeapSelectDary(heap, dary);
        s.heapify(list);
        System.out.println(heap + ": " + Arrays.toString(list));
        s.sort(list);
        System.out.println("after: " + Arrays.toString(list));
    }

    public static void main(String... args) {
        int[] list = {5, 6, 4, 9, 1, 2, 0, 8, 7, 3, 15, 13, 11, 10, 12};
        runList(list, HeapSortSelectHeapSelectDary.Heap.MINHEAP, 4);
        list = new int[] {7, 9, 2, 6, 4, 1, 0, 3, 5, 8, 15, 13, 11, 10, 12};
        runList(list, HeapSortSelectHeapSelectDary.Heap.MAXHEAP, 4);
    }
}
