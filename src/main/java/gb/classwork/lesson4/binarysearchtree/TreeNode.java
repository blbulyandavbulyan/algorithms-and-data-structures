package gb.classwork.lesson4.binarysearchtree;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class TreeNode implements Iterable<TreeNode>{

    @NotNull
    @Override
    public Iterator<TreeNode> iterator() {
        return new Iterator<TreeNode>() {
            Queue<TreeNode> queue = new LinkedList<>();
            {
                queue.add(TreeNode.this);
            }
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public TreeNode next() {
                if(!queue.isEmpty()){
                    TreeNode top = queue.poll();
                    if(top.left != null)queue.add(top.left);
                    if(top.right != null)queue.add(top.right);
                    return top;
                }
                else throw new NoSuchElementException("Элементов больше нет!");
            }
        };
    }

    enum ColorOfNode {BLACK, RED}
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    ColorOfNode color = ColorOfNode.RED;
    private TreeNode(){

    }
    public TreeNode(int value) {
        this.value = value;
    }

    public boolean isBlack() {
        return color == ColorOfNode.BLACK;
    }
    public boolean isRed(){
        return color == ColorOfNode.RED;
    }
    public boolean isLeftChildRed(){
        return left != null && left.color == ColorOfNode.RED;
    }
    public boolean isRightChildRed(){
        return right != null && right.color == ColorOfNode.RED;
    }
    public boolean isRightChildBlack(){
        return right == null || right.color == ColorOfNode.BLACK;
    }
    public boolean isLeftChildBlack(){
        return left == null || left.color == ColorOfNode.BLACK;
    }
    public boolean isBothChildRed(){
        return isLeftChildRed() && isRightChildRed();
    }
    public boolean isLeft(){
        return parent != null && parent.left == this;
    }
    public boolean isRight(){
        return parent != null && parent.right == this;
    }
    public TreeNode swapColor(){
        if(left != null)left.color = ColorOfNode.BLACK;
        if(right != null)right.color = ColorOfNode.BLACK;
        color = ColorOfNode.RED;
        return this;
    }
    public boolean hasParent(){return parent != null;}
    public TreeNode rotateLeft() {
        // FIXME: 02.06.2023 СДЕЛАТЬ МЕТОД
        TreeNode b = this;
        TreeNode d = b.right;
        {
            TreeNode pB = b.parent;
            if (pB != null) pB.replaceChild(b, d);
            else d.parent = null;
        }
        TreeNode c = d.left;
        d.left = b;
        b.parent = d;
        //замена левого ребёнка d:
        b.right = c;
        if(c != null)c.parent = b;
        return d;
    }
    public TreeNode rotateRight() {
        TreeNode d = this;
        TreeNode b = d.left;
        {
            TreeNode dP = d.parent;
            if(dP != null) dP.replaceChild(d, b);
            else b.parent = null;
        }
        TreeNode c = b.right;
        b.right = d;
        d.parent = b;
        d.left = c;
        if(c != null)c.parent = d;
        return b;
    }
    private TreeNode replaceChild(TreeNode childForReplace, TreeNode newChild) {
        TreeNode oldValue;
        if (left == childForReplace) {
            oldValue = left;
            left = newChild;
        } else if (right == childForReplace) {
            oldValue = right;
            right = newChild;
        } else throw new IllegalArgumentException("childForReplace is not my child!");
        if(newChild != null)newChild.parent = this;
        if(childForReplace != null)childForReplace.parent = null;
        return oldValue;
    }
}
