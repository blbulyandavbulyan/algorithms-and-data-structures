package gb.classwork.lesson3.lists;

public class OneLinkedList implements AbstractList{
    private static class Node{
        Node next;
        int value;
    }
    Node head;
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
}
