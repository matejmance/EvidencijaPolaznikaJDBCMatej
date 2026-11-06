import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
