package gb.classwork.lesson4.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < 100; i++){
            binarySearchTree.add(i);
        }
//
//        binarySearchTree.add(24);
//        binarySearchTree.add(5);
//        binarySearchTree.add(1);
        for (int i = 0; i < 100; i++){
            if(!binarySearchTree.find(i)){
                System.out.println("Элемента " + i + " в дереве нет!");
            }
        }
        System.out.println("Конец");
    }
}
