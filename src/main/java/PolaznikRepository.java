import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PolaznikRepository {


    public List<Polaznik> dohvatiSvePolaznike() throws SQLException {
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


                    Polaznik polaznik = new Polaznik(ime, prezime, email, godinaUpisa);
                    listaPolaznika.add(polaznik);
                }

            }
        }
        return listaPolaznika;
    }

    public Optional<Polaznik> dohvatiPoMailu(String trazeniEmail) throws SQLException {
        try(Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database.");
            String sql = "SELECT * FROM Polaznik WHERE Email = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, trazeniEmail);
                try(ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        String ime = rs.getString("Ime");
                        String prezime = rs.getString("Prezime");
                        String email = rs.getString("Email");
                        int godinaUpisa = rs.getInt("GodinaUpisa");

                        Polaznik polaznik = new Polaznik(ime, prezime, email, godinaUpisa);
                        return Optional.of(polaznik);
                    }
                }
            }
        }
        return  Optional.empty();
    }

    public boolean dodajPolaznika(Polaznik polaznik) throws SQLException {
        try(Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database.");

            String sql = "INSERT INTO Polaznik (Ime , Prezime , Email , GodinaUpisa) VALUES (?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, polaznik.getIme());
                statement.setString(2, polaznik.getPrezime());
                statement.setString(3, polaznik.getEmail());
                statement.setInt(4, polaznik.getGodinaUpisa());

                int provjera = statement.executeUpdate();
                if(provjera == 1){
                    System.out.println("Polaznik dodan");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean azurirajGodinuUpisa(String email, int novaGodina) throws SQLException {
        try(Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database.");

            String sql = "UPDATE Polaznik SET GodinaUpisa = ? WHERE Email = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, novaGodina);
                statement.setString(2, email);
                int provjera = statement.executeUpdate();
                if(provjera == 1){
                    System.out.println("Polaznik azuriran");
                    return true;
                }else{
                    System.out.println("Polaznik s tom Email adresom ne postoji");
                }
            }
        }
        return false;
    }

    public boolean obrisiPolaznika(String email) throws SQLException {
        try(Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database.");
            String sql = "DELETE FROM Polaznik WHERE Email = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                int provjera = statement.executeUpdate();
                if(provjera == 1){
                    System.out.println("Polaznik obrisan");
                    return true;
                }else {
                    System.out.println("Polaznik s tom Email adresom ne postoji");
                }
            }
        }
        return false;
    }

    public boolean dodajDvaPolaznika(Polaznik prvi , Polaznik drugi) throws SQLException {
        try(Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database.");
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Polaznik (Ime , Prezime , Email , GodinaUpisa) VALUES (?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, prvi.getIme());
                statement.setString(2, prvi.getPrezime());
                statement.setString(3, prvi.getEmail());
                statement.setInt(4, prvi.getGodinaUpisa());
                int provjera1 = statement.executeUpdate();
                if(provjera1 == 1){
                    System.out.println("Polaznik dodan");
                    return true;
                }

                statement.setString(1, drugi.getIme());
                statement.setString(2, drugi.getPrezime());
                statement.setString(3, drugi.getEmail());
                statement.setInt(4, drugi.getGodinaUpisa());
                int provjera2 = statement.executeUpdate();
                if(provjera2 == 1){
                    System.out.println("Polaznik dodan");
                }

            }
        }
    }


}
