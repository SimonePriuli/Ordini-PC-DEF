/**
 * Classe dedicata al menù (viene utilizzata nel main)
 * @author simonepriuli
 *
 */
public class Menu 
{

	public Menu()
	{
		
	}

	public static void show(String[] voci)
	{
		for (int i = 0; i < voci.length; i++) 
		{
			System.out.println(voci[i]+" ---> "+i);
		}
	}
		
}
