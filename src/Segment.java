import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public class Segment implements LimiteVitesse {

	private int longueur;
	private int vitesseMax;
	private ArrayList<Semaphore> semaphores;
	private ArrayList<Capteur> capteurs;
	private ArrayList<Voiture> voitures;
	private Jonction origine;
	private Jonction dest;
	private final char id;
	private static char lettre = 'A';
	
	/**
	 * 
	 */
	public Segment(int longueur) {
		voitures = new ArrayList<Voiture>();
		semaphores = new ArrayList<Semaphore>();
		capteurs = new ArrayList<Capteur>();
		id = lettre;
		this.longueur = longueur;
		//valeur inadmissible mise par defaut, en attendant le calcul d'une vraie valeur
		vitesseMax = -1;
		
	}
	
	public void setDest(Jonction j){
		dest = j;
	}
	
	public int getLongueur(){
		return longueur;
	}
	
	public Jonction getOrigine() {
		return origine;
	}

	public void setOrigine(Jonction jonc) {
		origine = jonc;
	}
	
	public char getId(){
		return id;
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

	@Override
	public int vitesseLimite(){
		if (((Feu)semaphores.get(semaphores.size()-1)).getCoul() == Couleur.ROUGE)
			vitesseMax = 0;
		
		else
		{
			int limite = -1;
			
			for (int i = 0 ; i<semaphores.size() ; i++)
			{
				if (semaphores.get(i) instanceof LimiteVitesse)
				{
					if (limite == -1)
						limite = ((LimiteVitesse)semaphores.get(i)).vitesseLimite();
					else
						if (limite > ((LimiteVitesse)semaphores.get(i)).vitesseLimite())
							limite = ((LimiteVitesse)semaphores.get(i)).vitesseLimite();
					
						
				}
					
			}
			vitesseMax = limite;
			if (((Feu)semaphores.get(semaphores.size()-1)).getCoul() == Couleur.ORANGE)
				vitesseMax = vitesseMax/2;

		}
		
		return vitesseMax;
	}

	@Override
	public String toString(){
		return "Le segment " + id + " relie les jonctions " + origine.getId() + " et " + dest.getId();
	}
	
	//FONCTION UPDATE DES VOITURE?
	
	public static void main(String[] args) {
	Segment seg = new Segment(50);
	//seg.semaphores.add(e)

	}
}
