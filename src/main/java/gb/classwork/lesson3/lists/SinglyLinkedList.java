package gb.classwork.lesson3.lists;


import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SinglyLinkedList implements AbstractList{

    protected static class Node{
        protected Node next;
        protected int value;
        public int getValue(){
            return value;
        }
        public void setValue(int value){
            this.value = value;
        }
        public Node next(){
            return next;
        }
    }
    protected Node head;
    public void addBegin(int value){
        Node newNode = new Node();
        newNode.value = value;
        if(head != null) newNode.next = head;
        head = newNode;
    }
    public void removeBegin(){
        if(head != null){
            head = head.next;
        }
    }
    public boolean find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if(currentNode.value == value)return true;
            currentNode = currentNode.next;
        }
        return false;
    }
    public void addEnd(int value){
        Node newNode = new Node();
        newNode.value = value;
        if(head == null)head = newNode;
        else{
            Node lastNode = head;
            while (lastNode.next != null)lastNode = lastNode.next;
            lastNode.next = newNode;
        }
    }
    public void removeEnd(){
        if(head != null){
            Node preLastElement = head;
            while (preLastElement.next != null){
                if(preLastElement.next.next == null){
                    preLastElement.next = null;
                    return;
                }
                preLastElement = preLastElement.next;
            }
            head = null;
        }
    }
    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }
            @Override
            public Integer next() {
                int value = currentNode.getValue();
                currentNode = currentNode.next;
                return value;
            }
        };
    }
}
