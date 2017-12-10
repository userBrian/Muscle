
public class RegulateurBasique extends Regulateur {
	//ne prendra pas en compte le traffic, et ne fonctionne qu'avec 4 feux bicolors
	/**
	 * @param args
	 */
	
	//initialise tous les feux à rouge, sauf le premier.
	public RegulateurBasique(Jonction j){
		super(j);
		for (int i = 0 ; i<4 ; i++)
		{
				//On considère que le sémaphore récupéré est forcément un feubi
				FeuBi feu = (FeuBi)getJonction().getSegments().get(i)
				.getSemaphores().get(getJonction().getSegments().get(i).getSemaphores().size()-1);
			
			if (i != 0)
				feu.setCoul(Couleur.VERT);
			
			else
				feu.setCoul(Couleur.ROUGE);
			
		}
		
	}
	
	
	@Override
	public void checkTraffic(){
		//C'est un régulateur de base qui ne prends pas en compte l'état du reseau
		//la fonction ne fait donc rien
	}
	
	//EN COURS D'ECRITURE
	@Override
	public void changeState(){
		if (getChrono() == 3)
		this.getJonction().getSegments();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
