import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PolaznikTest {
    @Test
     void dvaPolaznikaSJednakimMailomSuJednaka(){
        Polaznik prvi = new Polaznik("1","1","1@gmail.com",2024);
        Polaznik drugi = new Polaznik("2","2","1@gmail.com",2027);

        boolean rezultat = prvi.equals(drugi);

        assertTrue(rezultat);
    }

    @Test
    void dvaPolaznikaSRazlicitimMailomNisuJednaki(){
        Polaznik prvi = new Polaznik("1","1","1@gmail.com",2024);
        Polaznik drugi = new Polaznik("2","2","2@gmail.com",2027);

        boolean rezultat = prvi.equals(drugi);

        assertFalse(rezultat);
    }

    @Test
    void jednakiPolazniciImajuJednakHashCode() {
        Polaznik prvi = new Polaznik("Matej", "Mance", "test@gmail.com", 2024);
        Polaznik drugi = new Polaznik("Ivan", "Horvat", "test@gmail.com", 2025);

        int prviHash = prvi.hashCode();
        int drugiHash = drugi.hashCode();

        assertEquals(prviHash, drugiHash);

    }
    @Test
    void prviPolaznikDolaziPrijeDrugog(){
        Polaznik prvi = new Polaznik("Matej", "Mance", "a@gmail.com", 2024);
        Polaznik drugi = new Polaznik("Ivan", "Horvat", "b@gmail.com", 2025);

        int rezultat = prvi.compareTo(drugi);
        assertTrue(rezultat < 0);

    }
    @Test
    void prviPolaznikDolaziNakonDrugog(){
        Polaznik prvi = new Polaznik("Matej", "Mance", "b@gmail.com", 2024);
        Polaznik drugi = new Polaznik("Ivan", "Horvat", "a@gmail.com", 2025);

        int rezultat = prvi.compareTo(drugi);
        assertTrue(rezultat > 0);
    }
    @Test
    void istiEmailVracaNulu(){
        Polaznik prvi = new Polaznik("Matej", "Mance", "a@gmail.com", 2024);
        Polaznik drugi = new Polaznik("Ivan", "Horvat", "a@gmail.com", 2025);

        int rezultat = prvi.compareTo(drugi);
        assertEquals(0, rezultat);
    }

}
