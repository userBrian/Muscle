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
				vitesse = seg.vitesseLimite();
			}
		}
	}
	
	public void avancer(){
		if(vitesse <= seg.getLongueur() - position)
			position += vitesse;
		else{
			seg = seg.getDest().getSegments().get((int)(Math.random()*(seg.getDest().getSegments().size())));
			int i = 0;
			Segment seg2;
			do{
				seg2 = seg.getOrigine().getSegments().get(i);
				i++;
			}while(!(seg.getId() == seg2.getId()));
			position = vitesse - (seg.getLongueur() - position);
			seg = seg2;
			for(Capteur c : seg.getCapteurs())
			{
				this.addObserver(c);
			}
		}
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
