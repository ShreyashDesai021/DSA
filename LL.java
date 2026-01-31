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

    public static void main(String[] args) {
        // Node one = new Node(4);
        // System.out.println(one.data);

        int[] arr = {2,5,6,8};
        Node head = convertArr2LL(arr);
        //System.out.println(head.data);

        traverseLL(head);
        System.out.println("");
        //int length_of_LL = lengthLL(head);
        //System.out.println(length_of_LL);

        //int target = 7;
        //System.out.println(searchElement(head, target));

        head = deleteHeadLL(head);
        traverseLL(head);


    }
}