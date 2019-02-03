public class ArrayStack<E> implements Stack<E>
{
    private E[] elements;
    private int size;

    public ArrayStack(int size)
    {
        this.size = size;

        elements = (E[]) new Object[size];
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void push(E e)
    {

    }

    public E top()
    {


    }

    public E pop()
    {

    }
}
