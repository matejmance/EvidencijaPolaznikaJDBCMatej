import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    void polazniciSeSortirajuPoEmailu() {
        List<Polaznik> lista = new ArrayList<>();
        Polaznik prvi = new Polaznik("Matej", "Mance", "c@gmail.com", 2024);
        Polaznik drugi = new Polaznik("Ivan", "Horvat", "a@gmail.com", 2025);
        Polaznik treci = new Polaznik("Ivan", "kovacic", "b@gmail.com", 2025);

        lista.add(prvi);
        lista.add(drugi);
        lista.add(treci);


        Collections.sort(lista);

        assertEquals("a@gmail.com", lista.getFirst().getEmail());
        assertEquals("b@gmail.com",lista.get(1).getEmail());
        assertEquals("c@gmail.com",lista.get(2).getEmail());

    }

}
