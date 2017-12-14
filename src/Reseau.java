import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
	private HashMap<String, Vehicule> voitures;
	private RegulateurBasique reg;
	
	/**
	 * 
	 */
	private Reseau(){
		jonctions = new ArrayList<Jonction>();
		segs = new ArrayList<Segment>();
		voitures = new HashMap<String, Vehicule>();
		
		creerSegments();
		creerJonctions();
		//jonctions.forEach(System.out::println);
		updateSegments();
		addDest();
		//segs.forEach(System.out::println);
		ajouterSemaphores();
		ajouterVoitures();
		ajouterCapteurs();
	}
	
	private void addDest(){
		for(int i = 0; i < jonctions.size(); i++){
			for(int j = 0; j < jonctions.get(i).getSegments().size(); j++)
				jonctions.get(i).getSegments().get(j).setDest(jonctions.get(i));
			//Reseau.reseau.jonctions.get(i).getSegments().forEach(setDest(jonctions.get(i)));
		}
	}
	
	private static void afficherMenu(){
		System.out.println("1. Derouler un intervalle de temps\n2. Consulter segment\n3. Consulter vehicules");
	}
	
	private void ajouterCapteurs(){
		segs.get(0).getCapteurs().add(new Capteur(15));
		segs.get(1).getCapteurs().add(new Capteur(35));
	}
	
	/**
	 * Ajoute des s�maphores au r�seau
	 */
	private void ajouterSemaphores(){
		segs.get(0).getSemaphores().add(new PanneauVitesse(18));
		segs.get(0).getSemaphores().add(new FeuBi(Couleur.ROUGE));
		segs.get(2).getSemaphores().add(new PanneauVitesse(15));
		segs.get(2).getSemaphores().add(new FeuBi(Couleur.ROUGE));
		segs.get(4).getSemaphores().add(new PanneauVitesse(19));
		segs.get(4).getSemaphores().add(new FeuBi(Couleur.ROUGE));
		segs.get(6).getSemaphores().add(new PanneauVitesse(10));
		segs.get(6).getSemaphores().add(new FeuBi(Couleur.ROUGE));
	}
	
	/**
	 * Ajoute des voitures au réseau
	 */
	private void ajouterVoitures(){
		Voiture v1 = new Voiture("Bazinmobile");
		Voiture v2 = new Voiture("Polythug");
		Voiture v3 = new Voiture("Batmobile");
		Voiture v4 = new Voiture("Pussy Wagon");
		
		segs.get(0).getVoitures().add(v1);	v1.setSeg(segs.get(0));	v1.setPosition(0);	
		segs.get(8).getVoitures().add(v2);	v2.setSeg(segs.get(8));	v2.setPosition(5);	
		segs.get(7).getVoitures().add(v3);	v3.setSeg(segs.get(7));	v3.setPosition(0);	
		segs.get(4).getVoitures().add(v4);	v4.setSeg(segs.get(4));	v4.setPosition(0);	/*v4.setVitesse(segs.get(4).vitesseLimite());*/

		voitures.put(v1.getId(), v1);	voitures.put(v2.getId(), v2);	voitures.put(v3.getId(), v3);	voitures.put(v4.getId(), v4);
	}
	
	private void creerJonctions(){
		ArrayList<Segment> aAjouter = new ArrayList<Segment>();
		
		aAjouter.add(segs.get(0));	// A vers J4
		aAjouter.add(segs.get(2));	// B vers B1
		aAjouter.add(segs.get(4));	// C vers B2
		aAjouter.add(segs.get(6));	// D vers J2
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(7));	// D vers J1
		aAjouter.add(segs.get(8));	// E vers B3	
		aAjouter.add(segs.get(10));	// F vers B4
		aAjouter.add(segs.get(12));	// G vers J3
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(13));	// G vers J2
		aAjouter.add(segs.get(14));	// H vers J3
		aAjouter.add(segs.get(16));	// I vers B5
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(1));	// A vers J1
		aAjouter.add(segs.get(15));	// H vers J3
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(3));	// B vers J1
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(5));	// C vers J1
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(9));	// E vers J2
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(11));	// F vers J2
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
		
		aAjouter.add(segs.get(17));	// I vers J3
		jonctions.add(new Jonction(aAjouter));
		Jonction.setNum((int)(Jonction.getNum()+1));
	}
	
	private void creerSegments(){
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(20));
		segs.add( new Segment(20));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
		
		segs.add( new Segment(50));
		segs.add( new Segment(50));
		Segment.setLettre((char)(Segment.getLettre()+1));
	}
	
	private void deroulerIntervalle(){
		// Test
		for(Map.Entry<String, Vehicule> e : voitures.entrySet()){
			e.getValue().adapterAllure();
			e.getValue().avancer();
		}
		reg.nextStep();
	}
	
	public ArrayList<Segment> getSegs() {
		return segs;
	}
	
	private void updateSegments(){
		segs.get(0).setOrigine(jonctions.get(3));
		segs.get(1).setOrigine(jonctions.get(0));
		segs.get(2).setOrigine(jonctions.get(4));
		segs.get(3).setOrigine(jonctions.get(0));
		segs.get(4).setOrigine(jonctions.get(5));
		segs.get(5).setOrigine(jonctions.get(0));
		segs.get(6).setOrigine(jonctions.get(1));
		segs.get(7).setOrigine(jonctions.get(0));
		segs.get(8).setOrigine(jonctions.get(6));
		segs.get(9).setOrigine(jonctions.get(1));
		segs.get(10).setOrigine(jonctions.get(7));
		segs.get(11).setOrigine(jonctions.get(1));
		segs.get(12).setOrigine(jonctions.get(2));
		segs.get(13).setOrigine(jonctions.get(1));
		segs.get(14).setOrigine(jonctions.get(3));
		segs.get(15).setOrigine(jonctions.get(2));
		segs.get(16).setOrigine(jonctions.get(8));
		segs.get(17).setOrigine(jonctions.get(2));
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
		System.out.println(Reseau.reseau.voitures.get("Bazinmobile").getSeg().getDest().getSegments().size());
		boolean continuer = true;
		Scanner sc = new Scanner(System.in);
		Reseau.reseau.reg = new RegulateurBasique(Reseau.reseau.jonctions.get(0));
		
		//System.out.println(Reseau.reseau.jonctions.get(0).toString());
		System.out.println(Reseau.reseau.jonctions.get(0).getSegments().get(0).getSemaphores().size());
		
		System.out.println("Simulation de reseau routier");
		do{
			afficherMenu();
			switch(sc.nextInt()){
			case 1:
				Reseau.reseau.deroulerIntervalle();
				break;
			case 2:
				break;
			case 3:
				//System.out.println(Reseau.reseau.voitures.get("Bazinmobile").toString());
				Reseau.reseau.voitures.values().forEach(System.out::println);
				break;
			case 0:
				continuer = false;
				break;
			default:
				System.out.println("bite");
				break;
			}
		} while(continuer);
		
		sc.close();
	}

}
