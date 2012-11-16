import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;


/**
 * @author Xenos
 *
 *Assure la prise en charge des commandes utilisateur (texte)
 */
public class InputCommand
{

	/**
	 * Gère les commandes entrantes
	 */
	public InputCommand()
	{
		try
		{
			Room salle = (Room)Rooms.get().getRoom("Room1");
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
			while (true)
			{
				String cmd = clavier.readLine();
			}
		}
		catch (Exception e)
		{
			Output.error("Exception caught", e.toString());
		}
	}
}
