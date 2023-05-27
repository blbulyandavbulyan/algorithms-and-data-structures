package gb.homework.lesson3.main;

import gb.homework.lesson3.reversible.lists.ReversibleSinglyLinkedList;

public class TestReversingSinglyLinkedList {
    public static void main(String[] args) {
        ReversibleSinglyLinkedList reversibleSinglyLinkedList = new ReversibleSinglyLinkedList();
        for (int i = 0; i < 101; i++) {
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
