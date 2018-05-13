import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * La classe ordine rappresenta un Ordine di Pc, contiene gli attributi: Codice, nomeCliente, Descrizione, numeroProdotti, Prodotti
 * , Fatturato, Data (il valore di data è sempre quello di quando si inserisce l'ordine (strategia adottata per far si che la lista
 * degli ordini sia in ordine dal più recente al meno recente)). Contiene inoltre due attributi di tipo boolenan (evaso & eliminato)
 * che non vengono però utilizzati. Attributi inseriti nel caso fossero necessari in una futura manutenzione (include il cambio di 
 * eliminazione ed evasione. Infatti ora ci sono tre liste (eliminati, evasi & da evadere)).
 * @author simonepriuli
 *
 */

public class Ordine implements Serializable
{
	private String codice;
	private String nomeCliente;
	private String Descrizione;
	private int numeroProdotti;
	private String[] Prodotti;
	private int fatturato;
	private LocalDate data;
	private boolean evaso = false;
	private boolean eliminato = true;
	
	
	//costruttore
	public Ordine(String codice, String nomeCliente, String descrizione, int numeroProdotti, String[] prodotti,
			int fatturato, LocalDate data) {
		this.codice = codice;
		this.nomeCliente = nomeCliente;
		Descrizione = descrizione;
		this.numeroProdotti = numeroProdotti;
		Prodotti = prodotti;
		this.fatturato = fatturato;
		this.data = data;
	}

	public Ordine() {
		
	}

	//toString
	@Override
	public String toString() {
		return "Ordine [codice=" + codice + ", nomeCliente=" + nomeCliente + ", Descrizione=" + Descrizione
				+ ", numeroProdotti=" + numeroProdotti + ", Prodotti=" + Arrays.toString(Prodotti) + ", fatturato="
				+ fatturato + ", data=" + data + "]";
	}

	//setter e getter
	
	
	
	public String getCodice() {
		return codice;
	}
	public boolean isEvaso() {
		return evaso;
	}

	public void setEvaso(boolean evaso) {
		this.evaso = evaso;
	}

	public boolean isEliminato() {
		return eliminato;
	}

	public void setEliminato(boolean eliminato) {
		this.eliminato = eliminato;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public int getNumeroProdotti() {
		return numeroProdotti;
	}
	public void setNumeroProdotti(int numeroProdotti) {
		this.numeroProdotti = numeroProdotti;
	}
	public String[] getProdotti() {
		return Prodotti;
	}
	public void setProdotti(String[] prodotti) {
		Prodotti = prodotti;
	}
	public int getFatturato() {
		return fatturato;
	}
	public void setFatturato(int fatturato) {
		this.fatturato = fatturato;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	
	
	
	
	
	
	
	
	
}
