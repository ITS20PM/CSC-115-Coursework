public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{

	public ArrayBasedBinarySearchTree() {
		super();
	}
	
	@Override
	public void insert(Integer value){
		if(super.data[0] == null){
			super.data[0] = value;
			return;
		}
		int i = 0;
		while(i < super.data.length && super.data[i] != null){
			
			if(value < super.data[i] && 2*i+1 < super.data.length ){
				if(super.data[2*i+1] != null){
					i = 2*i+1;
				}else{
					super.data[2*i+1] = value;
					return;
				}
			}else if(value >= super.data[i] && 2*i+2 < super.data.length){
				if(super.data[2*i+2] != null){
					i = 2*i+2;
				}else{
					super.data[2*i+2] = value;
					return;
				}
			}
			
		}
	}
	
	public void insertRecusrive(int t, Integer value){
		if(t >= super.data.length)
			return;
		else if(super.data[t] == null){
			super.data[t] = value;
			return;
		}else{
			if(value < super.data[t])
				insertRecusrive(2*t+1, value);
			else
				insertRecusrive(2*t+2, value);
		}	
	}
    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        emptyTree.insert(2);
		emptyTree.insert(1);
		emptyTree.insert(5);
		emptyTree.insert(7);
		emptyTree.insert(0);
		emptyTree.insert(4);
		emptyTree.insert(6);
		
		System.out.println("in");
        emptyTree.inOrder();
        System.out.println("pre");
        emptyTree.preOrder();
        System.out.println("post");
        emptyTree.postOrder();
		
		System.out.println("toString\n" + emptyTree+"\n");
		
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
        myTree.insertRecusrive(0, 2);
        myTree.insertRecusrive(0, 1);
        myTree.insertRecusrive(0, 5);
        myTree.insertRecusrive(0, 7);
        myTree.insertRecusrive(0, 0);
        myTree.insertRecusrive(0, 4);
        myTree.insertRecusrive(0, 6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);
    }

}
