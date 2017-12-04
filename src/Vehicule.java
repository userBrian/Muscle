
public abstract class Vehicule {

	/**
	 * @param args
	 */
	
	private final String id;
	protected int vitesse;
	private int sens;
	private int position;
	private Segment dest;
	
	public Vehicule(String id) {
		this.id = id;
	}
	
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
