import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

	public RefBasedBinarySearchTree(){
		super();
	}
		
	//insert value iteratively
	/*public void insert(Integer value){
		if(super.root == null){
			super.root = new TreeNode(value);
			return;
		}
		
		TreeNode cur = super.root;
		
		while(cur != null){
			if(value<cur.getValue()){
				if(cur.getLeft()!=null){
					cur = cur.getLeft();
				}else{
					cur.setLeft(new TreeNode(value));
					return;
				}
			}else{
				if(cur.getRight()!=null){
					cur = cur.getRight();
				}else{
					cur.setRight(new TreeNode(value));
					return;
				}
			}
		}
		
	}	*/

	public void insert(Integer value){
		if(super.root == null){
			super.root = new TreeNode(value);
			return;
		}else{
			insert(super.root, value);
		}
	}
	
	//insert value recursively
	public void insert(TreeNode cur, Integer value){
		if(value<cur.getValue()){
			if(cur.getLeft()!=null){
				insert(cur.getLeft(), value);
			}else{
				cur.setLeft(new TreeNode(value));
				return;
			}
		}else{
			if(cur.getRight()!=null){
				insert(cur.getRight(), value);
			}else{
				cur.setRight(new TreeNode(value));
				return;
			}
		}
	}
	
	
	public boolean find(Integer value){
		if(super.root == null)
			return false;
		
		return find(super.root, value);
	}
	
	//recursive find method
	public boolean find(TreeNode t, Integer value){
		if(value == t.getValue())
			return true;
		else if(value < t.getValue()){
			if(t.getLeft()!=null){
				find(t.getLeft(), value);
			}else{
				return false;
			}
		}else{
			if(t.getRight()!=null){
				find(t.getRight(), value);
			}else{
				return false;
			}
		}
		return false;
	}
	
	//iterative find method
	/*public boolean find(TreeNode t, Integer value){
		TreeNode cur = t;
		while(cur!=null){
			if(value == cur.getValue())
				return true;
			else if(value < cur.getValue()){
				if(cur.getLeft()!=null){
					cur = cur.getLeft();
				}else{
					break;
				}
			}else{
				if(cur.getRight()!=null){
					cur = cur.getRight();
				}else{
					break;
				}
			}
				
		}
		return false;
	}*/
	
	public int getMax(){
		int res = 0;
		try{
			res = getMax(super.root);
		}catch (TreeEmptyException e){
			System.out.println("BST is empty");
		}
		return res;
	}
	
	//recursive getMax
	public int getMax(TreeNode t) throws TreeEmptyException{
		if(super.root == null)
			throw new TreeEmptyException();
		
		if(t.getRight() == null)
			return t.getValue();
		
		return getMax(t.getRight());
	}
	
	//iterative getMax
	/*public int getMax(TreeNode t) throws TreeEmptyException{
		if(super.root == null)
			throw new TreeEmptyException();
		
		TreeNode cur = t;
		int max = cur.getValue();
		while(cur.getRight()!=null){
			max = Math.max(cur.getRight().getValue(), max);
			cur = cur.getRight();
		}
		return max;
	}*/

    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
		System.out.println("sum");
		System.out.println(myTree.sum(myTree.root));
		System.out.println();
		System.out.println("find");
		System.out.println(myTree.find(2));
		System.out.println();
		System.out.println("getMax");
		System.out.println(myTree.getMax());
		System.out.println();
        System.out.println("in");
        myTree.inOrder();
		System.out.println();
        System.out.println("pre");
        myTree.preOrder();
		System.out.println();
        System.out.println("post");
        myTree.postOrder();
		System.out.println();
		System.out.println("level");
        myTree.levelOrder();
        System.out.println();
		
        System.out.println("toString\n" + myTree);
    }
}
