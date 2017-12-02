import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public class Segment {

	private int longueur;
	private int vitesseMax;
	private ArrayList<Semaphore> semaphores;
	private ArrayList<Capteur> capteurs;
	private ArrayList<Voiture> voitures;
	private Jonction jA;
	private Jonction jB;
	public final char id;
	private static char lettre = 'A';
	
	/**
	 * 
	 */
	public Segment(int longueur) {
		voitures = new ArrayList<Voiture>();
		id = lettre;
		lettre++;
		this.longueur = longueur;
	}

	public Jonction getjA() {
		return jA;
	}

	public void setjA(Jonction jA) {
		this.jA = jA;
	}

	public Jonction getjB() {
		return jB;
	}

	public void setjB(Jonction jB) {
		this.jB = jB;
	}
	
	public ArrayList<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(ArrayList<Voiture> voitures) {
		this.voitures = voitures;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	@Override
	public String toString(){
		if(jA != null && jB != null)
			return id + " complet";
		else
			return id + " incomplet";
	}
}
