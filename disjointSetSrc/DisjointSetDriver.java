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
		
		System.out.println(myDS.findSet('a'));
		System.out.println(myDS.findSet('z'));
		myDS.union('a', 'z');
		System.out.println(myDS.findSet('a'));
		System.out.println(myDS.findSet('z'));
		System.out.println(myDS.union('b', 'a'));
		System.out.println(myDS.findSet('a'));
		System.out.println(myDS.findSet('b'));
		System.out.println(myDS.setSize('b'));
		
		System.out.println(myDS.contains('a'));
		System.out.println(myDS.contains(':'));
		

	}

}
