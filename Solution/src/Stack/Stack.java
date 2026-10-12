package Stack;

import java.util.EmptyStackException;

public class Stack<E> implements IStack<E> {
    Node top = null;
    @Override
    public void push(E e) {
        top = new Node(e, top);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node node = top;
        E e = (E) node.data;
        top = node.next;


        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node node = top;
        E e = (E) top.data;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        int size = 0;
        for(Node<E> node = top; node != null; node = node.next) {
            size ++;
        }
        return size;
    }
}
