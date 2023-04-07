package cs2040s;

public abstract class AVLNode implements Comparable<AVLNode> {
    AVLTree tree;
    AVLNode parent = null;
    AVLNode left = null;
    AVLNode right = null;
    int height = 0;
    int weight = 1;

    final void setLeft(AVLNode node) {
        if (node != null) {
            node.parent = this;
        }
        this.left = node;
    }

    final void setRight(AVLNode node) {
        if (node != null) {
            node.parent = this;
        }
        this.right = node;
    }

    final void replaceChild(AVLNode curr, AVLNode newNode) {
        if (curr == this.left) {
            curr.parent = null;
            this.left = newNode;
            if (newNode != null) {
                newNode.parent = this;
            }
        } else if (curr == this.right) {
            curr.parent = null;
            this.right = newNode;
            if (newNode != null) {
                newNode.parent = this;
            }
        }
    }

    final int rightHeight() {
        if (this.right != null) {
            return this.right.height;
        } else {
            return -1;
        }
    }

    final int leftHeight() {
        if (this.left != null) {
            return this.left.height;
        } else {
            return -1;
        }
    }

    final char unbalanced() {
        if (this.leftHeight() - this.rightHeight() > 1) {
            return 'l';
        } else if (this.rightHeight() - this.leftHeight() > 1) {
            return 'r';
        } else {
            return 'b';
        }
    }

    final char sideWithGreaterHeight() {
        if (this.leftHeight() > this.rightHeight()) {
            return 'l';
        } else if (this.rightHeight() > this.leftHeight()) {
            return 'r';
        } else {
            return 'b';
        }
    }

    final void setHeightFromChildren() {
        this.height = Math.max(this.leftHeight(), this.rightHeight()) + 1;
    }

    final int leftWeight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.weight;
        }
    }

    final int rightWeight() {
        if (this.right == null) {
            return 0;
        } else {
            return this.right.weight;
        }
    }

    final void setWeightFromChildren() {
        this.weight = this.leftWeight() + this.rightWeight() + 1;
    }

    final void resetNode() {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
        this.weight = 1;
        this.tree = null;
    }

    public boolean inTree(AVLTree tree) {
        return this.tree == tree;
    }
}
