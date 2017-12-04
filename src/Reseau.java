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
	private ArrayList<Segment> segs;
	
	/**
	 * 
	 */
	private Reseau(){
		jonctions = new ArrayList<Jonction>();
		segs = new ArrayList<Segment>();
		
		creerSegments();
		creerJonctions();
		jonctions.forEach(items->System.out.println(items));
		updateSegments();
		ajouterSemaphores();
		ajouterVoitures();
	}
	
	/**
	 * Ajoute des sémaphores au réseau
	 */
	private void ajouterSemaphores(){
		
	}
	
	/**
	 * Ajoute des voitures au réseau
	 */
	private void ajouterVoitures(){
		Voiture v1 = new Voiture("Bazinmobile");
		Voiture v2 = new Voiture("Polythug");
		Voiture v3 = new Voiture("Batmobile");
		Voiture v4 = new Voiture("Pussy Wagon");
		
		segs.get(0).getVoitures().add(v1);	v1.setPosition(0);	v1.setSens(0);	v1.setVitesse(segs.get(0).getVitesseMax());
		segs.get(8).getVoitures().add(v2);	v2.setPosition(5);	v2.setSens(1);	v2.setVitesse(segs.get(8).getVitesseMax());
		segs.get(7).getVoitures().add(v3);	v3.setPosition(0);	v3.setSens(0);	v3.setVitesse(segs.get(7).getVitesseMax());
		segs.get(4).getVoitures().add(v4);	v4.setPosition(0);	v4.setSens(0);	v4.setVitesse(segs.get(4).getVitesseMax());
	}
	
	/**
	 * Crée des segments de route et des jonctions et les lie entre eux
	 */
	/*private void creerReseau(){
		
		
		ArrayList<Segment> aAjouter = new ArrayList<Segment>();
		
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
		
		System.out.println();
		
		for(Segment s : segs){
			if(s.getjA() == null || s.getjB() == null)
				jonctions.add(new Jonction(s));
		}
		segs.forEach(item->System.out.println(item));
	}*/
	
	private void creerJonctions(){
		ArrayList<Segment> aAjouter = new ArrayList<Segment>();
		
		aAjouter.add(segs.get(0));	// A vers J4
		aAjouter.add(segs.get(2));	// B vers B1
		aAjouter.add(segs.get(4));	// C vers B2
		aAjouter.add(segs.get(6));	// D vers J2
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(7));	// D vers J1
		aAjouter.add(segs.get(8));	// E vers B3	
		aAjouter.add(segs.get(10));	// F vers B4
		aAjouter.add(segs.get(12));	// G vers J3
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(13));	// G vers J2
		aAjouter.add(segs.get(14));	// H vers J3
		aAjouter.add(segs.get(16));	// I vers B5
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(1));	// A vers J1
		aAjouter.add(segs.get(15));	// H vers J3
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(3));	// H vers J3
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(5));	// H vers J3
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(9));	// H vers J3
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(11));	// H vers J3
		jonctions.add(new Jonction(aAjouter));
		
		aAjouter.add(segs.get(17));	// H vers J3
		jonctions.add(new Jonction(aAjouter));
	}
	
	private void creerSegments(){
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(20));
		segs.add(new Segment(20));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add(new Segment(50));
		segs.add(new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
	}
	
	private void updateSegments(){
		segs.get(0).setJonc(jonctions.get(3));
		segs.get(1).setJonc(jonctions.get(0));
		segs.get(2).setJonc(jonctions.get(4));
		segs.get(3).setJonc(jonctions.get(0));
		segs.get(4).setJonc(jonctions.get(5));
		segs.get(5).setJonc(jonctions.get(0));
		segs.get(6).setJonc(jonctions.get(1));
		segs.get(7).setJonc(jonctions.get(0));
		segs.get(8).setJonc(jonctions.get(6));
		segs.get(9).setJonc(jonctions.get(1));
		segs.get(10).setJonc(jonctions.get(7));
		segs.get(11).setJonc(jonctions.get(1));
		segs.get(12).setJonc(jonctions.get(2));
		segs.get(13).setJonc(jonctions.get(1));
		segs.get(14).setJonc(jonctions.get(3));
		segs.get(15).setJonc(jonctions.get(2));
		segs.get(16).setJonc(jonctions.get(8));
		segs.get(17).setJonc(jonctions.get(2));
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
