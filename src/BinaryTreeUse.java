import java.util.Scanner;
/*
 * enter root data 
1
enter root data 
2
enter root data 
4
enter root data 
-1
enter root data 
-1
enter root data 
5
enter root data 
-1
enter root data 
-1
enter root data 
3
enter root data 
-1
enter root data 
-1
1L:2,R:3,
2L:4,R:5,
4
5
3

 */
public class BinaryTreeUse {

	public static BinaryTreeNode<Integer> takeInput(Scanner s ){
		int rootData;
		System.out.println("enter root data ");
		rootData = s.nextInt();
		if(rootData ==-1){
			return null;
		}
		 BinaryTreeNode<Integer> root= new  BinaryTreeNode<Integer>(rootData);
		 
		 root.left=takeInput(s);
		 
		 root.right=takeInput(s);
		 return root;
	}
	public static void PrintTree(BinaryTreeNode<Integer> root){
		// base case
		if(root==null){
			return ;
		}
		String toBePrinted = root.data+"";
		if(root.left !=null){
			toBePrinted += "L:"  +root.left.data +",";
		}
		if(root.right !=null){
			toBePrinted += "R:"  +root.right.data +",";
		}
		System.out.println(toBePrinted);
	     PrintTree(root.left);
	     PrintTree(root.right);
		}
	
public static void main(String[] args) {
//	 BinaryTreeNode<Integer> root = new  BinaryTreeNode<Integer> (1);
//	 BinaryTreeNode<Integer> node1 = new  BinaryTreeNode<Integer> (2);
//	root.left=node1;
//	 BinaryTreeNode<Integer> node2 = new  BinaryTreeNode<Integer> (3);
//	 root.right=node2;
	Scanner s =new Scanner(System.in); 
	  BinaryTreeNode<Integer> root=takeInput(s);
	  PrintTree(root);
	 
	 
	}

}
