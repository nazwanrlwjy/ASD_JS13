package ASD_JOBSHEET13_TREE;

public class BinaryTreeArray23 {
    int[] data;
    int idxLast;

    public BinaryTreeArray23() {
        data = new int[10];
        idxLast = -1;
    }

    void populateData(int[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    void add(int newData) {
        if (idxLast >= data.length - 1) {
            System.out.println("Tree is full, cannot add more data.");
            return;
        }
        idxLast++;
        data[idxLast] = newData;
    }

    void traversePreOrder() {
        traversePreOrder(0);
    }

    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            System.out.print(data[idxStart] + " ");
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }

    void traversePostOrder() {
        traversePostOrder(0);
    }

    void traversePostOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traversePostOrder(2 * idxStart + 1);
            traversePostOrder(2 * idxStart + 2);
            System.out.print(data[idxStart] + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeArray23 bta = new BinaryTreeArray23();
        int[] data = {10, 20, 30, 40, 50, 60, 70};
        bta.populateData(data, data.length - 1);

        System.out.print("InOrder Traversal: ");
        bta.traverseInOrder(0);
        System.out.println();

        System.out.print("PreOrder Traversal: ");
        bta.traversePreOrder();
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        bta.traversePostOrder();
        System.out.println();
    }
}
