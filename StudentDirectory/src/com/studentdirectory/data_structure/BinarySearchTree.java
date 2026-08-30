package com.studentdirectory.data_structure;

public class BinarySearchTree
{
    private static Node root;

    private static class Node
    {
        private int value;
        private Node left;
        private Node right;

        public Node(int value)
        {
            this.value = value;
        }
    }

    public void insert(int value)
    {
        root = insert(root,value);
    }

    public Node insert(Node node, int value)
    {
        if(node == null)
        {
            return new Node(value);
        }
        if(value < node.value)
        {
            node.left = insert(node.left,value);
        }
        else
        {
            node.right = insert(node.right,value);
        }
        return node;
    }

    public boolean search(Node node, int value)
    {
        if(node == null)
        {
            return false;
        }
        if(value == node.value)
        {
            return true;
        }
        if(value < node.value)
        {
            return search(node.left,value);
        }
        else
        {
            return search(node.right,value);
        }
    }

    public void inorder()
    {
        inorder(root);
        System.out.println();
    }

    public void inorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        inorder(node.left);
        System.out.print(node.value+" ");
        inorder(node.right);
    }

    public void preorder()
    {
        preorder(root);
        System.out.println();
    }

    public void preorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        System.out.print(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder()
    {
        postorder(root);
        System.out.println();
    }

    public void postorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value+" ");
    }

    public static void main(String[] strgs)
    {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(13);
        bst.insert(11);
        bst.insert(14);

        System.out.println(bst.search(root,5));
        System.out.println(bst.search(root,10));

        System.out.println("Inorder Tree Traversal");
        bst.inorder();

        System.out.println("Preorder Tree Traversal");
        bst.preorder();

        System.out.println("Postorder Tree Traversal");
        bst.postorder();
    }
}