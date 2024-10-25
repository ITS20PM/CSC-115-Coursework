import java.lang.Math;
import java.util.LinkedList;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
    protected TreeNode root;
    
    public RefBasedBinaryTree() {
        this.root = null;
    }
    
    public void insert(Integer value){
        if (root==null)
            root = new TreeNode(value);
        else
            insert(null, root, value);
        
    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent.getLeft()==null) {
                parent.setLeft(new TreeNode(value));
			} else {
                parent.setRight(new TreeNode(value));
			}            
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight) {
                insert(t, t.getRight(), value);
			} else {
                insert(t, t.getLeft(), value);
			}
        }
    }
    
    private int height(TreeNode t) {
        if (t==null) {
            return -1;
		} else {
            int highest = Math.max(height(t.getLeft()), height(t.getRight()));
            return 1 + highest;
        }
    }
    
	//compute the sum of all element
	public int sum(){
		return sum(root);
	}
	
	//recusrively
	/*public int sum(TreeNode t){
		if(t == null)
			return 0;
		return t.getValue()+sum(t.getLeft())+sum(t.getRight());
	}*/
	
	//iteratively
	public int sum(TreeNode t){
		if(this.root == null)
			return 0;
		
		int sum = 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this.root);
		
		while(!queue.isEmpty()){
			TreeNode cur = queue.remove();
			sum += cur.getValue();
			if(cur.getLeft()!=null)
				queue.add(cur.getLeft());
			if(cur.getRight()!=null)
				queue.add(cur.getRight());
		}
		
		return sum;
	}
	
	//find value is in the binary trees
	public boolean find(Integer value){
		return find(root, value);
	}
	
	//recusrively
	public boolean find(TreeNode t, Integer value){
		if(t == null)
			return false;
		return t.getValue()==value||find(t.getLeft(), value)||find(t.getRight(), value);
	}
	
	//iteratively
	/*public boolean find(TreeNode t, Integer value){
		if(this.root == null)
			return false;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this.root);
		
		while(!queue.isEmpty()){
			TreeNode cur = queue.remove();
			if(cur.getValue()==value)
				return true;
			if(cur.getLeft()!=null)
				queue.add(cur.getLeft());
			if(cur.getRight()!=null)
				queue.add(cur.getRight());
		}
		return false;
	}*/	
	
	//get max
	public int getMax(){
		int max = 0;
		try{
			max = getMax(this.root);
		}catch(TreeEmptyException e){
			System.out.println("Binary tree is empty");
		}
		return max;
	}
	
	//getMax recusrively
	public int getMax(TreeNode t) throws TreeEmptyException{
		if(this.root == null)
			throw new TreeEmptyException();
		
		if(t == null){
			return 0;
		}
		else{
			int max = t.getValue();
			
			if(t.getLeft()!=null){
				int leftMax = getMax(t.getLeft());
				max = Math.max(leftMax, max);
			}
			
			if(t.getRight()!=null){
				int rightMax = getMax(t.getRight());
				max = Math.max(rightMax, max);
			}
			return max;
		}
	}
	
	//getMax iteratively
	/*public int getMax(TreeNode t) throws TreeEmptyException {
		if(this.root == null)
			throw new TreeEmptyException();
		
		int max = Integer.MIN_VALUE;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this.root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.remove();
			max = Math.max(cur.getValue(), max);
			if(cur.getLeft()!=null)
				queue.add(cur.getLeft());
			if(cur.getRight()!=null)
				queue.add(cur.getRight());
		}	
		return max;
	}*/
	
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following an in-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void inOrder(TreeNode t){
        if (t==null){
			return;
		}else {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a pre-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void preOrder(TreeNode t){
        if (t==null){
			return;
		}else {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a post-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void postOrder(TreeNode t){
        if (t==null){
			return;
		}else {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }
	
	//level order traversal iteratively
	public void levelOrder(){
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this.root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.remove();
			System.out.print(cur.getValue()+" ");
			if(cur.getLeft()!=null)
				queue.add(cur.getLeft());
			if(cur.getRight()!=null)
				queue.add(cur.getRight());
		}
		System.out.println();
	}
    
    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }
    
    private String toString(TreeNode t) {
        if(t==null){
			return "";
		}else {
            String s = "";
            
            s += toString(t.getLeft());
            s += t.getValue() + " ";
            s += toString(t.getRight());
            
            return s;
        }
    }
    
    
    public static void main(String[] args) {
        // use these trees to test the methods you will implement in Part II
        RefBasedBinaryTree emptyTree = new RefBasedBinaryTree();
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
		//compute sum
		System.out.println("sum");
		System.out.println(myTree.sum());
		System.out.println();
		//find max
		System.out.println("max");
		System.out.println(myTree.getMax());
		System.out.println();
		//find if the paramter value exists
		System.out.println("find");
		System.out.println(myTree.find(9));
		System.out.println();
		//level order
		System.out.println("find");
		myTree.levelOrder();
    }
    
}
