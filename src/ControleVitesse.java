
//CETTE CLASSE DEVIENT INUTILE
public abstract class ControleVitesse extends Semaphore{

	/**
	 * 
	 */
	private int vitesseLimite;
	
	
	public ControleVitesse() {
		super();
	}


	public int getVitesseLimite() {
		return vitesseLimite;
	}
	
	public void setVitesseLimite(int vitesseLimite){
		this.vitesseLimite = vitesseLimite;
	}

}
