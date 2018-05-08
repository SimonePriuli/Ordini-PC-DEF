import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) throws ClassNotFoundException, IOException, FestaException  
	{
		String[] menu  = new String[7];
		menu[0]="Registra Nuovo Ordine ";
		menu[1]="Elimina Ordine ";
		menu[2]="Evadi Ordine ";
		menu[3]="Visualizza Ordini Da Evadere ";
		menu[4]="Visualizza Ordini Evasi ";
		menu[5]="Visualizza Ordini Cliente ";
		menu[6]="Esci";
		
		Scanner tastiera=new Scanner(System.in);
		int a = 0;
		Lista l1 = new Lista(); //ordini da evadere
		Lista l2 = new Lista(); //ordini eliminati
		Lista l3 = new Lista(); //ordini evasi
		LocalDate data= LocalDate.now();
		
		l1.salvaFesta("lista.csv");
		l1=l1.caricaFesta("lista.csv");
		
		
		
		do 
		{
			
			Menu.show(menu);
			a = tastiera.nextInt();
			
			if (a==0)
			{
				Ordine o1 = new Ordine();
				System.out.println("Inserisci il codice");
				tastiera.nextLine();
				o1.setCodice(tastiera.nextLine());
				System.out.println("Inserisci il nome del cliente");
				o1.setNomeCliente(tastiera.nextLine());
				System.out.println("Inserisci una breve descrizione");
				o1.setDescrizione(tastiera.nextLine());
				System.out.println("Inserisci il numero di prodotti");
				o1.setNumeroProdotti(tastiera.nextInt());
				System.out.println("Inserisci il fatturato");
				o1.setFatturato(tastiera.nextInt());
				o1.setData(data);
				l1.inserisciInTesta(o1);
				l1.salvaFesta("lista.csv");
				o1 = null;
			}
			else if  (a==1) //elimina ordine
			{
				System.out.println("Inserisci il codice dell'ordine che vuoi eliminare");
				tastiera.nextLine();
				
				String code;
				boolean codevf = false;
				Ordine o2 = new Ordine();
				
				code = tastiera.nextLine();
				
				for (int i = 1; i <= l1.getElementi(); i++) 
				{
					o2 = l1.getInvitato(i);
					if (o2.getCodice().compareToIgnoreCase(code)==0)
					{
						l1.eliminaInPosizione(i);
						codevf = true;
						System.out.println("Ordine eliminato");
						o2 = null;
					}
				}
				if (codevf==false)
					System.out.println("Nessun elemento corrispondente");
			}
			else if (a==2) //evadi ordine
			{
				
			}
			else if (a==3) //visualizza ordine da evadere
			{
				for (int i = 1; i <= l1.getElementi(); i++) 
				{
					Ordine o2 = l1.getInvitato(i);
					if (!(o2.isEvaso()))
					{
						System.out.println("ORDINE:");
						System.out.println(o2.getCodice());
						System.out.println(o2.getNomeCliente());
						System.out.println("");
					}
				}
			}
			
			
		} 
		while (true);
		
		
		
		
		
		
		
		
		
		

	}

}
