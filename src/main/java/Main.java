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

            if(polaznikRepository.dohvatiPoMailu(trazeniEmail).isEmpty()){
                System.out.println("Polaznik s trazenim mailom " +trazeniEmail+ " ne postoji");
            }else {
                System.out.println(polaznikRepository.dohvatiPoMailu(trazeniEmail));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}