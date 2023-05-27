package gb.homework.lesson3.main;

import gb.homework.lesson3.reversible.lists.ReversibleSinglyLinkedList;

public class TestReversingSinglyLinkedList {
    public static void main(String[] args) {
        ReversibleSinglyLinkedList list = new ReversibleSinglyLinkedList();
        for (int i = 0; i < 101; i++) {
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
