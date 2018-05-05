import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		/*test data
		LocalDate data = LocalDate.now();
		
		Ordine n1 = new Ordine(null, null, null, 0, args, 0, data);
		
		n1.setData(data);
		
		System.out.println(n1.getData());
		*/
		
		
		String[] ciao  = new String[6];
		ciao[0]="Registra Nuovo Ordine ";
		ciao[1]="Elimina Ordine ";
		ciao[2]="Evadi Ordine ";
		ciao[3]="Visualizza Ordini Da Evadere ";
		ciao[4]="Visualizza Ordini Evasi ";
		ciao[5]="Visualizza Ordini Cliente ";
		
		Menu.show(ciao);
		
		

	}

}
