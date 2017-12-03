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
		segs = new ArrayList<Segment>();
		for(int i = 0; i < 9; i++)
			segs.add(new Segment(50));
		
		creerReseau();
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
	private void creerReseau(){
		jonctions = new ArrayList<Jonction>();
		
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
