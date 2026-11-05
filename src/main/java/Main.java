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

        try(Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database.");

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Polaznik");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String ime =  rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String email = rs.getString("Email");
                String godinaUpisa = rs.getString("GodinaUpisa");
                System.out.println("Ime: "+ime);
                System.out.println("Prezime: "+prezime);
                System.out.println("Email: "+email);
                System.out.println("Godina upisa: "+godinaUpisa);
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}