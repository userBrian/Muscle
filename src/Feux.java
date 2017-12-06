
//GO FAIRE UN PATTERN STATE
public abstract class Feux {

	/**
	 * @param args
	 */
	
	//va surement changer
	private int etat;
	
	public Feux(){
		this.etat = 0;
	}
	
	//modifiera l'etat du feu en fonction de son chrono
	public abstract void changeState();
	
	public int getEtat() {
		return etat;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
