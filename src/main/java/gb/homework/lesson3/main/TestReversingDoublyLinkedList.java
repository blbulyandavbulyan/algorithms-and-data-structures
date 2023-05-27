package gb.homework.lesson3.main;

import gb.homework.lesson3.reversible.lists.ReversibleDoublyLinkedList;

public class TestReversingDoublyLinkedList {
    public static void main(String[] args) {
        ReversibleDoublyLinkedList list = new ReversibleDoublyLinkedList();
        for (int i = 0; i < 11; i++) {
            list.addEnd(i);
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        list.reverse();
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
