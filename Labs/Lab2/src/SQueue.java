public class SQueue<E>
{
    ArrayStack<E> queueStackOne = new ArrayStack<E>();
    ArrayStack<E> queueStackTwo = new ArrayStack<E>();
    
    public SQueue() 
    {
    }
    
    public void push(E e) 
    {
        while(!queueStackOne.empty())
        {
            queueStackTwo.push(queueStackOne.pop());
        }
        
        queueStackTwo.push(e);
        
        while(!queueStackTwo.empty())
        {
            queueStackOne.push(queueStackTwo.pop());
        }
    }
    
    public int pop() 
    {
        return queueStackOne.pop();
    }
    
    public int peek() 
    {
        return queueStackOne.peek();
    }
    
    public boolean empty() 
    {
        return queueStackOne.empty();
    }
}
