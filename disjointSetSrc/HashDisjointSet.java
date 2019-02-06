package disjointSetSrc;

/*
 * Hank Carter
 * Github: @carterh
 * 2/6/19
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HashDisjointSet<T> implements DisjointSetInterface<T> {
	protected Map<T, SetNode> elements;
	protected int setCount;
	
	public HashDisjointSet(){
		elements = new HashMap<T, SetNode>();
		setCount = 0;
	}
	

	@Override
	public boolean add(T element) {
		if(contains(element))
			return false;
		else{
			SetNode newNode = new SetNode(element);
			elements.put(element, newNode);
			setCount++;
			return true;
		}
	}

	@Override
	public boolean contains(T element) {
		return elements.containsKey(element);
	}

	@Override
	public void union(T x, T y) {
		link(findSet(x), findSet(y));
	}
	
	/*
	 * Internal method used to link any two nodes
	 * based on the rank of each.  Used inside
	 * of the public union() method above.
	 */
	private void link(T x, T y){
		SetNode xNode = elements.get(x);
		SetNode yNode = elements.get(y);
		
		if(xNode.rank > yNode.rank){
			yNode.parent = xNode;
		}
		else{
			xNode.parent = yNode;
			if(xNode.rank == yNode.rank)
				yNode.rank++;
		}
		setCount--;
	}

	@Override
	public T findSet(T element) {
		T representative = null;
		
		if(contains(element)){
			SetNode curr = elements.get(element);
			Stack<SetNode> nodes = new Stack<>();
			while(curr.parent != curr){
				nodes.push(curr);
				curr = curr.parent;
			}
			representative = curr.element;
			while(!nodes.isEmpty()){
				SetNode top = nodes.pop();
				top.parent = curr;
			}
		}
		return representative;
	}
	
	@Override
	public int size(){
		return elements.size();
	}
	
	@Override
	public int setCount(){
		return setCount;
	}
	
	/*
	 * A class representing the tree node containing
	 * an element of the collection.  Also stores
	 * the rank of the node (i.e., a max bound on the height
	 * of the node), and a pointer to the parent node in the
	 * tree.  The root of the tree has a parent pointer
	 * that points back to itself.
	 */
	private class SetNode{
		T element;
		int rank;
		SetNode parent;
		
		public SetNode(T element){
			this.element = element;
			rank = 0;
			parent = this;
		}
	}
}
