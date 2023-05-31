package gb.classwork.lesson4.binarysearchtree;

public class BinarySearchTree {
    private TreeNode head;
    private class TreeNode{
        enum ColorOfNode {BLACK, RED, TWICE_BLACK}
        private int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;
        private ColorOfNode color = ColorOfNode.RED;
        public TreeNode(int value) {
            this.value = value;
        }
        public boolean isRed(){
            return color == ColorOfNode.RED;
        }
        public boolean isBlack(){
            return color == ColorOfNode.BLACK;
        }
        public boolean isRightBlack(){
            return right == null || right.isBlack();
        }
        public boolean isLeftBlack(){
            return left == null || left.isBlack();
        }

    }
    public boolean find(int value){
        TreeNode currentNode = head;
        while (currentNode != null){
            if(currentNode.value == value)
                return true;
            else if(value > currentNode.value){
                currentNode = currentNode.right;
            }
            else{
                currentNode = currentNode.left;
            }
        }
        return false;
    }
    public void add(int value){
        balanceAfterAdd(insertNode(new TreeNode(value)));
    }
    private void balanceAfterAdd(TreeNode addedTreeNode){
//        if(head == addedTreeNode)
    }
    private TreeNode insertNode(TreeNode insertedNode){
        if(head == null){
            head = insertedNode;
        }
        else{
            TreeNode currentNode = head;
            while (currentNode.left != null && currentNode.right != null){
                if(insertedNode.value > currentNode.value)currentNode = currentNode.right;
                else if(insertedNode.value < currentNode.value)currentNode = currentNode.left;
                else throw new RuntimeException("Ключ уже добавлен!");
            }
            insertedNode.parent = currentNode;
            if(currentNode.left != null)currentNode.right = insertedNode;
            else currentNode.left = insertedNode;
        }

        return insertedNode;
    }
}
