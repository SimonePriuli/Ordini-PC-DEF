import java.io.Serializable;

public class Nodo implements Serializable
{
	private Ordine info;
	private Nodo link;
	
	public Nodo(Ordine persona)
	{
		setInfo(persona);
		link=null;
	}

	public Ordine getInfo() 
	{
		return info;
	}

	public void setInfo(Ordine info) 
	{
		this.info = info;
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}
