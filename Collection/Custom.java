package Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

class CustomList implements Iterable<String>{
    private String[] items;
    private int size = 0;

    public CustomList(int capacity) {
        items = new String[capacity];
    }

    public void add(String item) {
        if (size < items.length) {
            items[size++] = item;
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<String> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[cursor++];
        }
    }
}

public class Custom {
    public static void main(String[] args) {
        CustomList list = new CustomList(5);
        list.add("apple");
        list.add("orange");
        list.add("banana");
        list.add("lichi");
        list.add("grapes");

        for(String item : list) {
            System.out.println(item);
        }

        System.out.println("Compilor did it behind the scene");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }
    }
}

