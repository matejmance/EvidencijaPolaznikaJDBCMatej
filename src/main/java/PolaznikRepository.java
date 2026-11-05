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


}
