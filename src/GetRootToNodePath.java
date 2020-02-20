import java.util.Scanner;
import java.util.ArrayList;

public class GetRootToNodePath {
	
	public static ArrayList<Integer>getRootToNodePath(BinaryTreeNode<Integer> root ,int data){
		if(root==null){
			return null;
		}
	if(root.data==data){
		ArrayList<Integer> Output= new ArrayList<>();
		Output.add(root.data);
		return Output;
	}
	ArrayList<Integer> leftOutput= getRootToNodePath(root.left , data);
	if(leftOutput!=null){
		leftOutput.add(root.data);
		return leftOutput;
}
	ArrayList<Integer> rightOutput= getRootToNodePath(root.right , data);
	if(rightOutput!=null){
		rightOutput.add(root.data);
		return rightOutput;
		
	}	else{
		return null;
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
		ArrayList<Integer> ans=getRootToNodePath( root ,2);
		for(int i=0;i<ans.size();i++){
			System.out.print(ans.get(i)+" ");
		}
		
		
	}

}
