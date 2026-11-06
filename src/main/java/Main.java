import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        PolaznikRepository polaznikRepository = new PolaznikRepository();
        List<Polaznik> listaPolaznika;

        try {
            String trazeniEmail = "1@gmail.com";

            Optional<Polaznik> polaznik1 = polaznikRepository.dohvatiPoMailu(trazeniEmail);

            if(polaznik1.isEmpty()){
                System.out.println("Ne postoji polaznik s trazenim mailom!");
            }else {
                System.out.println(polaznik1);
            }

            Polaznik noviPolaznik = new Polaznik("Antonio","Stejpanovic","2@gmail.com",2026);
            polaznikRepository.dodajPolaznika(noviPolaznik);

            System.out.println("\n \n");


            polaznikRepository.azurirajGodinuUpisa("2@gmail.com",2029);

            System.out.println(polaznikRepository.dohvatiPoMailu("2@gmail.com"));

            System.out.println("\n \n");

            polaznikRepository.obrisiPolaznika("2@gmail.com");

            System.out.println("\n \n");

            listaPolaznika = polaznikRepository.dohvatiSvePolaznike();

            listaPolaznika.forEach(polaznik -> {System.out.println(polaznik+ "\n"); });
            System.out.println("Broj polaznika:"+listaPolaznika.size());

            System.out.println("\n \n");

            Polaznik polaznik2 = new Polaznik("Karla","Sostar","ksostar@gmail.com",2026);
            Polaznik polaznik3 = new Polaznik("Stjepko","Kovacic","skovacic@gmail.com",2026);

            polaznikRepository.dodajDvaPolaznika(polaznik2,polaznik3);

            System.out.println(polaznikRepository.dohvatiPoMailu("ksostar2mn  @gmail.com"));
            System.out.println(polaznikRepository.dohvatiPoMailu("skovacic@gmail.com"));








        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}