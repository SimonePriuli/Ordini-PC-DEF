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

	public static void main(String[] args) throws ClassNotFoundException, IOException  
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
		l1.caricaFesta("lista.csv");
		
		
		
		do 
		{
			
			Menu.show(menu);
			a = tastiera.nextInt();
			
			if (a==0)
			{
				Ordine o1 = new Ordine();
				System.out.println("Inserisci il codice");
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
			else if  (a==1)
			{
				System.out.println("Inserisci il codice dell'ordine che vuoi eliminare");
				
			}
			
		} 
		while (true);
		
		
		
		
		
		
		
		
		
		

	}

}
