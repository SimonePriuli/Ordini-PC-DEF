import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;




public class Time
{

	

	

	public static void main(String[] args)
	{
		
		//---------------------------------esempi di utilizzo della classe LocalDate----------------------------------------------------------------------------
		
		// di seguito vengono mostrati solo alcuni metodi, si può approfondire l'utilizzo nella documentazione di Oracle
		
		
		//La classe LocalDate consente di costruire oggetti immtabili (come i tipi di dati nativi)
		// of: costruttore che istanzia un oggetto di classe LocalDate a partire da 3 interi (anno, mese, giorno)
		LocalDate data1= LocalDate.of(2018, 1, 1);
		
		//altri modi per costruire la data
		LocalDate data2= LocalDate.of(2018, Month.APRIL, 8);
		
		//from: Costruttore di copia
		LocalDate data3=LocalDate.from(data2);
		
		//convertire la data in stringa
		System.out.println(data1.toString());
		System.out.println(data2);
		System.out.println(data3);
		
		//ottenere i valori di anno, mese e giorno come interi
		int anno=data1.getYear();
		int mese=data1.getMonthValue();
		int giorno=data1.getDayOfMonth();
		System.out.println(giorno+" "+ mese+" "+anno);
		
		//ottenere il numero di giorni del mese
		int numeroGiorniMese= data1.lengthOfMonth();
		System.out.println(numeroGiorniMese);
		
		//ottenere il NOME del giorno della settimana o del mese dell'anno
		DayOfWeek giornoDellaSettimana = data1.getDayOfWeek();
		System.out.println(giornoDellaSettimana);
		Month meseDellaAnno=data1.getMonth();
		System.out.println(meseDellaAnno);
		
		//verificare se una data è bisestile
		boolean bisestile=data1.isLeapYear();
		System.out.println(data1+" bisestile? "+ bisestile);
		
		//Confrontare due date:
		//risultato=0 --> Le due date sono uguali
		//risultato>0 --> La data "parametro" è precedente alla data "oggetto"
		//risultato<0 --> La data "parametro" è successiva alla data "oggetto"
		System.out.println(data2.compareTo(data1));
		
		//altro modo per confrontare due date
		System.out.println(data1.isAfter(data2));
		System.out.println(data1.isBefore(data2));
		System.out.println(data1.isEqual(data2));
		
		//Aggiungere o togliere giorni o mesi o anni ad una data
		//dall' 8 aprile al 1 maggio
		data2=data2.plusDays(23);  
		System.out.println(data2);
		//dal 1 gennaio 2018 al 1 Febbraio 2019	
		data1=data1.plusMonths(13);	
		System.out.println(data1);
		//dal 1 maggio al 30 arile
		data2=data2.minusDays(1);
		System.out.println(data2);
		
		//ottenere la data odierna
		LocalDate oggi=LocalDate.now();
		System.out.println("Oggi è il "+oggi);
		
		//Calcolare la differnza fra due date in giorni mesi anni.
		//Per svolgere questa operazione è necessario defire una variabile di tipo "Period"
		//da cui estrarre con apositi metodo getter i mesi, i giorni e gli anni
		data1=LocalDate.of(2018, 1, 1);
		data2=LocalDate.of(2018, 5, 2);
		Period periodo=data1.until(data2);
		System.out.println("Dal 1 gennaio al 2 Maggio 2018 sono trascorsi: "+periodo.getYears()+" anni, "+periodo.getMonths()+" mesi e "+periodo.getDays()+" giorni");
		//Calcolare la differenza fra due date in termini di giorni (si può fare nch per i mesi o gli anni)
		//
		long giorniTrascorsi=data1.until(data2, ChronoUnit.DAYS);
		System.out.println("Dal 1 gennaio al 2 Maggio 2018 sono trascorsi: "+ giorniTrascorsi+" giorni");
		
		
		
		
		
		
	//---------------------------------------esempi di utilizzo della classe LocalTime---------------------------------------------------------------------------------
	
		//la classe è l'omologa di LocalDate per il tempo espresso in ore, mminuti, secondi
	// di seguito vengono mostrati solo alcuni metodi, si può approfondire l'utilizzo nella documentazione di Oracle
		
		//Costruttori
		LocalTime tempo1=LocalTime.of(8, 0,0);
		LocalTime tempo2=LocalTime.from(tempo1);
		System.out.println(tempo1);
		System.out.println(tempo2);
		
		//Ora attuale
		LocalTime adesso=LocalTime.now();
		System.out.println("Sono le ore: "+adesso);
		
		//Aggiunta o sottrazione di tempo
		tempo1=LocalTime.of(8, 0,0);
		//aggiungo un'ora alle 8.00
		tempo2=tempo1.plusHours(1); 
		System.out.println(tempo2);
		//sottraggo 10 minuti ale 8.00
		tempo2=tempo1.minusMinutes(10);
		System.out.println(tempo2);
		
		//Confronto fra due tempi
		if (tempo1.isAfter(tempo2))
			System.out.println(tempo1 + " è successivo a "+tempo2);
		if (tempo2.isBefore(tempo1))
			System.out.println(tempo2+ " è precedente a "+tempo1);
	
		//Calcolare la differnza fra due date in ore, oppure in minuti,oppure in secondi.
		//Per svolgere questa operazione si utilizza il metodo until, specificando l'unità
		//di misura temporale (HOURS, MINUTES, SECONDS) in cui si vule ottenere il risultato.
		//il risultato di tipo long
		tempo1=LocalTime.of(8, 0,0);
		tempo2=LocalTime.of(10, 24,12);
		long differenzaOre=tempo1.until(tempo2, ChronoUnit.HOURS);
		System.out.println("dalle "+tempo1 +" alle "+tempo2+ " le ore trascorse sono: "+differenzaOre);
		long differenzaMinuti=tempo1.until(tempo2, ChronoUnit.MINUTES);
		System.out.println("dalle "+tempo1 +" alle "+tempo2+ " i minuti trascorsi sono: "+differenzaMinuti);
		long differenzaSecondi=tempo1.until(tempo2, ChronoUnit.SECONDS);
		System.out.println("dalle "+tempo1 +" alle "+tempo2+ " i secondi trascorsi sono: "+differenzaSecondi);
		
		
		
		
		//---------------------------------esempi di utilizzo della classe LocalDateTime----------------------------------------------------------------------------
		// la classe consente di gestire oggetti immutabili di tipo LocalDateTime che rappresentano conteemporanemante date e tempi
		
		// di seguito vengono mostrati solo alcuni metodi, si può approfondire l'utilizzo nella documentazione di Oracle
				
		//Costruttore (of) e costruttore di copia (from)
		LocalDateTime dataOra1=LocalDateTime.of(2018 , 4, 1, 8, 10,12);
		LocalDateTime dataOraCopia=LocalDateTime.from(dataOra1);
		System.out.println(dataOra1);
		//Costruttore con Localdate e LocalTime come parametro
		LocalDate data= LocalDate.of(2018, 3, 1);
		LocalTime ora=LocalTime.of(16, 30,0);
		LocalDateTime dataOra2=LocalDateTime.of(data,ora);
		System.out.println(dataOra2);
				
		//Data e Ora attuale
		LocalDateTime dataOraAttuale=LocalDateTime.now();
		System.out.println("Questo istante: "+dataOraAttuale);
		
		//Aggiunta o sottrazione di tempo
		//aggiungo due giorni
		dataOra2=dataOra1.plusDays(2);
		System.out.println(dataOra2);
		//sottraggo 10 secondi
		dataOra2=dataOra1.minusSeconds(10);
		System.out.println(dataOra2);
		
		//Confronto fra due momenti
		if (dataOra1.isAfter(dataOra2))
			System.out.println(dataOra1 + " è successivo a "+dataOra2);
		if (dataOra2.isBefore(dataOra1))
			System.out.println(dataOra2+ " è precedente a "+dataOra2);
		if (dataOra2.isEqual(dataOra2))
			System.out.println(dataOra2+ " è uguale a "+dataOra2);
		
		
				
		//Calcolare la differnza fra due oggetti di tipo DataOra in anni, oppure in mesi, o in giorni, o in ore, o in minuti, oppure in secondi.
		//Per svolgere questa operazione si utilizza il metodo until, specificando l'unità
		//di misura temporale (YEAR,MONTHS, DAY, HOURS, MINUTES, SECONDS) in cui si vule ottenere il risultato.
		//il risultato di tipo long
		
		LocalDateTime dataOraX=LocalDateTime.of(2018 , 4, 1, 8, 0,0);
		LocalDateTime dataOraY=LocalDateTime.of(2018 , 5, 2, 10, 10,0);
		
		long differenzaInOre=dataOraX.until(dataOraY, ChronoUnit.HOURS);
		System.out.println("dalle "+dataOraX +" alle "+dataOraY+ " le ore trascorse sono: "+differenzaInOre);
		long differenzaInMinuti=dataOraX.until(dataOraY, ChronoUnit.MINUTES);
		System.out.println("dalle "+dataOraX +" alle "+dataOraY+ " i minuti trascorsi sono: "+differenzaInMinuti);
		long differenzaInSecondi=dataOraX.until(dataOraY, ChronoUnit.SECONDS);
		System.out.println("dalle "+dataOraX +" alle "+dataOraY+ " i secondi trascorsi sono: "+differenzaInSecondi);
		
		long differenzaInAnni=dataOraX.until(dataOraY, ChronoUnit.YEARS);
		System.out.println("dalle "+dataOraX +" alle "+dataOraY+ " gli anni trascorsi sono: "+differenzaInAnni);
		long differenzaInMesi=dataOraX.until(dataOraY, ChronoUnit.MONTHS);
		System.out.println("dalle "+dataOraX +" alle "+dataOraY+ " i mesi trascorsi sono: "+differenzaInMesi);
		long differenzaInGiorni=dataOraX.until(dataOraY, ChronoUnit.DAYS);
		System.out.println("dalle "+dataOraX +" alle "+dataOraY+ " i secondi trascorsi sono: "+differenzaInGiorni);
		
	}

}
