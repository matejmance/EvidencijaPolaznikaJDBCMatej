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


            System.out.println(polaznikRepository.prebrojiPolaznikeNakonGodine(2020));
            System.out.println(polaznikRepository.prebrojiPolaznikeNakonGodine(2023));
            System.out.println(polaznikRepository.prebrojiPolaznikeNakonGodine(2050));














        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}