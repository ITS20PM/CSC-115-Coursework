import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
    
	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		try{
			bst.find(key);
		}catch(KeyNotFoundException e){
			return false;
		}
		return true;
		 // so it compiles
	}

	public V get (K key) throws KeyNotFoundException {
		return bst.find(key); // so it compiles
	}

	public List<Entry<K,V> > entryList() {
		return bst.entryList(); // so it compiles
	}

	public void put (K key, V value) {
		bst.insert(key, value);
	}

	public int size() {
		return bst.size(); // so it compiles
	}

	public void clear() {
		bst.clear();
	}

}