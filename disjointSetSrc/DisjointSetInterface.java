package disjointSetSrc;

/*
 * Hank Carter
 * Github: @carterh
 * 2/6/19
 */

public interface DisjointSetInterface<T> {
	
	/* Add an element to the collection (in its own unique set).
	 * Returns true if the element was successfully added, false
	 * if the element is already contained in the collection.
	 */
	boolean add(T element);
	
	/* 
	 * Union the sets containing two specified elements
	 * in the collection.
	 * Returns the representative element of the new set or
	 * null if the union operation is not successful (i.e.,
	 * one or both of the parameters are not in the collection)
	 */
	T union(T x, T y);
	
	/* Find the representative element of a set given a member 
	 * element of the set.  Returns a null pointer if the element
	 * is not in the collection.
	 */
	T findSet(T element);
	
	/*
	 * Check if an element is already in the collection 
	 */
	boolean contains(T element);
	
	/*
	 * Returns the number of elements in the collection.
	 */
	int size();
	
	/*
	 * Returns the number of disjoint sets in the collection.
	 */
	int setCount();
	
	/*
	 * Returns the size of the set containing element. Returns 0
	 * if the element is not in the collection.
	 */
	int setSize(T element);
}
