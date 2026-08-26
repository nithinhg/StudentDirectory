package com.studentdirectory.data_structure;

public class Stack
{
    private final int arr[];
    private final int capacity;
    private int top;
    
    public Stack(int capacity)
    {
        this.capacity=capacity;
        this.top=-1;
        this.arr=new int[capacity];
    }

    public void push(int value)
    {
        if(top==capacity-1)
        {
            throw new RuntimeException("Can't Push. Stack is Full!");
        }
        arr[++top]=value;
    }
    
    public int pop()
    {
        if(top==-1)
        {
            throw new RuntimeException("Can't pop. Stack is empty!");
        }
    return arr[top--];
    }

    public int peek()
    {
        if(top==-1)
        {
            throw new RuntimeException("Can't peek. Stack is empty!");
        }
    return arr[top];
    }

    public boolean isEmpty()
    {
        return top==-1;
    }

    public boolean isFull()
    {
        return top==capacity-1;
    }

    public void list()
    {
        if(top==-1)
        {
            throw new RuntimeException("Can't peek. Stack is empty!");
        }
        else
        {
            for(int i=top;i>=0;i--)
            {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        Stack stack = new Stack(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Stack After Push = ");
        stack.list();

        stack.pop();
        stack.pop();

        System.out.println("Stack After Pop = ");
        stack.list();

        System.out.println("Stack Peek = "+stack.peek());

        System.out.println("Stack isEmpty = "+stack.isEmpty());

        System.out.println("Stack isFull = "+stack.isFull());
    }
}

