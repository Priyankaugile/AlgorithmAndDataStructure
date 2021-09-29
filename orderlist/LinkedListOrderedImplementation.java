package com.orderlist;

import java.util.ArrayList;

public class LinkedListOrderedImplementation {
    String[] elements;
    Node head;

    public LinkedListOrderedImplementation(String[] elements) {
        this.elements = elements;
    }

    public void insertBefore() {
        String data;
        data = elements[0];

        Node newNode = new Node(data.toString());
        newNode.next = null;
        if(head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAt() {
        int index = elements.length - 1;
        Node temp = head;
        for(int i = 1; i < index; i++) {
            Node newNode = new Node(elements[i].toString());
            temp = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void insertEnd() {
        int i = elements.length-1;
        Node newNode = new Node(elements[i].toString());
        newNode.next = null;
        if(head == null)
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public <T> ArrayList<T> display() {
        Node temp = head;
        ArrayList<T> data = new ArrayList<>();
        while(temp != null) {
            System.out.print(temp.data + " ");
            data.add((T) temp.data);
            temp = temp.next;
        }
        return data;
    }
    public void display1() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public boolean search(String value) {
        for (String element : elements) {
            if (element.compareTo(value) == 0) {
                return true;
            }
        }
        return false;
    }

    public void deleteNode(String value) {
        int position = 0;
        for(int i=0; i< elements.length; i++) {
            if(elements[i].equals(value)) {
                position = i;
            }
        }

        if(head == null)
            return;

        Node temp = head;
        if(position == 0) {
            head = temp.next;
        }

        for(int i = 0; temp != null && i < position; i++)
            temp = temp.next;

        if(temp == null || temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    public void appendAtEnd(String value) {
        Node newNode = new Node(value);
        newNode.next = null;
        if(head == null)
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public void sortList() {
        Node current = head, index = null;
        String temp;
        if (head == null) {
        }
        else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if ((Integer.parseInt(index.data)) < (Integer.parseInt(current.data))){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}
