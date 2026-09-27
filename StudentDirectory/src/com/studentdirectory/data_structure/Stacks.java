package com.studentdirectory.data_structure;
import java.util.Stack;

public class Stacks
{
    private final int arr[];
    private final int capacity;
    private int top;
    
    public Stacks(int capacity)
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

    //Valid Paranthesis
    /*Input: s = "()[]{}"
    Output: true*/
    public boolean isValid(String s) {
        boolean isValid = true;
        Character c;
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++)
        {
            c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{')
            {
                stack.push(c);
            }
            if(c==')')
            {
                if(!stack.isEmpty() && stack.peek()=='('){stack.pop();}
                else{isValid=false;}
            }
            if(c==']')
            {
                if(!stack.isEmpty() && stack.peek()=='['){stack.pop();}
                else{isValid=false;}
            }
            if(c=='}')
            {
                if(!stack.isEmpty() && stack.peek()=='{'){stack.pop();}
                else{isValid=false;}
            }
        }
        return (isValid && stack.isEmpty());
    }

    public static void main(String[] args)
    {
        Stacks stacks = new Stacks(4);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);

        System.out.println("Stack After Push = ");
        stacks.list();

        stacks.pop();
        stacks.pop();

        System.out.println("Stack After Pop = ");
        stacks.list();

        System.out.println("Stack Peek = "+stacks.peek());
        System.out.println("Stack isEmpty = "+stacks.isEmpty());
        System.out.println("Stack isFull = "+stacks.isFull());
        
        String s = "()[]{(}";
        if(stacks.isValid(s))
        {
            System.out.println("Is valid");
        }
        else
        {
            System.out.println("NOT valid");
        }
    }
}

