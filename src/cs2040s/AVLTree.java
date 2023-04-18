package cs2040s;

/**
 * AVLTree implementation of an order statistic tree.
 * The elements inside the tree have the same reference as the input.
 * Therefore, the input is mutated, the user must call the tree to update the element.
 * The element must inherit AVLNode. The user can simply declare the inheritance to make a type usable this tree.
 * @param <T> The type of element to store
 */
public class AVLTree<T extends AVLNode> implements TreeSet<T> {
    T root;
    int size = 0;

    final T parent(T node) {
        @SuppressWarnings("unchecked")
        T newParent = (T) node.parent;
        return newParent;
    }

    final T leftNode(T node) {
        @SuppressWarnings("unchecked")
        T leftNode = (T) node.left;
        return leftNode;
    }

    final T rightNode(T node) {
        @SuppressWarnings("unchecked")
        T rightNode = (T) node.right;
        return rightNode;
    }

    private void rotateLeft(T node) {
        T replacementAVLNode = rightNode(node);
        boolean changeRoot = true;
        T parent = null;
        if (node != this.root) {
            parent = this.parent(node);
            parent.replaceChild(node, replacementAVLNode);
            changeRoot = false;
        } else {
            node.replaceChild(replacementAVLNode, null);
        }
        node.setRight(replacementAVLNode.left);
        replacementAVLNode.setLeft(node);

        node.setHeightFromChildren();
        replacementAVLNode.setHeightFromChildren();
        if (!changeRoot) {
            parent.setHeightFromChildren();
        } else {
            this.root = replacementAVLNode;
        }
        node.setWeightFromChildren();
        replacementAVLNode.setWeightFromChildren();
    }

    private void rotateRight(T node) {
        T replacementAVLNode = this.leftNode(node);
        boolean changeRoot = true;
        T parent = null;
        if (node != this.root) {
            parent = this.parent(node);
            parent.replaceChild(node, replacementAVLNode);
            changeRoot = false;
        } else {
            node.replaceChild(replacementAVLNode, null);
        }
        node.setLeft(replacementAVLNode.right);
        replacementAVLNode.setRight(node);

        node.setHeightFromChildren();
        replacementAVLNode.setHeightFromChildren();
        if (!changeRoot) {
            parent.setHeightFromChildren();
        } else {
            this.root = replacementAVLNode;
        }
        node.setWeightFromChildren();
        replacementAVLNode.setWeightFromChildren();
    }

    private void rectify(T node, char balanceResult) {
        if (balanceResult == 'l') {
            if (node.left.sideWithGreaterHeight() == 'r') {
                this.rotateLeft(this.leftNode(node));
            }
            this.rotateRight(node);
        } else if (balanceResult == 'r') {
            if (node.right.sideWithGreaterHeight() == 'l') {
                this.rotateRight(this.rightNode(node));
            }
            this.rotateLeft(node);
        }
    }

    @Override
    public final T object(T node) {
        if (node.tree == this) {
            return node;
        }

        T curr = this.root;
        while (curr != null) {
            if (curr.compareTo(node) == 0) {
                return curr;
            }
            if (curr.compareTo(node) > 0) {
                curr = this.leftNode(curr);
            } else {
                curr = this.rightNode(curr);
            }
        }
        return null;
    }

    @Override
    public final boolean contains(T node) {
        return object(node) != null;
    }

    @Override
    public final boolean containsReference(T node) {
        return node.tree == this;
    }

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final void add(T node) {
        if (node.tree == this) {
            return;
        }
        node.resetNode();
        node.tree = this;
        this.size++;
        if (this.root == null) {
            this.root = node;
            return;
        }
        T curr = this.root;
        while (true) {
            curr.weight++;
            if (curr.compareTo(node) > 0) {
                if (curr.left == null) {
                    curr.setLeft(node);
                    break;
                } else {
                    curr = this.leftNode(curr);
                }
            } else {
                if (curr.right == null) {
                    curr.setRight(node);
                    break;
                } else {
                    curr = this.rightNode(curr);
                }
            }
        }

        // check balance
        while (node != this.root) {
            T parent = this.parent(node);
            parent.setHeightFromChildren();
            char balanceTest = parent.unbalanced();
            if (balanceTest != 'b') {
                this.rectify(parent, balanceTest);
                break;
            }
            node = parent;
        }
    }

    final T predecessorInSubtree(T node) {
        if (node.left == null) {
            return null;
        } else {
            T curr = this.leftNode(node);
            while (curr.right != null) {
                curr = this.rightNode(curr);
            }
            return curr;
        }
    }

    final T successor(T node) {
        if (node.right == null) {
            T curr = node;
            while (curr != this.root) {
                if (curr.parent.left == curr) {
                    return this.parent(curr);
                }
                curr = this.parent(curr);
            }
            return null;
        } else {
            T curr = this.rightNode(node);
            while (curr.left != null) {
                curr = this.leftNode(curr);
            }
            return curr;
        }
    }

    @Override
    public final boolean removeByReference(T node) {
        if (node == null) {
            return false;
        }
        if (node.tree != this) {
            return false;
        }

        this.size--;
        node.tree = null;
        T parent = null;
        T curr = null; // for rebalancing purposes
        if (node != this.root) {
            parent = this.parent(node);
        }

        // check type of node and remove association of the node from the tree
        if (node.left == null & node.right == null) {
            if (parent != null) {
                parent.replaceChild(node, null);
                curr = parent;
            } else {
                this.root = null;
            }
        } else if (node.left != null & node.right != null) {
            T replacementAVLNode = this.predecessorInSubtree(node);
            T leftNode = this.leftNode(node);
            if (leftNode == replacementAVLNode) {
                leftNode = this.leftNode(replacementAVLNode);
            }
            T rightNode = this.rightNode(node);
            if (rightNode == replacementAVLNode) {
                rightNode = this.rightNode(replacementAVLNode);
            }
            if (replacementAVLNode.parent == node) {
                curr = replacementAVLNode;
            } else {
                curr = this.parent(replacementAVLNode);
            }
            replacementAVLNode.parent.replaceChild(replacementAVLNode, null);
            if (parent != null) {
                parent.replaceChild(node, replacementAVLNode);
            } else {
                this.root = replacementAVLNode;
            }
            replacementAVLNode.setLeft(leftNode);
            replacementAVLNode.setRight(rightNode);
        } else {
            T child;
            if (node.left == null) {
                child = this.rightNode(node);
            } else {
                child = this.leftNode(node);
            }
            node.replaceChild(child, null);
            if (parent != null) {
                parent.replaceChild(node, child);
                curr = parent;
            } else {
                this.root = child;
            }
        }
        node.resetNode();

        // rebalancing
        if (curr != null) {
            while (curr != null) {
                curr.setHeightFromChildren();
                curr.setWeightFromChildren();
                char balanceTest = curr.unbalanced();
                this.rectify(curr, balanceTest);
                curr = this.parent(curr);
            }
        }

        return true;
    }

    @Override
    public final boolean remove(T node) {
        T ref = this.object(node);
        return this.removeByReference(ref);
    }

    @Override
    public final T floor(T node) {
        T ans = null;
        T curr = this.root;
        while(curr != null) {
            if (curr.compareTo(node) == 0) {
                return curr;
            } else if (curr.compareTo(node) > 0) {
                curr = this.leftNode(curr);
            } else {
                ans = curr;
                curr = this.rightNode(curr);
            }
        }
        return ans;
    }

    @Override
    public final T lower(T node) {
        T ans = null;
        T curr = this.root;
        while (curr != null) {
            if (curr.compareTo(node) >= 0) {
                curr = this.leftNode(curr);
            } else {
                ans = curr;
                curr = this.rightNode(curr);
            }
        }
        return ans;
    }

    @Override
    public final T ceil(T node) {
        T ans = null;
        T curr = this.root;
        while (curr != null) {
            if (curr.compareTo(node) == 0) {
                return curr;
            } else if (curr.compareTo(node) > 0) {
                ans = curr;
                curr = this.leftNode(curr);
            } else {
                curr = this.rightNode(curr);
            }
        }
        return ans;
    }

    @Override
    public final T higher(T node) {
        T ans = null;
        T curr = this.root;
        while (curr != null) {
            if (curr.compareTo(node) <= 0) {
                curr = this.rightNode(curr);
            } else {
                ans = curr;
                curr = this.leftNode(curr);
            }
        }
        return ans;
    }

    @Override
    public final T lowest() {
        T ans = this.root;
        if (ans == null) {
            return null;
        }
        while (this.leftNode(ans) != null) {
            ans = this.leftNode(ans);
        }
        return ans;
    }

    @Override
    public final T highest() {
        T ans = this.root;
        if (ans == null) {
            return null;
        }
        while (this.rightNode(ans) != null) {
            ans = this.rightNode(ans);
        }
        return ans;
    }

    private void preOrderTraversal(T node) {
        if (node != null) {
            System.out.println(node);
            this.preOrderTraversal(this.leftNode(node));
            this.preOrderTraversal(this.rightNode(node));
        }
    }

    public final void preOrderTraversal() {
        this.preOrderTraversal(this.root);
    }
}
