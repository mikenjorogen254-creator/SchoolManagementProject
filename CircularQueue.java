package schoolmanagement;

public class CircularQueue<T> {
    private T[] data;
    private int head = 0, tail = 0, size = 0, capacity;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        this.capacity = Math.max(4, capacity);
        this.data = (T[]) new Object[this.capacity];
    }

    public boolean enqueue(T item) {
        if (size == capacity) return false;
        data[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public T dequeue() {
        if (size == 0) return null;
        T item = data[head];
        data[head] = null;
        head = (head + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
