package gb.homework.lesson3.reversible.lists;

import gb.classwork.lesson3.lists.SinglyLinkedList;
import gb.homework.lesson3.reversible.Reversible;

import java.util.Arrays;

public class ReversibleSinglyLinkedList extends SinglyLinkedList implements Reversible {
    @Override
    public void reverse() {
        Node firstNodeToExchange = head;
        Node previousExchangedNode = null;
        while (firstNodeToExchange != previousExchangedNode && firstNodeToExchange != null){
            Node secondNodeToExchange = firstNodeToExchange;
            while (secondNodeToExchange.next() != previousExchangedNode && secondNodeToExchange.next() != null){
                secondNodeToExchange = secondNodeToExchange.next();
            }
            if(firstNodeToExchange == secondNodeToExchange)break;
            int temp = firstNodeToExchange.getValue();
            firstNodeToExchange.setValue(secondNodeToExchange.getValue());
            secondNodeToExchange.setValue(temp);
            previousExchangedNode = secondNodeToExchange;
            firstNodeToExchange = firstNodeToExchange.next();
        }
    }

}
