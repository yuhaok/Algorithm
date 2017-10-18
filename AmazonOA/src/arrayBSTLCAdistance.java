//import java.util.*;

public class arrayBSTLCAdistance {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args) {
		int[] input = {5,6,3,1,2,4};
		System.out.println(bstdistance(input, 6, 2, 6));
		System.out.println(bstdistance(input, 6, 3, 4));
		System.out.println(bstdistance(input, 6, 1, 3));
		System.out.println(bstdistance(input, 6, 5, 1));
		System.out.println(bstdistance(input, 6, 6, 2));

	}
	
    public static int findlength(TreeNode root,int in){
        //to prevent if it is root;
    		return finddistance(root,in)-1;
    }
    
    public static int finddistance(TreeNode root, int in){
    		if(root == null){
    			return 0;
    		}
    		int distance = 0;
    		if(root.val == in){
    			return distance +1;
    		}else if(root.val < in){
    			distance = finddistance(root.right, in);
    		}else if(root.val > in){
    			distance = finddistance(root.left, in);
    		}
    		if(distance > 0){
    			return distance + 1;
    		}else{
    			return 0;
    		}
    }
    
	public static int bstdistance(int[] vals, int n, int node1, int node2){
		if(vals == null || vals.length == 0){
			return 0;
		}
		
		TreeNode root = new TreeNode(vals[0]);
		for(int i = 1; i < vals.length; i++){
			//create tree here with this function;
			createbst(root, vals[i]);
		}
		int length1 = findlength(root, node1);
		int length2 = findlength(root, node2);
		if(length1 == -1 || length2 == -1){
			return -1;
		}
		
		int lca = LCA(root, node1, node2).val;
		int mid = findlength(root, lca);
		return length1 + length2 - 2*mid;
		
	}
	
	private static TreeNode LCA(TreeNode root, int val1, int val2){
		if(root == null || root.val == val1 || root.val == val2){
			return root;
		}
		if(root.val > val1 && root.val > val2){
			return LCA(root.left, val1, val2);
		}
		if(root.val < val1 && root.val < val2){
			return LCA(root.right, val1, val2);
		}
		else{
			return root;
		}
	}
	
	private static void createbst(TreeNode root, int val){
		if(val < root.val){
			if(root.left == null){
				root.left = new TreeNode(val);
			}else{
				createbst(root.left, val);
			}
		}else{
			if(root.right == null){
				root.right = new TreeNode(val);
			}else{
				createbst(root.right, val);
			}
		}
	}
}
