import java.util.Observable;


public abstract class Vehicule extends Observable{

	/**
	 * @param args
	 */
	
	protected final String id;
	protected int vitesse;
	protected int position;
	protected Segment seg;
	protected final int vitesseMax;
		
	//manque l'initialisation du segment
	// On peut pas le faire dans le construteur je pense
	public Vehicule(String id, int vMax) {
		this.id = id;
		this.vitesse = 0;
		this.position = 0;
		vitesseMax = vMax;
	}
	
	public void adapterAllure(){
		if(!seg.getSemaphores().isEmpty()){
			if(seg.getSemaphores().get(seg.getSemaphores().size()-1) instanceof Feu){
				switch(((Feu)seg.getSemaphores().get(seg.getSemaphores().size()-1)).getCoul()){
				case ROUGE:
					vitesse = 0;
					break;
				case ORANGE:
					vitesse /= 2;
					break;
				case VERT:
					setVitesse(seg.vitesseLimite());
					break;
				}
			}
		}
	}
	
	public void avancer(){
		if(vitesse <= seg.getLongueur() - position)
			position += vitesse;
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

	public void setSeg(Segment seg) {
		this.seg = seg;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public String toString(){
		return "Le vehicule " + id + " roule sur le segment " + seg.getId() + " a la position " + position + " a une vitesse de " + vitesse + " m/s.";
	}
}
