import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "kredyty")
public class KredytyBaza {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private double kwota;

    private double oprocentowanie;

    private double okres;
    
    private Integer typ;
    
    private String telefon;
    
    private String wynik;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public double getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(double oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public double getOkres() {
		return okres;
	}

	public void setOkres(double okres) {
		this.okres = okres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Integer getTyp() {
		return typ;
	}

	public void setTyp(Integer typ) {
		this.typ = typ;
	}

	public String getWynik() {
		return wynik;
	}

	public void setWynik(String wynik) {
		this.wynik = wynik;
	}
}
