
/**
 * @author Xenos
 * Ce que les gens disent sur le chat
 * Cela peut être un message, mais AUSSI un évènement (connected, out,...)
 */
public class Phrases {

	
	Causeur personneConnectée;
	String message;
	CauseurEventEnum evenment;
	
	Phrases(Causeur personne, String msg){
		this.personneConnectée = personne;
		
		String[] parseMessage = msg.split(" ", 8);
		
		if(parseMessage.length != 0){
			if(parseMessage[0].equals(""))
		}
		
	}
}
