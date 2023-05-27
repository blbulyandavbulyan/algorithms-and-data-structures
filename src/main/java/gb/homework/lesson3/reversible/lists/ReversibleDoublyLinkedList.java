package gb.homework.lesson3.reversible.lists;

import gb.classwork.lesson3.lists.DoublyLinkedList;
import gb.homework.lesson3.reversible.Reversible;

public class ReversibleDoublyLinkedList extends DoublyLinkedList implements Reversible {
    @Override
    public void reverse() {
        Node firstNodeToExchange = head;
        Node secondNodeToExchange = tail;
        while (firstNodeToExchange != secondNodeToExchange){
            if(firstNodeToExchange.next() != secondNodeToExchange){
                int temp = firstNodeToExchange.getValue();
                firstNodeToExchange.setValue(secondNodeToExchange.getValue());
                secondNodeToExchange.setValue(temp);
                firstNodeToExchange = firstNodeToExchange.next();
                secondNodeToExchange = secondNodeToExchange.previous();
            }
            else break;
        }
    }

}
