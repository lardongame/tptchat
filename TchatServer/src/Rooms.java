import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Xenos
 * L'ensemble des salles coté serveur
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
	 * Le registre RMI
	 */
	private Registry registre;
	
	/**
	 * Instancie le gestionnaire des salles
	 * @param serverAdress		Adresse du serveur
	 * @param serverPort		Port du serveur
	 */
	private Rooms(String serverAdress, int serverPort)
	{
		this.setAdress(serverAdress);
		this.setPort(serverPort);
		this.newRegistre();
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
	 * Crée le registre RMI et le stocke dans Rooms.registre
	 * @throws Exception		En cas d'impossibilité de créer le registre 
	 */
	private void newRegistre()
		throws Exception
	{
		try
		{
			try
			{
				this.registre = LocateRegistry.getRegistry(this.serverAdress, this.serverPort);
			}
			catch (Exception e)
			{
				Output.verbose("Cannot get registry, trying to create a new one...");
				try
				{
					this.registre = LocateRegistry.createRegistry(this.serverPort);
				}
				catch (Exception ex)
				{
					Output.error("Cannot create registry", "Exception:\n" + ex);
				}
			}
		}
		catch (Exception e)
		{
			Output.error("Cannot create RMI registry", "Exception:\n" + e);
			throw new Exception();
		}
	}
	
	/**
	 * Renvoie le registre RMI actuel
	 * @return	Le registre RMI
	 * @throws Exception Si le registre n'existe pas, on essaie de l'initialiser, en cas d'échec de l'init, l'exception est levée
	 */
	public Registry getRegistry()
		throws Exception
	{
		try
		{
			if (this.registre == null)
				this.newRegistre();
		}
		catch (Exception e)
		{
			Output.error("Cannot get Rooms' RMI registry", "Exception caught:\n " + e);
		}
	}
	
	/**
	 * Crée une nouvelle salle
	 * @param chatRoomName		Nom de la salle
	 * @return		La salle créée
	 * @throws RoomException	En cas d'échec de création de la salle
	 */
	public Room newRoom(String chatRoomName)
		throws RoomException
	{
				
				// Création d ’une instance de l’objet serveur
				Hello obj = new HelloServeur("Coucou");
				System.out.println("Hello instancied");
						
				// Calcul de l’URL du serveur
				host = "127.0.0.1";
				URL = "//" + host + ":" + port
						+ "/" + serviceName;
				System.out.println("URL is " + URL);

				Naming.rebind(URL, obj);
				System.out.println("Rebind done");
			}
			catch (Exception exc)
			{
				System.out.println("Exception caught: " + exc);
			}
	}
}
