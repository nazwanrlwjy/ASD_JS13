package ASD_JOBSHEET13_TREE;

class Node23 {
    int data;
    Node23 left, right;

    public Node23(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree23 {
    Node23 root;

    public BinaryTree23() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(int data) {
        if (isEmpty()) { // tree is empty
            root = new Node23(data);
        } else {
            Node23 current = root;
            while (true) {
                if (data < current.data) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node23(data);
                        break;
                    }
                } else if (data > current.data) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node23(data);
                        break;
                    }
                } else { // data already exists
                    break;
                }
            }
        }
    }

    boolean find(int data) {
        Node23 current = root;
        while (current != null) {
            if (current.data == data) {
                return true;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    void traversePreOrder(Node23 node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node23 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node23 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    Node23 getSuccessor(Node23 del) {
        Node23 successor = del.right;
        Node23 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }

        Node23 parent = root;
        Node23 current = root;
        boolean isLeftChild = false;

        while (current != null) {
            if (current.data == data) {
                break;
            } else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        }

        // Case 1: No children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        // Case 2: One child (right)
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }
        // Case 2: One child (left)
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else {
                if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        }
        // Case 3: Two children
        else {
            Node23 successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else {
                if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
            successor.left = current.left;
        }
    }

    // Metode untuk menambahkan node secara rekursif
    Node23 addRecursive(Node23 current, int data) {
        if (current == null) {
            return new Node23(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }

        return current;
    }

    public void addRecursive(int data) {
        root = addRecursive(root, data);
    }

    // Metode untuk menampilkan nilai paling kecil dalam tree
    public int findMinValue() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }

        Node23 current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // Metode untuk menampilkan nilai paling besar dalam tree
    public int findMaxValue() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }

        Node23 current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // Method untuk menampilkan data yang ada di leaf
    public void printLeafNodes(Node23 node) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    // Method untuk memulai pencetakan data leaf
    public void printLeafNodes() {
        System.out.print("Leaf Nodes: ");
        printLeafNodes(root);
        System.out.println();
    }

    // Metode untuk menghitung jumlah leaf nodes
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    // Metode rekursif untuk menghitung jumlah leaf nodes
    public int countLeafNodes(Node23 node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        }
        int leftCount = countLeafNodes(node.left);
        int rightCount = countLeafNodes(node.right);
        return leftCount + rightCount;
    }
}
