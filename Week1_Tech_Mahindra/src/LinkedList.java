class LinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static boolean hasCycle(Node head) {
        Node s = head, f = head;
        
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;

            if (s == f) {
                System.out.println("Cycle Detected!");
                return true;
            }
        }
        System.out.println("No Cycle Found!");
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.next.next.next.next.next = head.next;

        System.out.println("Checking for cycles...");
        hasCycle(head);
    }
}
