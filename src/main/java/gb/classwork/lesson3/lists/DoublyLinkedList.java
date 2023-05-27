package gb.classwork.lesson3.lists;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class DoublyLinkedList implements AbstractList{

    protected static class Node{
        protected Node next;
        protected Node previous;
        protected int value;
        Node(int value){
            this.value = value;
        }
        Node(){}
    }
    protected Node head;
    protected Node tail;
    public void addBegin(int value){
        Node node = new Node(value);
        if(head == null){
            head = tail = node;
        }
        else{
            head.previous = node;
            node.next = head;
            head = node;
        }
    }
    public void addEnd(int value){
        Node node = new Node(value);
        if(tail == null){
            head = tail = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
    public void removeEnd(){
        if(tail == null)return;
        if(tail.previous == null){
            head = tail = null;
        }
        else{
            tail = tail.previous;
            tail.next = null;
        }
    }
    public void removeBegin(){
        if(head == null)return;
        if(head.next == null)head = null;
        else {
            head = head.next;
            head.previous = null;
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
                int value = currentNode.value;
                currentNode = currentNode.next;
                return value;
            }
        };
    }
}
