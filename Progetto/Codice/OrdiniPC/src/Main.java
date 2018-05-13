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

/**
 * Il main in questo progetto utilizzando la classe Menu, permette all'utente di interfacciarsi con il software. L'utente ha 8 
 * opzioni che si ripetono all'interno di un ciclo do, while dove la condizione non si verifica mai, di fatto c'è l'apposita
 * funzione (6): esci che appunto fa concludere il ciclo con l'istruzione break;
 * Le voci: Registra Nuovo Ordine, Elimina Ordine, Visualizza Ordini Da Evadere, Visualizza Ordini Evasi, Visualizza Ordini Cliente
 * , Esci & Resetta tutte le liste. Sfruttano i metodi delle altre classi per permettere all'utente di svolgere le funzioni del programma.
 * La funzione (7) resetta tutte le liste è stata aggiunnta in seguito per semplificare i test.
 * @author simonepriuli
 *
 */

public class Main 
{

	public static void main(String[] args) throws ClassNotFoundException, IOException, FestaException  
	{
		String[] menu  = new String[8];
		menu[0]="Registra Nuovo Ordine ";
		menu[1]="Elimina Ordine ";
		menu[2]="Evadi Ordine ";
		menu[3]="Visualizza Ordini Da Evadere ";
		menu[4]="Visualizza Ordini Evasi";
		menu[5]="Visualizza Ordini Cliente ";
		menu[6]="Esci";
		menu[7]="Resetta tutte le liste";
		
		Scanner tastiera=new Scanner(System.in);
		int a = 0;
		Lista l1 = new Lista(); //ordini da evadere
		Lista l2 = new Lista(); //ordini eliminati
		Lista l3 = new Lista(); //ordini evasi
		LocalDate data= LocalDate.now();
		
		l1=l1.caricaFesta("lista.csv");
		//l2.salvaFesta("listaEliminati.csv");
		l2=l2.caricaFesta("listaEliminati.csv");
		//l2.salvaFesta("listaEvasi.csv");
		l3=l3.caricaFesta("listaEvasi.csv");
		
		
		do 
		{
			
			System.out.println("");
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
						l2.inserisciInTesta(o2);
						o2 = null;
					}
				}
				if (codevf==false)
					System.out.println("Nessun elemento corrispondente");
				l1.salvaFesta("lista.csv");
				l2.salvaFesta("listaEliminati.csv");
			}
			else if (a==2) //evadi ordine
			{
				
				System.out.println("Inserisci il codice dell'ordine che vuoi evadere");
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
						System.out.println("Ordine evaso!");
						l3.inserisciInTesta(o2);
						o2 = null;
					}
				}
				
				if (codevf==false)
					System.out.println("Nessun elemento corrispondente");
				l1.salvaFesta("lista.csv");
				l3.salvaFesta("listaEvasi.csv");
				
				
				
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
			
			else if (a==7)
			{
				for (int i = 1; i <= l1.getElementi(); i++)
				{
					l1.eliminaInPosizione(i);
					l1.salvaFesta("lista.csv");
					System.out.println("Lista ordini da evadere resettata");
				}
				for (int i = 1; i <= l2.getElementi(); i++)
				{
					l2.eliminaInPosizione(i);
					l2.salvaFesta("listaEliminati.csv");
					System.out.println("Lista ordini eliminati resettata");
				}
				for (int i = 1; i <= l3.getElementi(); i++)
				{
					l3.eliminaInPosizione(i);
					l3.salvaFesta("listaEvasi.csv");
					System.out.println("Lista ordini evasi resettata");
				}
			}
			else if (a==6)
				break;
			
			else if (a==4)
			{
				for (int i = 1; i <= l3.getElementi(); i++) 
				{
					Ordine o2 = l3.getInvitato(i);
					
						System.out.println("ORDINE:");
						System.out.println(o2.getCodice());
						System.out.println(o2.getNomeCliente());
						System.out.println("");
				}
			}
			
			else if (a==5)
			{
				System.out.println("Inserisci il nome del cliente del quale vuoi vdere gli ordini");
				tastiera.nextLine();
				
				String nome;
				boolean codevf = false;
				Ordine o2 = new Ordine();
				
				nome = tastiera.nextLine();
				
				System.out.println("ORDINI DA EVADERE");
				
				for (int i = 1; i <= l1.getElementi(); i++) 
				{
					o2 = l1.getInvitato(i);
					if (o2.getNomeCliente().compareToIgnoreCase(nome)==0)
					{
						System.out.println("ORDINE:");
						System.out.println(o2.getCodice());
						System.out.println(o2.getNomeCliente());
						System.out.println("");
					}
				}
				
				System.out.println("ORDINI ELIMINATI");
				
				for (int i = 1; i <= l2.getElementi(); i++) 
				{
					o2 = l2.getInvitato(i);
					if (o2.getNomeCliente().compareToIgnoreCase(nome)==0)
					{
						System.out.println("ORDINE:");
						System.out.println(o2.getCodice());
						System.out.println(o2.getNomeCliente());
						System.out.println("");
					}
				}
				
				System.out.println("ORDINI EVASI");
				
				for (int i = 1; i <= l3.getElementi(); i++) 
				{
					o2 = l3.getInvitato(i);
					if (o2.getNomeCliente().compareToIgnoreCase(nome)==0)
					{
						System.out.println("ORDINE:");
						System.out.println(o2.getCodice());
						System.out.println(o2.getNomeCliente());
						System.out.println("");
					}
				}
				
				if (codevf==false)
					System.out.println("Nessun elemento corrispondente");
				
				
				
			}
		}while (true);
		
		
		
		
		
		
		
		
		
		

	}

}
