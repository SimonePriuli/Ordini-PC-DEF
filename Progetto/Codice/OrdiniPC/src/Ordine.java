import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Ordine 
{
	private String codice;
	private String nomeCliente;
	private String Descrizione;
	private int numeroProdotti;
	private String[] Prodotti;
	private int fatturato;
	private LocalDate data;
	
	
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
