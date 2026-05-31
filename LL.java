class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }

}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
         next = null;
    }
}
 

public class LL{
    public static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i < arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void traverseLL(Node head){
        Node temp = head;// point temp at first node i.e head
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static int lengthLL(Node head){
        int count = 0;
        Node temp = head;// point temp at first node i.e head
        while(temp != null){
            temp = temp.next;
            count++;
        }

        return count;
    }

    public static boolean searchElement(Node head,int target){
        Node temp = head;
        while(temp != null){
            if(temp.data == target) return true;
            temp = temp.next;
        }
        return false;
    } 

    public static Node deleteHeadLL(Node head){
        if(head == null) return null; // if empty LL

        Node temp = head; //temp points head
        head = head.next; // head moves to next node
        temp.next = null; // temp i.e previously head is deleted // optional
        return head; // new head is returned
    }

    public static Node deleteTailLL(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    public static Node deleteKthNodeLL(Node head,int k){ // based on position
        if(head == null) return null;

        if(k==1){ // deleting head
            return deleteHeadLL(head);
        }

        // Node temp = head;
        // Node prev = null;
        // int count = 1;

        // while(temp != null){
        //     if(count == k){
        //         prev.next = prev.next.next;
        //         break;
        //     }
        //     prev = temp;
        //     temp = temp.next;
        //     count++;
        // }
        // return head;

        Node temp = head;
        int count = 1;

        while(temp != null && count < k-1){ // go this (k-1)th Node
            temp = temp.next;
            count++;
        }

        if(temp != null && temp.next != null){
            temp.next = temp.next.next;
        }

        return head;
    }

    public static Node deleteValLL(Node head,int val){
        if(head == null) return null; // empty LL

        if(head.data == val){ // head is val and is to be deleted
            head = head.next;
            return head;
        }

        Node temp = head;
        while(temp.next != null){ // go till the node before the one to be deleted, and then delete it
            if(temp.next.data == val){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node insertHeadLL(Node head,int val){
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        return head;
    }

    public static Node insertTailLL(Node head,int val){
        Node newNode = new Node(val);
        if(head == null) return newNode;

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        // newNode.next = null; //already initialized to null by constructor

        return head;

    }

    public static Node insertKthpos(Node head,int val,int k){
        Node newNode = new Node(val);
 
        if(k <= 0) return head;

        if(k == 1){ // insertion at head
            return insertHeadLL(head, val);
        }

        Node temp = head;
        int count = 1;

        while(temp != null && count < k - 1){
            temp = temp.next;
            count++;
        }

        if(temp != null){
            newNode.next = temp.next;
            temp.next = newNode;
        }

        return head;

    }

    public static Node insertBeforeGivenVal(Node head,int newVal,int targetVal){
        if (head == null) return null;


        Node newNode = new Node(newVal);
        Node temp =head;

        if(head.data == targetVal){
            newNode.next = head;
            head = newNode;
            return head;
        }

        while(temp.next != null){
            if(temp.next.data == targetVal){
                newNode.next = temp.next;
                temp.next = newNode;
                break; 
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node middleElementOptimal(Node head){

        if (head == null) return null;

        Node slow = head;

        Node fast = head;

        while(fast != null && fast.next != null){
            
            fast = fast.next.next;

            slow = slow.next;
        }

        return slow;

    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        } 

        return false;
    }

//slow == fast checks if both pointers are pointing to the same node (same memory location).
// Example:
// 1 → 2 → 3 → 4
//       ↑     ↓
//       ← ← ←
// If both slow and fast reach node 4, then:
// slow == fast   // true
// because they are the same node object.
// We don’t use:
// slow.val == fast.val
// because different nodes can have the same value.
// Example:
// 1 → 2 → 3 → 2 → null
// Here both nodes have value 2, but no cycle exists.
// So:
// slow.val == fast.val  // true ❌ (wrong)
// slow == fast          // false ✅
// Rule:
// == → compares node reference/address ✅
// .val == .val → compares only values ❌ for cycle detection


    public static void main(String[] args) {
        // Node one = new Node(4);
        // System.out.println(one.data);

        // int[] arr = {2,5,3,4,8};
        // Node head = convertArr2LL(arr);
        // //System.out.println(head.data);

        // traverseLL(head);
        // System.out.println("");
        //int length_of_LL = lengthLL(head);
        //System.out.println(length_of_LL);

        //int target = 7;
        //System.out.println(searchElement(head, target));

        // head = deleteHeadLL(head);
        // traverseLL(head);

        // head = deleteTailLL(head);
        // traverseLL(head);

        // head = deleteKthNodeLL(head, 1);
        // traverseLL(head);

        // head = deleteValLL(head,92);
        // traverseLL(head);

        // head = insertHeadLL(head, 1);
        // traverseLL(head);

        // head = insertTailLL(head, 10);
        // traverseLL(head);

        // head = insertKthpos(head, 15, 5);
        // traverseLL(head);

        //head = insertBeforeGivenVal(head,10,6);
        //traverseLL(head);

        // Node middle = middleElementOptimal(head);
        // System.out.println(middle.data);

        // System.out.println("");

        int[] arr = {2,5,3,4,8};
        Node head = convertArr2LL(arr);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = head2; // creating a cycle

        System.out.println(hasCycle(head2));

    }
}