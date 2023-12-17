public class Stack<T> {
    private T[] data;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        if (capacity > 0){
            this.capacity = capacity;
            @SuppressWarnings("unchecked") T[]
            data = (T[]) new Object[this.capacity];
            this.data = data;
            size = 0;
        }
        else{
            System.out.println("Error with capacity\nProgram terminated :( ");
            System.exit(-1);
        }
    }

    public void push(T element) {
        if (capacity > size) {
            size++;
            data[size - 1] = element;
        } else {
            System.out.println("Error with push()\nProgram terminated :( ");
            System.exit(-1);
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Error with pop()\nProgram terminated :(");
            System.exit(-1);
        }
        T el = data[size-1];
        data[size-1] = null;
        size--;
        return el;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Error with peek()\nProgram terminated :(");
            System.exit(-1);
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}