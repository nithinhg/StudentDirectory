package com.studentdirectory.data_structure;

public class LinkedList
{
    private static class Node
    {
        private int data;
        private Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    private static Node head;
    private int size;

    public LinkedList()
    {
        head=null;
        size=0;
    }

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        newNode.next=head;
        head=newNode;
        size++;
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head != null)
        {
            Node current = head;
            while(current.next != null)
            {
                current=current.next;
            }
            current.next=newNode;
        }
        else
        {
            newNode.next=head;
            head=newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int data)
    {
        if(index>size)
        {
            System.out.println("Invalid Index!");
            return;
        }
        Node newNode = new Node(data);
        int counter = 0;
        if(head != null && index !=0)
        {
            Node current = head;
            while(current.next != null && counter < index-1)
            {
                current=current.next;
                counter++;
            }
            newNode.next=current.next;
            current.next=newNode;
        }
        else
        {
            newNode.next=head;
            head=newNode;
        }
        size++;
    }

     public void removeFirst()
    {
        if(head != null)
        {
             head=head.next;
        }
        size--;
    }

    public void removeLast()
    {
        if(head != null)
        {
            Node current = head;
            Node prev = null;
            while(current.next != null)
            {
                prev=current;
                current=current.next;
            }
            prev.next=null;
        }
        size--;
    }

    public void removeAtIndex(int index)
    {
        if(index>size)
        {
            System.out.println("Invalid Index!");
            return;
        }
        int counter = 0;
        if(head != null && index !=0)
        {
            Node current = head;
            while(current.next != null && counter < index-1)
            {
                current=current.next;
                counter++;
            }
            current.next=current.next.next;
        }
        else
        {
            head=head.next;
        }
        size--;
    }

    public boolean contains(int data)
    {
        if(head != null)
        {
            Node current = head;
            while(current.next != null)
            {
                if(current.data == data)
                {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    
    public void reverse()
    {
        Node previous = null;
        Node current = head;
        while (current != null)
        {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void print()
    {
        if(head != null)
        {
            Node current = head;
            System.out.print(current.data+" -> ");
            while(current.next != null)
            {
                current=current.next;
                System.out.print(current.data+" -> ");
                if(current.next == null)
                {
                    System.out.print("null ");
                }
            }
        }
        else
        {
            System.out.print("null ");
        }
    }

    public static void main (String[] args)
    {
        LinkedList list = new LinkedList();

        list.print();
        System.out.println();

        list.addFirst(2);
        list.addFirst(1);

        list.print();
        System.out.println();

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        list.print();
        System.out.println();

        list.addAtIndex(2,3);
        list.print();
        System.out.println();

        list.removeFirst();
        list.print();
        System.out.println();

        list.removeLast();
        list.print();
        System.out.println();

        list.removeAtIndex(1);
        list.print();
        System.out.println();

        boolean contains = list.contains(5);
        System.out.println(contains);

        contains = list.contains(2);
        System.out.println(contains);

        list.reverse();
        list.print();
        System.out.println();
    }
}