import java.util.Scanner;

public class CheckIsBST {
	public static int maximum(BinaryTreeNode<Integer> root){
		if(root==null){
			return Integer.MIN_VALUE;
		}
	return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));	
	}
	public static int   minimum(BinaryTreeNode<Integer> root){
		if(root==null){
			return Integer.MAX_VALUE;
		}
return Math.min(root.data, Math.min(minimum(root.left), minimum(root.left)));		
		}
	
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root==null){
			return true;
		}
		
	int leftMax=maximum(root.left);
	int rightMin=minimum(root.right);
		if(root.data<=leftMax){
			return false;
		}
		if(root.data>rightMin){
			return false;
		}
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		
		if(isLeftBST &&isRightBST ){
			return true;
		}
		else{
			return false;
		}
		
}
	
	
	public static void printTreeLevelWise(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>> q= new QueueUsingLL<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		while(!q.isEmpty()){
			BinaryTreeNode<Integer> current=null;
			try{
				current=q.dequeue();
			}
			catch(QueueEmptyException e){
				 
			}
			String tobePrinted=current.data+":";
			 if(current.left !=null){
	             tobePrinted +="L:" +current.left.data+",";
	            q.enqueue(current.left);
	          }
	          else{
	            tobePrinted+="L:-1,";
	          }
	          if(current.right!=null)
	          {
	               tobePrinted +="R:" +current.right.data;
	            q.enqueue(current.right);
	          }
	          else{
	            tobePrinted+="R:-1";
	          }
	          System.out.println(tobePrinted);
		}
	}
public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
		System.out.println("enter root data");	
		int rootData = s.nextInt();
		if(rootData==-1){
			return null;
		}
		BinaryTreeNode<Integer> root =new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> front;
			try{
				front=pendingNodes.dequeue();
				
			}
			catch(QueueEmptyException e){
				return null;
	}
	System.out.println("enter left child of:" + front.data);		
			int leftChild= s.nextInt();
			if(leftChild!=-1){
				BinaryTreeNode<Integer> child= new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left=child;
			}
			System.out.println("enter right child of:" + front.data);		
			int rightChild= s.nextInt();
			if(rightChild!=-1){
				BinaryTreeNode<Integer> child= new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right=child;
			}
	}
		return root;
		}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=takeInputLevelWise();
	boolean result=	isBST(root);
	System.out.print(result);

	}

}
