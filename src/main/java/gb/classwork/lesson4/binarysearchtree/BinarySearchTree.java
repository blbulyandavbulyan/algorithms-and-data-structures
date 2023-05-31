package gb.classwork.lesson4.binarysearchtree;

public class BinarySearchTree {
    private TreeNode head;
    private class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;
    }
    public boolean find(int value){
        TreeNode currentNode = head;
        while (currentNode != null){
            if(currentNode.value == value)return true;
            else if(value > currentNode.value){
                currentNode = currentNode.right;
            }
            else{
                currentNode = currentNode.left;
            }
        }
        return false;
    }
}
