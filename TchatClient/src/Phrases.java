
/**
 * @author Xenos
 * Ce que les gens disent sur le chat
 * Cela peut �tre un message, mais AUSSI un �v�nement (connected, out,...)
 */
public class Phrases {

	
	Causeur personneConnect�e;
	String message;
	CauseurEventEnum evenment;
	
	Phrases(Causeur personne, String msg){
		this.personneConnect�e = personne;
		
		String[] parseMessage = msg.split(" ", 8);
		
		if(parseMessage.length != 0){
			if(parseMessage[0].equals(""))
		}
		
	}
}
