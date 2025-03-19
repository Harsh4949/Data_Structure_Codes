import java.util.HashMap;

public class PathSum_III {

    static class Node{

        int data;
        Node left;
        Node right;
        
        public Node(int data){

            this.data=data;
        }   
    }
    
     HashMap<Long, Integer> map = new HashMap<>();
    int ans = 0; // Make ans a global variable
    
    public void helper(Node root, int targetSum, long sum) {
        if (root == null) return;

        sum += root.data;
        
        if (map.containsKey(sum - targetSum)) {
            ans += map.get(sum - targetSum); // Count all occurrences
        }
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        helper(root.left, targetSum, sum);
        helper(root.right, targetSum, sum);
        
        // Backtrack: remove current sum from map after returning from recursion
        map.put(sum, map.get(sum) - 1);  // if not done then okey
        if (map.get(sum) == 0) {
            map.remove(sum);
        }
    }
    
    public int pathSum(Node root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        map.put(0l, 1);
        ans = 0; // Reset ans before starting recursion
        helper(root, targetSum, 0);
        
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}
