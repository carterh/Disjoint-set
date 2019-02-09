package disjointSetSrc;

/*
 * Hank Carter
 * Github: @carterh
 * 2/6/19
 */

public class DisjointSetDriver {

	public static void main(String[] args) {
		DisjointSetInterface<Character> myDS = new HashDisjointSet<>();
		
		for(char i = 'a';i <= 'z';i++){
			myDS.add(i);
		}
		
		System.out.println("Testing findset:");
		System.out.println(myDS.findSet('a'));
		System.out.println(myDS.findSet('z'));
		
		System.out.println("Testing union:");
		myDS.union('a', 'z');
		System.out.println(myDS.findSet('a'));
		System.out.println(myDS.findSet('z'));
		
		System.out.println("Testing union return value:");
		System.out.println(myDS.union('b', 'a'));
		System.out.println(myDS.findSet('a'));
		System.out.println(myDS.findSet('b'));
		
		System.out.println("Testing setSize:");
		System.out.println(myDS.setSize('b'));
		
		System.out.println("Testing setSize after union on elements in the same set:");
		System.out.println(myDS.union('b', 'a'));
		System.out.println(myDS.findSet('a'));
		System.out.println(myDS.findSet('b'));
		System.out.println(myDS.setSize('b'));
		
		System.out.println("Testing contains:");
		System.out.println(myDS.contains('a'));
		System.out.println(myDS.contains(':'));
		

	}

}
