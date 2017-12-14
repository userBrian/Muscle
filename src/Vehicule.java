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
		
	public Vehicule(String id, int vMax) {
		this.id = id;
		this.vitesse = 0;
		this.position = 0;
		vitesseMax = vMax;
	}
	
	/**
	 * Adapte la vitesse de la voiture a son environnement (segment de route, semaphores)
	 */
	public void adapterAllure(){
		if(!seg.getSemaphores().isEmpty()){
			if(seg.getSemaphores().get(seg.getSemaphores().size()-1) instanceof Feu){
				vitesse = seg.vitesseLimite();
			}
		}
	}
	
	/**
	 * Fait avancer la voiture 
	 */
	public void avancer(){
		if(vitesse <= Math.abs(seg.getLongueur() - position))
			setPosition(position + vitesse);
		else{
			setPosition(vitesse - (Math.abs(seg.getLongueur() - position)));
			seg = seg.getDest().getSegments().get((int)(Math.random()*(seg.getDest().getSegments().size())));
			int i = 0;
			Segment seg2;
			do{
				seg2 = seg.getOrigine().getSegments().get(i);
				i++;
			}while(!(seg.getId() == seg2.getId()));
			
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
