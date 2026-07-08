import java.util.*;

class Heap {
    public int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Insert first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }

    public int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Kth smallest element is: " + heap.kthSmallest(arr, k));
    }

    
}