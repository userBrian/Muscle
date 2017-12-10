
public abstract class Regulateur {

	/**
	 * @param args
	 */
	public Segment priorite;
	public Jonction jonction;
	public int chrono;
	
	public Regulateur(Jonction j){
		this.jonction = j;
	}
	
	
	public abstract void checkTraffic();
	public abstract void changeState();
	
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
