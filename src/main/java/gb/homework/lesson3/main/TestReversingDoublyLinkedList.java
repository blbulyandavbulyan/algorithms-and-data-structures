package gb.homework.lesson3.main;

import gb.homework.lesson3.reversible.lists.ReversibleDoublyLinkedList;

public class TestReversingDoublyLinkedList {
    public static void main(String[] args) {
        ReversibleDoublyLinkedList reversibleSinglyLinkedList = new ReversibleDoublyLinkedList();
        for (int i = 0; i < 11; i++) {
            reversibleSinglyLinkedList.addEnd(i);
        }
        for (Integer i : reversibleSinglyLinkedList) {
            System.out.print(i + " ");
        }
        System.out.println();
        reversibleSinglyLinkedList.reverse();
        for (Integer i : reversibleSinglyLinkedList) {
            System.out.print(i + " ");
        }
    }
}
