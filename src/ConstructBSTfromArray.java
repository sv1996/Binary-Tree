import java.util.Scanner;

public class ConstructBSTfromArray {

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
	 
		 return constructBST(arr, 0, arr.length-1);
	}
	
	public static BinaryTreeNode<Integer>  constructBST(int[] arr , int startIndex , int EndIndex){
		 if(startIndex > EndIndex){
			 return null;
		 }
	 int mid = (startIndex + EndIndex) /2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
		root.left= constructBST(arr , startIndex , mid-1);
		root.right= constructBST(arr , mid+1 ,EndIndex );
    	 return root;
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
	//	BinaryTreeNode<Integer> root=takeInputLevelWise();
		int arr[]={1,2,3,4,5,6,7,8};
		BinaryTreeNode<Integer>	root=SortedArrayToBST( arr);
		printTreeLevelWise(root);
	}

}
