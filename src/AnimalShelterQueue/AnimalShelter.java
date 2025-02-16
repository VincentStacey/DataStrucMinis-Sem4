package AnimalShelterQueue;

import java.util.LinkedList;

class AnimalShelter {
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        } else {
            if (dogs.peek().getOrder() < cats.peek().getOrder()) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }
    }

    public Dog dequeueDog() {
        return dogs.isEmpty() ? null : dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.isEmpty() ? null : cats.poll();
    }
}
