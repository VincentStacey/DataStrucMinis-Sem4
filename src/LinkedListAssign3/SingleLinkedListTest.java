package LinkedListAssign3;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        System.out.println("Creating the linked list...");
        sll.createLinkedList(5);
        sll.traverseLinkedList();

        System.out.println("\nInserting nodes...");
        sll.insertNode(20, 1); // Insert at position 1
        sll.insertNode(30, 2); // Insert at position 2
        sll.insertNode(40, 3); // Insert at position 3
        sll.insertNode(50, 4); // Insert at position 4
        sll.insertNode(60, 6); // Insert at the end
        sll.traverseLinkedList();

        System.out.println("\nDeleting nodes...");
        sll.deleteNode(0); // Delete the first node
        System.out.println("\nDeleting First node...");
        sll.traverseLinkedList();

        sll.deleteNode(2); // Delete a node in the middle
        System.out.println("\nDeleting Middle node...");
        sll.traverseLinkedList();

        sll.deleteNode(5); // Delete the last node
        System.out.println("\nDeleting Last node...");
        sll.traverseLinkedList();
    }
}
