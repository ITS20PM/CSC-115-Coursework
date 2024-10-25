import java.lang.Math;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
	protected TreeNode root;

	public RefBasedBinaryTree() {
		// TODO...
		root = null;
	}

	public void insert(Integer value){
		insert(null, root, value);
	}

	/*
	 * Purpose: recursively determines the shortest path (root to leaf)
	 *      inserts a new TreeNode with given value at that leaf
	 * Parameters: TreeNode parent - the parent to t
	 *             TreeNode t - the current TreeNode in recursive traversal
	 *             Integer value - the value to be inserted
	 * Returns: nothing
	 */
	private void insert(TreeNode parent, TreeNode t, Integer value) {
		if (t==null) {
			if(parent == null)
				root = new TreeNode(value);
			else if(parent.getLeft()==null)
				parent.setLeft(new TreeNode(value));
			else
				parent.setRight(new TreeNode(value));
		}  else {
			int htLeft = height(t.getLeft());
			int htRight = height(t.getRight());
			if (htLeft <= htRight) {
				insert(t, t.getLeft(), value);
			} else {
				insert(t, t.getRight(), value);
			}				
		}
	}


	public int height() {
		return height(root);
	}
	 
	/*
	 * Purpose: computes and returns the height of BinaryTree t
	 *      NOTE a BinaryTree with no node is height 0
	 * Parameters: TreeNode t - the BinaryTree
	 * Returns: int - the height
	 */
	
	 
	private int height(TreeNode t) {
		// TODO...
		if(t == null)
			return 0;
		
		int left = height(t.getLeft());
		int right = height(t.getRight());
		
		return Math.max(left, right)+1;
	}


	public void inOrder(){
		// TODO...
		inOrder(this.root);
	}
	
	public void inOrder(TreeNode cur){
		if(cur == null)
			return;
		inOrder(cur.getLeft());
		System.out.print(cur.getValue()+" ");
		inOrder(cur.getRight());
	}


	public void preOrder(){
		// TODO...
		preOrder(this.root);
	}

	public void preOrder(TreeNode cur){
		if(cur == null)
			return;
		System.out.print(cur.getValue()+" ");
		preOrder(cur.getLeft());
		preOrder(cur.getRight());
	}

	public void postOrder(){
		// TODO...
		postOrder(this.root);
	}
	
	public void postOrder(TreeNode cur){
		if(cur == null)
			return;
		postOrder(cur.getLeft());
		postOrder(cur.getRight());
		System.out.print(cur.getValue()+" ");
	}
	
	/*
	 * Purpose: returns a String reprensentation of this Shape
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		return toString(root);
	}

	private String toString(TreeNode t) {
		if(t==null) {
			return "";
		}
		
		String s = "";		
		s += toString(t.getLeft());
		s += t.getValue() + " ";
		s += toString(t.getRight());		
		return s;
	}

	// provided for testing of RefBasedBinaryTree class
	public static void main(String[] args) {
		
		RefBasedBinaryTree myTree = new RefBasedBinaryTree();
		for(int i=2; i<=8; i++) {
			myTree.insert(i);
		}
		System.out.println("in");
		myTree.inOrder();
		System.out.println();
		System.out.println("pre");
		myTree.preOrder();
		System.out.println();
		System.out.println("post");
		myTree.postOrder();
		System.out.println();
		
		System.out.println("Height: \n"+myTree.height());
		
		System.out.println("toString\n" + myTree);
	}
    
}
