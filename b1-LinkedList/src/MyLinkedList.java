
public class MyLinkedList<T> {

    transient MyLinkedList.Node<T> first;

    transient MyLinkedList.Node<T> last;

    private int size = 0;

    public MyLinkedList() {
    }


    public void add(T item) {
        final MyLinkedList.Node<T> end = last;
        final MyLinkedList.Node<T> newNode = new MyLinkedList.Node<>(end, item, null);
        last = newNode;
        if (end == null) {
            first = newNode;
        } else {
            end.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        extracted(index);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public void delete(int index) {
        extracted(index);
        if (index == 0) {
            first = first.next;
        } else if (index == size - 1) {
            if (last.prev != null) {
                last.prev.next = null;
            }
            last = last.prev;
        } else {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    private void extracted(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("인덱스가 작거나 큽니다.");
        }
    }

    private static class Node<T> {

        T item;
        MyLinkedList.Node<T> next;
        MyLinkedList.Node<T> prev;

        Node(MyLinkedList.Node<T> prev, T element, MyLinkedList.Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.item);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
