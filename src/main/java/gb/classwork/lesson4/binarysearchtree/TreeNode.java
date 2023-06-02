package gb.classwork.lesson4.binarysearchtree;

class TreeNode {

    enum ColorOfNode {BLACK, RED}

    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    ColorOfNode color = ColorOfNode.RED;
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
    public TreeNode rotateRight() {
        //сначала заменим ребёнка у нашего родителя на нашего левого ребёнка
        //если у нас есть родитель
        TreeNode g = this;// мы - дедушка
        // FIXME: 02.06.2023 Этот метод не до конца реализован
        if(hasParent())parent.replaceChild(this, left);
//        left.replaceChild(left.right)
        return null;
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
        newChild.parent = this;
        childForReplace.parent = null;
        return oldValue;
    }
    public boolean isThisLeftChild(TreeNode x) {
        return x == left;
    }
    public void makeBothChildBlack(){
        if(left != null)left.color = ColorOfNode.BLACK;
        if(right != null)right.color = ColorOfNode.BLACK;
    }
    public TreeNode getAnotherChild(TreeNode child){
        if(child == left)return left;
        else if(child == right)return right;
        else throw new IllegalArgumentException("This is not a child of this node!");
    }
}
