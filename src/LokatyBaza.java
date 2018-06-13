import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lokaty")
public class LokatyBaza {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private double kwota;

    private double oprocentowanie;

    private Integer okres;
    
    private Integer okres2;
    
    private Integer kapitalizacja;
    
    private String telefon;

    private String wynik;
    

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(double oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public Integer getOkres() {
		return okres;
	}

	public void setOkres(Integer okres) {
		this.okres = okres;
	}

	public Integer getKapitalizacja() {
		return kapitalizacja;
	}

	public void setKapitalizacja(Integer kapitalizacja) {
		this.kapitalizacja = kapitalizacja;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public Integer getOkres2() {
		return okres2;
	}

	public void setOkres2(Integer okres2) {
		this.okres2 = okres2;
	}

	public String getWynik() {
		return wynik;
	}

	public void setWynik(String wynik) {
		this.wynik = wynik;
	}
    
}
