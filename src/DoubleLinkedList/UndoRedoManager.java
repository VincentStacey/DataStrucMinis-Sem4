package DoubleLinkedList;

/**
 * Implememt an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowoing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // Add a new state
    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState != null) {
            newNode.prev = currentState;
            currentState.next = newNode;
        }
        currentState = newNode;
    }

    // Undo operation
    public T undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            return currentState.state;
        }
        return null;
    }

    // Redo operation
    public T redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            return currentState.state;
        }
        return null; // No next state available
    }

    // Get the current state
    public T getCurrentState() {
        return currentState != null ? currentState.state : null;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");
        manager.addState("State 4");
        manager.addState("State 5");

        System.out.println("Current State: " + manager.getCurrentState());

        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());

        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Redo: " + manager.redo());
    }
}
