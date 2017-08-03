public class maxHeap {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4, 7, 8, 9, 7};
        System.out.println(findKthLargest(a, 1));
        int[] b = {-1, 2, 0};
        System.out.println(findKthLargest(b, 3));
        int[] c = {3, 1, 2, 4};
        new maxHeap().heapSort(a);
        System.out.println();
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        heap[0] = nums[0];
        for (int i = 1; i < k; i++) {
            siftUp(nums[i], heap, i);            //建堆的过程shiftUp
        }
        for (int i = k; i < nums.length; i++) {
            siftDown(nums, k, heap, i);      //调整堆的过程
        }
        return heap[0];
    }

    private static void siftDown(int[] nums, int k, int[] heap, int i) {
        if (nums[i] > heap[0]) {
            heap[0] = nums[i];              //从上往下调整
            int p = 0;
            while (p < k) {
                int minChild = p << 1 + 1;
                if (minChild + 1 < k && heap[minChild] > heap[minChild + 1]) minChild++; //先求出两孩子中较小者
                if (minChild < k && heap[p] > heap[minChild]) {
                    swap(heap, p, minChild);
                    p = minChild;
                } else break;
            }
        }
    }

    private static void siftUp(int num, int[] heap, int i) {
        int p = i;
        heap[i] = num;
        while (p != 0) {
            int parent = (p - 1) >> 1;
            if (heap[parent] > heap[p]) {
                swap(heap, p, parent);
            }
            p = parent;
        }
    }

    private static void swap(int[] heap, int p, int parent) {
        int temp = heap[parent];
        heap[parent] = heap[p];
        heap[p] = temp;
    }

    public void heapSort(int[] array){
        int heapSize = array.length;
        buildHeap(array, heapSize);
        for (int i=0;i<heapSize;i++){
            System.out.print(array[i] + " ");
        }
        for (int i=0;i<array.length;i++){
            swap(array, 0, heapSize-1);
            heapSize--;
            Maxify(array, 0, heapSize);
        }
    }
    public void buildHeap(int[] array, int heapSize){
        int half = heapSize >> 1;
        for (int i=half-1;i>=0;i--){
            Maxify(array, i, heapSize);
        }
    }
    public void Maxify(int[] array, int i, int heapSize){
        int l = (i << 1) + 1, r = (i+1) << 1, largest = i;
        if (l<heapSize && array[l] > array[largest]){
            largest = l;
        }
        if (r<heapSize && array[r] > array[largest]){
            largest = r;
        }
        if (i==largest || largest >= heapSize)
            return;
        swap(array, i, largest);
        Maxify(array, largest, heapSize);
    }
}

