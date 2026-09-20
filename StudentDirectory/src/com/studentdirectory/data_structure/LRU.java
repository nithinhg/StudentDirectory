package com.studentdirectory.data_structure;
import java.util.HashMap;
//Implement least recently used cache

public class LRU
{
    public class Node
    {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key,int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRU(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;

            remove(node);
            addToFront(node);

            return;
        }
        Node node = new Node(key, value);
        map.put(key,node);
        addToFront(node);

        if(map.size() > capacity)
        {
            Node leastUsed = tail.prev;
            remove(leastUsed);
        }
    }

    public int get(int key)
    {
        Node node = map.get(key);

        remove(node);
        addToFront(node);

        return node.value;
    }

    public void addToFront(Node node)
    {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void print()
    {
        Node current = head;
        while (current.next != tail)
        {
            current = current.next;
            System.out.print(current.value+" -> ");
        }
    }
    public static void main(String args[])
    {
        LRU lru = new LRU(10);

        lru.put(1,11);
        lru.put(2,12);
        lru.put(3,13);
        lru.put(4,14);
        lru.put(5,15);
        lru.put(6,16);
        lru.put(7,17);
        lru.put(8,18);
        lru.put(9,19);
        lru.put(10,20);

        lru.get(5);
        lru.get(9);

        lru.put(11,21);

        lru.print();
    }

}

