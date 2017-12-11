
public abstract class Regulateur {

	/**
	 * @param args
	 */
	private Segment priorite;
	private Jonction jonction;
	private int chrono;
	
	public Regulateur(Jonction j){
		this.jonction = j;
		this.chrono = 0;
	}
	
	//Regarde le traffique et détermine quelle segment il faudrait prioriser
	public abstract void checkTraffic();
	//Modifie l'etat des feux de la jonction
	public abstract void changeState();
	//détermine quand faire à appel à changeState
	public abstract void updateJonction();
	//affichage de l'etat des feux de la jonction
	public abstract void printEtatJonction();
	
	public Segment getPriorite(){
		return this.priorite;
	}
	
	public void setPriorite(Segment s){
		this.priorite = s;
	}
	
	public Jonction getJonction(){
		return this.jonction;
	}
	
	public void setChrono(int temps){
		this.chrono = temps;
	}
	
	public int getChrono(){
		return this.chrono;
	}
	
	public void incrementeChrono(){
		this.chrono++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
