package ASD_JOBSHEET13_TREE;

public class BinaryTreeArrayMain23 {
    public static void main(String[] args) {
        BinaryTreeArray23 bta = new BinaryTreeArray23();
        int[] data = {6, 4, 8, 3, 5, 7, 9, 0, 0, 0};
        int idxLast = 6;
        bta.populateData(data, idxLast);
        System.out.print("\nInOrder Traversal   : ");
        bta.traverseInOrder(0);
        System.out.println("\n");
        bta.add(10);
        System.out.print("PreOrder Traversal  : ");
        bta.traversePreOrder();
        System.out.println("\n");
        System.out.print("PostOrder Traversal : ");
        bta.traversePostOrder();
        System.out.println("\n");
    }
}
