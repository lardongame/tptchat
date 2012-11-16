import java.rmi.Naming;


/**
 * @author Xenos
 * L'ensemble des salles
 */
public class Rooms {
	/**
	 * Port par défaut pour le serveur
	 */
	private static final int defaultPort = 2129;
	/**
	 * Adresse serveur par défaut
	 */
	private static final String defaultAdress = "127.0.0.1";

	/**
	 * Adresse IP du serveur
	 */
	private String serverAdress;
	/**
	 * Port du serveur
	 */
	private int serverPort;
	
	/**
	 * Instance du gestionnaire des salles
	 */
	private static Rooms instance;
	
	/**
	 * Instancie le gestionnaire des salles
	 * @param serverAdress		Adresse du serveur
	 * @param serverPort		Port du serveur
	 */
	private Rooms(String serverAdress, int serverPort)
	{
		this.setAdress(serverAdress);
		this.setPort(serverPort);
	}

	/**
	 * Renvoie le gestionnaire des salles
	 * @return	Le gestionnaire des salles
	 */
	public static Rooms get()
	{
		if (Rooms.instance == null)
			Rooms.instance = new Rooms(Rooms.defaultAdress, Rooms.defaultPort);
		return (Rooms.instance);
	}
	/**
	 * Définit l'adresse du serveur
	 * @param adress	Adresse serveur (IP)
	 */
	public void setAdress(String adress)
	{
		this.serverAdress = adress;
	}
	
	/**
	 * Définit le port de comunication
	 * @param port	Port de comm serveur
	 */
	public void setPort(int port)
	{
		this.serverPort = port;
	}
	
	/**
	 * Renvoie une salle de chat
	 * @param chatRoomName Le nom de la salle de chat
	 * @return	La salle de chat
	 * @throws RoomException		En cas d'erreur avec la salle 
	 */
	public Room getRoom(String chatRoomName)
		throws RoomException
	{
		try
		{
			return (
					(Room)
					Naming.lookup("//"+this.serverAdress+":"+this.serverPort+"/"+chatRoomName)
					);
		}
		catch (Exception e)
		{
			Output.error(
					"Unable to get chat room", 
					"The chat room is unreachable:\n" + e
					);
			throw new RoomException();
		}
	}
}
