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


class Pair2{
    int first;
    int second;

    Pair2(int f,int s){
        first = f;
        second = s;
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

    public static int[] topKFrequent(int[] nums, int k){
        
        PriorityQueue<Pair2> pq = new PriorityQueue<>(
           (a,b) -> {
                if(a.second != b.second){
                    return b.second - a.second;
                }
                return b.first - a.first;
           } 
        );

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int a = entry.getKey(); 
            int b = entry.getValue();

            pq.offer(new Pair2(a,b));
        }

        int[] arr = new int[k];

        for(int i = 0;i < k;i++){
            arr[i] = pq.poll().first;
        }

        return arr;
    }

    public static int[] topKFrequentOptimal(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min Heap based on frequency
        PriorityQueue<Pair2> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.second != b.second) {
                    return a.second - b.second;
                }
                return a.first - b.first;
            }
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int element = entry.getKey();
            int freq = entry.getValue();

            Pair2 curr = new Pair2(element, freq);

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }

            if (curr.second > pq.peek().second) {
                pq.poll();
                pq.offer(curr);
            }
        }

        int[] ans = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            ans[i++] = pq.poll().first;
        }

        return ans;
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