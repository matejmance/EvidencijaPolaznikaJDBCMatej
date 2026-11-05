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

        ArrayList<Polaznik> listaPolaznika = new ArrayList<>();



        try(Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database.");

            String sql = "SELECT * FROM Polaznik";

            try(PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    String ime = rs.getString("Ime");
                    String prezime = rs.getString("Prezime");
                    String email = rs.getString("Email");
                    int godinaUpisa = rs.getInt("GodinaUpisa");


                    Polaznik polaznik =  new Polaznik(ime, prezime, email, godinaUpisa);
                    listaPolaznika.add(polaznik);
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        listaPolaznika.forEach(System.out::println);
        System.out.println();
        System.out.println("Broj polaznika: " + listaPolaznika.size());


    }
}