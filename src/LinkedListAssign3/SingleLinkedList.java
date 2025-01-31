package LinkedListAssign3;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Create a new Linked List with the first node
    public void createLinkedList(int nodeValue) {
        Node node = new Node(nodeValue);
        head = node;
        tail = node;
        size = 1;
    }

    // Insert a node into the linked list
    public void insertNode(int nodeValue, int location) {
        Node newNode = new Node(nodeValue);
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        }
        if (location == 0) {
            newNode.next = head;
            head = newNode;
        } else if (location >= size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = newNode;
            newNode.next = nextNode;
        }
        size++;
    }

    // Delete a node from the linked list
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The list does not exist.");
            return;
        }
        if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size - 1) {
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) { // If only one element exists
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else { // Delete a node from a specific position
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // Traverse and print the linked list
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Node tempNode = head;
            while (tempNode != null) {
                System.out.print(tempNode.value + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("null");
        }
    }
}
