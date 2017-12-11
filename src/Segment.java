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
	private Jonction jonc;
	public final char id;
	private static char lettre = 'A';
	
	/**
	 * 
	 */
	public Segment(int longueur) {
		voitures = new ArrayList<Voiture>();
		semaphores = new ArrayList<Semaphore>();
		capteurs = new ArrayList<Capteur>();
		id = lettre;
		//lettre++;
		this.longueur = longueur;
	}
	
	public Jonction getJonc() {
		return jonc;
	}

	public void setJonc(Jonction jonc) {
		this.jonc = jonc;
	}

	public static char getLettre() {
		return lettre;
	}

	public static void setLettre(char lettre) {
		Segment.lettre = lettre;
	}
	
	

	public ArrayList<Semaphore> getSemaphores() {
		return semaphores;
	}

	public void setSemaphores(ArrayList<Semaphore> semaphores) {
		this.semaphores = semaphores;
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
		return id + "";
	}
	
	//FONCTION UPDATE DES VOITURES
}
