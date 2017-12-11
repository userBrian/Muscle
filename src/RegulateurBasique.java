import java.util.ArrayList;


public class RegulateurBasique extends Regulateur {
	//ne prendra pas en compte le traffic, et ne fonctionne qu'avec 
	//un nombre quelconque de feux bicolors
	/**
	 * @param args
	 */
	private int nbFeux;
	
	//initialise tous les feux à rouge, sauf le premier qui est mis à vert
	public RegulateurBasique(Jonction j){
		super(j);
		nbFeux = j.getSegments().size();
		for (int i = 0 ; i<nbFeux ; i++)
		{
				//On considère que le sémaphore récupéré est forcément un feubi
				FeuBi feu = (FeuBi)getJonction().getSegments().get(i)
				.getSemaphores().get(getJonction().getSegments().get(i).getSemaphores().size()-1);
			
			if (i != 0)
				feu.setCoul(Couleur.ROUGE);
			
			else
			{
				feu.setCoul(Couleur.VERT);
				this.setPriorite(getJonction().getSegments().get(i));
			}
			
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

		for (int i = 0 ; i<nbFeux ; i++)
		{
			//On considère que le sémaphore récupéré est forcément un FeuBi
			FeuBi feu = (FeuBi)getJonction().getSegments().get(i)
					.getSemaphores().get(getJonction().getSegments().get(i).getSemaphores().size()-1);
			
			//Si le feu trouvé est vert, on le met à rouge, et on met le feu suivant à vert
			if (feu.getCoul() == Couleur.VERT)
			{
				feu.setCoul(Couleur.ROUGE);
				
				if (i == nbFeux-1)
						i=-1;
				
				feu = (FeuBi)getJonction().getSegments().get(i+1)
					.getSemaphores().get(getJonction().getSegments().get(i+1).getSemaphores().size()-1);
				feu.setCoul(Couleur.VERT);
				this.setPriorite(getJonction().getSegments().get(i));
				
				
				break;
				
			}
			
		}		
		
		setChrono(0);
	}
	
	@Override
	public void updateJonction(){
		incrementeChrono();
		if (this.getChrono() == 3)
		{
			changeState();
			this.setChrono(0);
		}
	}
	
	@Override
	public void printEtatJonction(){
		FeuBi feu;
		for (int i= 0 ; i<nbFeux ; i++)
		{
			feu = (FeuBi)getJonction().getSegments().get(i)
				.getSemaphores().get(getJonction().getSegments().get(i).getSemaphores().size()-1);
			
			System.out.println("Le feu n."+i+" est "+feu.getCoul());
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creation d'une jonction basique
		ArrayList<Segment> seg = new ArrayList<Segment>();
		FeuBi feu;
		for (int i= 0 ; i<3 ; i++)
		{
			seg.add(new Segment(50));
			seg.get(i).getSemaphores().add(new FeuBi(Couleur.ROUGE));
			feu = (FeuBi)seg.get(i).getSemaphores().get(0);
			System.out.println(feu.getCoul());
		}
		
		Jonction jonc = new Jonction(seg);
		RegulateurBasique meh = new RegulateurBasique(jonc);
		System.out.println("\n");
		meh.printEtatJonction();
		
		//Evolution en fonction du temps
		for (int i= 1 ; i<5 ; i++)
		{
			meh.checkTraffic();
			meh.updateJonction();
			System.out.println("au temps : "+meh.getChrono());
			meh.printEtatJonction();
			
		}

	}

}
