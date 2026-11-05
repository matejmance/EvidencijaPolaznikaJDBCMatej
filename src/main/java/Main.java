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

            listaPolaznika = polaznikRepository.dohvatiSvePolaznike();

            listaPolaznika.forEach(polaznik -> {System.out.println(polaznik+ "\n"); });
            System.out.println("Broj polaznika:"+listaPolaznika.size());


            String trazeniEmail = "1@gmail.com";

            Optional<Polaznik> polaznik = polaznikRepository.dohvatiPoMailu(trazeniEmail);

            if(polaznik.isEmpty()){
                System.out.println("Ne postoji polaznik s trazenim mailom!");
            }else {
                System.out.println(polaznik);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}