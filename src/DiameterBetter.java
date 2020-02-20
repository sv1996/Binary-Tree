import java.util.Scanner;
class Pair<T,V>{
	public T first;
	public T second;
}
public class DiameterBetter {
	
	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root){
		
		if(root==null){
			Pair<Integer, Integer> output= new Pair<>();
			output.first=0;
			output.second=0;
			return output;
		}
		Pair<Integer, Integer> lo /* leftoutput*/=heightDiameter(root.left);
		Pair<Integer, Integer> ro /* rightoutput*/=heightDiameter(root.right);
		int height =1+Math.max(lo.first, ro.first);
		int option1 =lo.first+ro.first;
		int option2=lo.second;
		int option3=ro.second;
		int diameter =Math.max(option1, Math.max(option2, option3));
		Pair<Integer , Integer> Output=new Pair<>();
		Output.first=height;
		Output.second=diameter;
		return Output;
			
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
		System.out.println("height"+heightDiameter(root).first);
	System.out.println("diameter"+heightDiameter(root).second);

	}

}
