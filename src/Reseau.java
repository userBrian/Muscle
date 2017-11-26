import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public final class Reseau {

	private static Reseau reseau = null;
	private ArrayList<Jonction> jonctions;
	
	/**
	 * 
	 */
	private Reseau(){
		jonctions = new ArrayList<Jonction>();
		
		ArrayList<Segment> segs = new ArrayList<Segment>();
		ArrayList<Segment> aAjouter = new ArrayList<Segment>();
		
		for(int i = 0; i < 9; i++)
			segs.add(new Segment());
		jonctions.add(new Jonction(segs, 4));
		
		for(int i = 3; i < 7; i++){
			aAjouter.add(segs.get(i));
		}
		jonctions.add(new Jonction(aAjouter, 4));
		aAjouter.clear();
		segs.forEach(item->System.out.println(item));
		
		System.out.println();
		
		for(int i = 6; i < 9; i++){
			aAjouter.add(segs.get(i));
		}
		jonctions.add(new Jonction(aAjouter, 3));
		aAjouter.clear();
		segs.forEach(item->System.out.println(item));
		
		System.out.println();
		
		aAjouter.add(segs.get(0));
		aAjouter.add(segs.get(7));
		jonctions.add(new Jonction(aAjouter, 2));
		aAjouter.clear();
		segs.forEach(item->System.out.println(item));
		
		System.out.println();
		for(Jonction j : jonctions)
			System.out.println(j.toString());
	}
	
	public final static Reseau makeInstance(){
		if(Reseau.reseau == null)
			Reseau.reseau = new Reseau();
		return Reseau.reseau;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Reseau.makeInstance();

	}

}
