package com.studentdirectory.data_structure;

public class DoublyLinkedList
{
    public static class Node
    {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    private Node head;
    int size;

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        size++;
    }

    public void removeFirst()
    {
        if(head==null) 
        {
            System.out.println("list is empty");
            return;
        }
        head=head.next;
        size--;
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head=newNode;
        }
        Node current = head;
        while(current.next != null)
        {
            current=current.next;
        }
        current.next=newNode;
        newNode.prev=current;
        newNode.next=null;
        size++;
    }

    public void removeLast()
    {
        if(head==null) 
        {
            System.out.println("list is empty");
            return;
        }
        Node current = head;
        while(current.next != null)
        {
            current=current.next;
        }
        current=current.prev;
        current.next=null;
        size--;
    }

    public void addAtIndex(int data, int index)
    {
        if(index==size)
        {
            addLast(data);
            return;
        }
        if(index==0)
        {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current=head;
        int counter=1;
        while(current.next != null)
        {
            if(index==counter)
            {
                newNode.next=current.next;
                newNode.prev=current;
                current.next=newNode;
                current.next.next.prev=newNode;
                size++;
                return;
            }
            current=current.next;
            counter++;
        }
        size++;
    }

    public void removeAtIndex(int index)
    {
        if(index==size)
        {
            removeLast();
            return;
        }
        if(index==0)
        {
            removeFirst();
            return;
        }
        Node current = head;
        int counter=1;
        while(current.next != null)
        {
            if(index==counter)
            {
                current.next=current.next.next;
                current.next.prev=current;
                size--;
                return;
            }
            current=current.next;
            counter++;
        }
        size--;
    }

    public void print()
    {
        Node current;
        if (head==null)
        {
            System.out.println("List is empty!");
            return;
        }
        else
        {
            current=head;
            while(current!=null)
            {
                System.out.print(current.data+" <-> ");
                current=current.next;
            }
            System.out.print("NULL ");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        list.addAtIndex(4,2);
        list.addAtIndex(9,7);
        list.addAtIndex(0,0);
        list.addAtIndex(8,6);

        list.print();

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        list.print();

        list.removeLast();
        list.removeLast();
        list.removeLast();

        list.print();

        list.removeAtIndex(2);

        list.print();
    }
}