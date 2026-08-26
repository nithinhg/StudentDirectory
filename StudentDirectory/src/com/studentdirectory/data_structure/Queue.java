package com.studentdirectory.data_structure;

public class Queue
{
    private int front;
    private int rear;
    private final int[] arr;
    private final int capacity;
    private int size;

    public Queue(int capacity)
    {
        this.arr=new int[capacity];
        this.capacity=capacity;
        this.front=0;
        this.size=0;
        this.rear=-1;
    }

    public void enqueue(int value)
    {
        if(size==capacity)
        {
            throw new RuntimeException("Can't Enqueue. Queue is Full!");
        }
        rear=(rear+1)%capacity;
        arr[rear]=value;
        size++;
    }

    public int dequeue()
    {
        if(size==0)
        {
            throw new RuntimeException("Can't Dequeue. Queue is Empty!");
        }
        int value = arr[front];
        size--;
        front=(front+1)%capacity;
        return value; 
    }

    public int peek()
    {
        if(size==0)
        {
            throw new RuntimeException("Can't Peak. Queue is Empty!");
        }
        return arr[front]; 
    }

    public boolean isEmpty()
    {
        return size==0; 
    }

    public boolean isFull()
    {
        return size==capacity; 
    }

    public int size()
    {
        return size; 
    }

    public void list()
    {
        if(size==0)
        {
            throw new RuntimeException("Can't Peak. Queue is Empty!");
        } 
        for(int i=rear;i>=front;i--)
        {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] strgs)
    {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("After Enqueue ");
        queue.list();

        queue.dequeue();
        queue.dequeue();

        System.out.println("After Dequeue ");
        queue.list();

        System.out.println("Peek element (to be dequeued next) = " + queue.peek());

        System.out.println("isEmpty = " + queue.isEmpty());

        System.out.println("isFull = " + queue.isFull());
    }
}