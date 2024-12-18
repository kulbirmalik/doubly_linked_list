public class DoublyLinkedList {

    Node head = new Node(0);
    Node tail = new Node(0);

    public DoublyLinkedList(){
        head.next = tail;
        tail.prev = head;
    }

    // method used to add value to the end of doubly linked list
    public void addLast(int value) {
        Node node = new Node(value);
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
    }

    // method used to add value to the front of doubly linked list
    public void addFirst(int value) {
        Node node = new Node(value);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    // method used to remove elements from doubly linked list
    public void remove(int value){
        Node cur = head.next;
        if(head.next == tail) {
            System.out.println("No element to remove.");
            return;
        }

        while(cur.next!=tail){
            if(cur.value == value){
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
                cur.next = null;
                cur.prev = null;
                return;
            }
            cur = cur.next;
        }

        // if we need to remove last element from the doubly linked list
        if(cur.value == value){
            cur.prev.next = tail;
            tail.prev = cur.prev;
            cur.prev = null;
            cur.next = null;
            return;
        }

        System.out.println("No matching value found in the doubly linked list");
    }

    // Remove front node from the list
    public void removeFront(){
        if(head.next == tail){
            System.out.println("No elements present in the list");
        }else{
            Node cur = head.next;
            cur.next.prev = head;
            head.next = cur.next;
            cur.next = null;
            cur.prev = null;
        }
    }

    // Remove last node from the list
    public void removeLast(){
        if(head.next == tail){
            System.out.println("No elements present in the list");
        }else{
            Node cur = tail.prev;
            cur.prev.next = tail;
            tail.prev = cur.prev;
            cur.prev = null;
            cur.next = null;
        }
    }

    // method used to print the doubly linked list
    public void printLinkedList() {
        if(head.next == tail){
            System.out.println("No elements present in the doubly linked list.");
        }else{
            StringBuilder dll = new StringBuilder();
            Node cur = head.next;
            while(cur.next != tail){
                dll.append(cur.value);
                dll.append(" ----- ");
                cur = cur.next;
            }
            dll.append(cur.value);
            System.out.println(dll);
        }
    }

}
