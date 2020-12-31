
public interface  Deque<Item> {
    Item removeLast();

    Item removeFirst();

    Item get(int index);

    void addFirst(Item item);

    void addLast(Item item);

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    void printDeque();

}