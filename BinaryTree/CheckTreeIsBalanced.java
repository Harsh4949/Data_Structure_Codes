package BinaryTree;

public class CheckTreeIsBalanced {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int idx = -1; // This must be reset before each tree build

        public static Node buildBT(int[] nodes) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBT(nodes);
            newNode.right = buildBT(nodes);

            return newNode;
        }

        public static boolean isTreeBalanced(Node root) {
            return checkBalance(root) != -1;
        }

        private static int checkBalance(Node root) {
            if (root == null) {
                return 0;
            }

            int left = checkBalance(root.left);
            if (left == -1) return -1; // Left subtree is unbalanced

            int right = checkBalance(root.right);
            if (right == -1) return -1; // Right subtree is unbalanced

            if (Math.abs(left - right) > 1) {
                return -1; // Tree is unbalanced
            }

            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {

    }
    
}
