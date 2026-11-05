import java.util.Objects;

public class Polaznik implements Comparable<Polaznik> {
    private String ime;
    private String prezime;
    private String email;
    private int godinaUpisa;

    public Polaznik(String ime, String prezime, String email, int godinaUpisa) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.godinaUpisa = godinaUpisa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    @Override
    public String toString() {
        return "IME: "+ime+"\nPREZIME: "+prezime+"\nEMAIL: "+email+"\nGODINA UPISA: "+godinaUpisa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Polaznik polaznik = (Polaznik) o;
        return Objects.equals(getEmail(), polaznik.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEmail());
    }

    @Override
    public int compareTo(Polaznik o) {
        return this.getEmail().compareTo(o.getEmail());
    }
}
