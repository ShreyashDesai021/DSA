import java.util.*;

class Pair{
    int first;
    String second;

    Pair(int f,String s){
        first = f;
        second = s;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class Heap {
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
        // Heap heap = new Heap();
        // int[] arr = {7, 10, 4, 3, 20, 15};
        // int k = 3;
        // System.out.println("Kth smallest element is: " + heap.kthSmallest(arr, k));
    
        //Min Heap on First, Min Heap in Second

        System.out.println("Min Heap on First, Min Heap in Second");

        PriorityQueue<Pair> pq1 = new PriorityQueue<>(
            (a,b) -> {
                if(a.first != b.first){
                    return a.first - b.first;
                }
                return a.second.compareTo(b.second);
            }
        );

        pq1.add(new Pair(1,"apple"));
        pq1.add(new Pair(2, "banana"));
        pq1.add(new Pair(1,"guava"));
        pq1.add(new Pair(1,"aardvark"));

        while (!pq1.isEmpty())
            System.out.println(pq1.poll());

            
        System.out.println("Min Heap on First, Max Heap on Second");    

        PriorityQueue<Pair> pq2 = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first)
                    return a.first - b.first;

                return b.second.compareTo(a.second);
            }
        );

        pq2.add(new Pair(1, "apple"));
        pq2.add(new Pair(2, "banana"));
        pq2.add(new Pair(1, "guava"));
        pq2.add(new Pair(1, "aardvark"));

        while (!pq2.isEmpty())
            System.out.println(pq2.poll());

        System.out.println("Max Heap on First, Min Heap on Second");

        PriorityQueue<Pair> pq3 = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first)
                    return b.first - a.first;

                return a.second.compareTo(b.second);
            }
        );

        pq3.add(new Pair(1, "apple"));
        pq3.add(new Pair(2, "banana"));
        pq3.add(new Pair(1, "guava"));
        pq3.add(new Pair(1, "aardvark"));

        while (!pq3.isEmpty())
            System.out.println(pq3.poll());

        System.out.println("Max Heap on First, Max Heap on Second");

        PriorityQueue<Pair> pq4 = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first)
                    return b.first - a.first;

                return b.second.compareTo(a.second);
            }
        );

        pq4.add(new Pair(1, "apple"));
        pq4.add(new Pair(2, "banana"));
        pq4.add(new Pair(1, "guava"));
        pq4.add(new Pair(1, "aardvark"));

        while (!pq4.isEmpty())
            System.out.println(pq4.poll());
    
    }

}