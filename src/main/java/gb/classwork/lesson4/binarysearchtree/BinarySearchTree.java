package gb.classwork.lesson4.binarysearchtree;

import gb.classwork.lesson4.binarysearchtree.exceptions.KeyAlreadyAddedException;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Iterator;

public class BinarySearchTree implements Iterable<TreeNode>{
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
        TreeNode insertedNode = insertNode(new TreeNode(value));
        balanceAfterAdd(insertedNode);
    }
    private void balanceAfterAdd(TreeNode addedNode){
        TreeNode x = addedNode;
        while ((x.parent != null && x.parent.color != TreeNode.ColorOfNode.BLACK) || (x.isRed() && x.isRight())){
            TreeNode father = x.parent;
            if(x.isRed() && x.isRight() && father.isBlack()){
                if(father.isBothChildRed()){
                    father.swapColor();
                    x = father;
                }
                else {
                    father.color = TreeNode.ColorOfNode.RED;
                    x.color = TreeNode.ColorOfNode.BLACK;
                    var possibleNewRoot = father.rotateLeft();
                    if(!possibleNewRoot.hasParent())head = possibleNewRoot;
                    break;
                }
            }
            else if(x.isRed() && father.isRed()){
                TreeNode grandfather = father.parent;
                //оба ребёнка у деда чёрные
                if(grandfather.isBothChildRed()) {
                    grandfather.swapColor();
                    x = grandfather;
                }
                else{//дядя чёрный
                    if(father.isLeft()){//нам нужно убедиться что father - левый ребёнок нашего деда
                        if(x.isRight()){//x - правый сын отца
                            x = father;
                            x.rotateLeft();
                        }
                        else{//x - левый сын отца
                            father.color = TreeNode.ColorOfNode.BLACK;
                            grandfather.color = TreeNode.ColorOfNode.RED;
                            x = grandfather;
                            TreeNode n = grandfather.rotateRight();
                            if(n.parent == null)head = n;//в результате поворота мог измениться корень
                        }
                    }
                    else {//father - правый ребёнок нашего деда
                        if(x.isLeft()){
                            x = father;
                            x.rotateRight();
                        }
                        else{
                            father.color = TreeNode.ColorOfNode.BLACK;
                            grandfather.color = TreeNode.ColorOfNode.RED;
                            x = grandfather;
                            TreeNode n = grandfather.rotateLeft();
                            if(n.parent == null)head = n;//в результате поворота мог измениться корень

                        }
                    }
                }
            }
        }
        head.color = TreeNode.ColorOfNode.BLACK;
    }
    private TreeNode insertNode(TreeNode insertedNode){
        if(head == null){
            head = insertedNode;
//            head.color = TreeNode.ColorOfNode.BLACK;
        }
        else{
            TreeNode currentNode = head;
            while (currentNode.left != null || currentNode.right != null){
                if(insertedNode.value > currentNode.value) {
                    if(currentNode.right == null)break;
                    currentNode = currentNode.right;
                }
                else if(insertedNode.value < currentNode.value) {
                    if(currentNode.left == null)break;
                    currentNode = currentNode.left;
                }
                else throw new KeyAlreadyAddedException("Ключ %d уже добавлен!".formatted(insertedNode.value));
            }
            insertedNode.parent = currentNode;
            if(insertedNode.value > currentNode.value)currentNode.right = insertedNode;
            else if(insertedNode.value < currentNode.value)currentNode.left = insertedNode;
            else throw new KeyAlreadyAddedException("Ключ %d уже добавлен!".formatted(insertedNode.value));//несмотря на дублирующуюся проверку, она здесь реально нужна
        }

        return insertedNode;
    }

    @NotNull
    @Override
    public Iterator<TreeNode> iterator() {
        if(head != null)return head.iterator();
        else return Collections.emptyIterator();
    }
    TreeNode getHead(){
        return head;
    }
}
