import java.util.Observable;


public abstract class Vehicule extends Observable{

	/**
	 * @param args
	 */
	
	private final String id;
	protected int vitesseMax;
	protected int vitesse;
	private int position;
	private Segment dest;
		
	//manque l'initialisation du segment
	// On peut pas le faire dans le construteur je pense
	public Vehicule(String id) {
		this.id = id;
		this.vitesse = 0;
		this.position = 0;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
		setChanged();
		notifyObservers();
	}

	public int getVitesse() {
		return vitesse;
	}

	public abstract void setVitesse(int vitesse);
	
	public Segment getDest() {
		return dest;
	}

	public void setDest(Segment dest) {
		this.dest = dest;
	}
	
	public String getId() {
		return id;
	}

}
