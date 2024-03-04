package com.company;

import org.w3c.dom.Node;

public class LinkedList {

    Nodem head;

    static class Nodem {
        int data;
        Nodem next;
        Nodem (int data){
            this.data = data;
            next = null;
        }
    }

    public static LinkedList insert (LinkedList list, int data){
        Nodem newNode = new Nodem(data);

        if(list.head == null) {
            list.head = newNode;
        }
        else{
            Nodem last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printList(LinkedList list){
        Nodem currNode = list.head;
        System.out.println("LinkedList: ");

        while(currNode != null){

            System.out.println(currNode.data+ " "+System.identityHashCode(currNode));
            currNode = currNode.next;
        }
    }

    public static LinkedList deleteByKey(LinkedList list, int data){
        Nodem currNode = list.head, prev = null;

        // case 1 at start
        if(currNode != null && currNode.data == data){
            list.head = currNode.next;
            System.out.println(data+" found and deleted from list");
            return list;
        }

        // case 2 somewhere in the middle but not at start
        while (currNode != null && currNode.data != data){
            prev = currNode;
            currNode = currNode.next;
        }
        if(currNode != null){
            prev.next = currNode.next;
            System.out.println(data+ " found and deleted from the list");
        }

        // case 3 key not in the list
        if (currNode == null) System.out.println("key not found");

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        list = insert(list, 9);

        deleteByKey(list, 7);
        deleteByKey(list, 4);
        deleteByKey(list, 4);
        printList(list);
    }
}
