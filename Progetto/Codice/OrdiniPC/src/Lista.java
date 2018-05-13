import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * La classe lista è forse la più importante in quanto rende possibile l'implementazione dell'intero software (Sia la gestione 
 * degli ordini che il salvataggio/caricamento su file delle liste stesse). I metodi utilizzati nel main della classe sono: getElementi 
 * (che restituisce il numero degli elementi contenuti all'interno della lista), inserisciInTesta: metodo utilizzato quando si va 
 * ad aggiungere un oggetto di tipo Ordine nel contenuto informativo di un nuovo nodo (per quanto riguarda l'aggiunta si utilizzerà
 * solo questo metodo in quanto il modo con il quale è scritto il programma prevede una lista in ordine di data, ed essendo che la
 * data di un ordine è sempre quella di quando lo si inserisce non risulta necessario inserire ordini in posizioni che non siano la 
 * testa). eliminaInPosizione: viene utilizzato quando si evade o si elimina un ordine (passandogli il codice (string), in questo
 * caso non si utilizza eliminaInTesta in quanto non sempre il nodo da eliminare è l'ultimo inserito. getInvitato: utilizzata per 
 * assegnare un oggetto di tipo Ordine ad un un oggetto vuoto (o1 solitamente) contenente null. Metodo usato per fare confronti fra i codici
 * o fra nome (ricerca/eliminazione/evasione) oppure per loperazione di output su console. Infine caricaFesta e salvaFesta per appunto 
 * caricare e salvare i file.
 * @author simonepriuli
 *
 */

public class Lista implements Serializable
{

	private Nodo head;
	private int elementi;
	
	public Lista()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Ordine ordine, Nodo link)
	{
		Nodo nodo= new Nodo(ordine);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws FestaException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new FestaException("Posizione non valida");
		if (elementi==0)
			throw new FestaException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
	}
	
	public void inserisciInTesta (Ordine persona)
	{
		
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	public void inserisciInCoda(Ordine persona) throws FestaException
	{
		if(elementi==0)
		{
			inserisciInTesta(persona);
			return;
		}
		
		Nodo pn=creaNodo(persona, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	
	public void inseriscInPosizione(Ordine persona,int posizione) throws FestaException
	{
		if (posizione<=1)
		{
			inserisciInTesta(persona);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(persona);
			return;
		}
		
		Nodo pn=creaNodo(persona, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	public void eliminaInTesta() throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	
	public void eliminaInCoda() throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new FestaException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	public String visita (int posizione) throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new FestaException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	
	public Ordine getInvitato (int posizione) throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new FestaException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	
	public void salvaFesta(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Lista caricaFesta (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Lista festa;
		
		festa=(Lista)(reader.readObject());
		file.close();
		return festa;
	}
}
