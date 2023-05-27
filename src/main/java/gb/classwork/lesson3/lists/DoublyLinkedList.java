package gb.classwork.lesson3.lists;

public class DoublyLinkedList {
    private static class Node{
        Node next;
        Node previous;
        int value;
        Node(int value){
            this.value = value;
        }
        Node(){}
    }
    private Node head;
    private Node tail;
    /**
     * Функция добавляет элемент в начало списка
     * */
    public void add(int value){
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

}
