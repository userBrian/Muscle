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
		creerReseau();
	}
	
	/*
	 * Ajouted des s�maphores au r�seau
	 */
	public void ajouterSemaphores(){
		
	}
	
	/**
	 * Ajoute des voitures au r�seau
	 */
	public void ajouterVoitures(){
		Voiture v1 = new Voiture("Bazinmobile");
		Voiture v2 = new Voiture("Polythug");
		Voiture v3 = new Voiture("Batmobile");
		Voiture v4 = new Voiture("Pussy Wagon");
		
		jonctions.get(0).getSegments().get(0).getVoitures().add(v1);	v1.setPosition(0);	v1.setSens(0);	v1.setVitesse(jonctions.get(0).getSegments().get(0).getVitesseMax());
		jonctions.get(0).getSegments().get(0).getVoitures().add(v1);
		jonctions.get(0).getSegments().get(0).getVoitures().add(v1);
		jonctions.get(0).getSegments().get(0).getVoitures().add(v1);
	}
	
	/**
	 * Cr�e des segments de route et des jonctions et les lie entre eux
	 */
	public void creerReseau(){
		jonctions = new ArrayList<Jonction>();
		
		ArrayList<Segment> segs = new ArrayList<Segment>();
		ArrayList<Segment> aAjouter = new ArrayList<Segment>();
		
		for(int i = 0; i < 9; i++)
			segs.add(new Segment(50));
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
