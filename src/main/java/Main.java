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


            System.out.println(polaznikRepository.dohvatiPoMailu("1@gmail.com"));
            System.out.println(polaznikRepository.dohvatiPoMailu("2@gmail.com"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}