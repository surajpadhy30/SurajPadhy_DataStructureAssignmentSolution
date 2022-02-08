package question2;

public class ModifiedBST {

	static Node HeadNode=null;
	static Node PrevNode=null;

	static class Node {
		int key;
		Node Left,Right;

		Node (int data) {
			key=data;
			Left= null;
			Right= null;
		}
	}

	static void InOrder(Node root) {
		if(root==null) {
			return;
		}
		InOrder(root.Left);
		System.out.print(root.key+" ");
		InOrder(root.Right);
	}


	static void rightSkewBST(Node root) {

		if(root==null) {
			return;
		}
		rightSkewBST(root.Left);
		Node y=root.Right;
		if(HeadNode==null) {
			HeadNode=root;
			root.Left=null;
			PrevNode=root;
		}else {
			PrevNode.Right = root;
			root.Left = null;
			PrevNode = root;
		}
		rightSkewBST(y);
	}
	
	
	static void RightSkewedInorder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.key+" ");
		InOrder(root.Right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root;

		root=new Node(50);
		root.Left=new Node(30);
		root.Right=new Node(60);
		root.Left.Left=new Node(10);
		root.Right.Left=new Node(55);
		System.out.println("Inorder sequence before shift:");
		InOrder(root);
		System.out.println("\n");
		rightSkewBST(root);
		System.out.println("Inorder Sequence after shift for right skewed BST:");
		root=HeadNode;
		RightSkewedInorder(root);

	}

}
