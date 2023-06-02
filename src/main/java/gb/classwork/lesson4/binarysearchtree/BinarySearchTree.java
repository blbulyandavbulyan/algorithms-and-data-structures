package gb.classwork.lesson4.binarysearchtree;

public class BinarySearchTree {
    private TreeNode head;

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
    private void balanceAfterAdd(TreeNode addedNode){
        TreeNode balancedNode = addedNode;
        while (!balancedNode.isBlack()){
            if(balancedNode == head){
                balancedNode.color = TreeNode.ColorOfNode.BLACK;
                return;
            }
            TreeNode x = balancedNode;
            TreeNode y = x.parent;
            if(x.isRed() && y.isRed()){
                TreeNode g = y.parent;
                //оба ребёнка красные
                if(g.isBothChildRed())g.swapColor();
                else{//дядя чёрный
                    if(g.isThisLeftChild(y)){//нам нужно убедиться что y - левый ребёнок нашего дерева, если это не так, то нужно сделать поворот

                    }
                    else {
                        //делаем y - левым
                    }

                    if(y.isThisLeftChild(x)){
                        balancedNode = g.rotateRight();
                    }
                }

            }
        }
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
