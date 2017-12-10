import java.util.Observable;


public abstract class Vehicule extends Observable{
	
	private final String id;
	protected int vitesseMax;
	protected int vitesse;
	private int position;
	private Segment seg;
	
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
	
	public Segment getSeg() {
		return seg;
	}

	public void setDest(Segment seg) {
		this.seg = seg;
	}
	
	public String getId() {
		return id;
	}

}
