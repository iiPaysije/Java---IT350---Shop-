package GIbson;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import java.sql.Date;

public class Baza {

    private static Connection con = Konekcija.getInstance();
    private String DPCurrentDate;

    public Baza() {
    }

    public ArrayList ispisiGitare() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM gitara";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("PROIZVOD_ID");
                String ime = rs.getString("GITARA_ID");
                int prezime = rs.getInt("PROIZOVD_CENA");

                izlaz = "\nID proizvoda " + aID
                        + "\nime gitare: " + ime
                        + "\ncena gitare: " + prezime
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList ispisiProizvode() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM proizvod";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("PROIZVOD_ID");

                int prezime = rs.getInt("PROIZOVD_CENA");

                izlaz = "\nID proizvoda " + aID
                        + "\ncena : " + prezime
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public void dodajGitaru(int tf1, int tf2, int tf3) {
        try {
            String query = "INSERT INTO gitara (PROIZVOD_ID, GITARA_ID, PROIZOVD_CENA)"
                    + "values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setInt(3, tf3);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje gitare");

        } catch (Exception e) {
            System.err.println("greska u dodajGitaru");
            System.err.println(e.getMessage());
        }
    }

    public void dodajCivije(int tf1, int tf2, int tf4, int tf5, int tf6, String tf7, int tf8) {
        try {
            String query = "INSERT INTO civija (DELOVI_ID, CIVIJA_ID, DELOVI_DATUMIZRADE, DELOVI_CENA, CIVIJA_TIP, CIVIJA_MARKA, CIVIJA_VELICINA)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            Date DPCurrentDate1 = Date.valueOf(DPCurrentDate);
            preparedStmt.setInt(1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setDate(3, DPCurrentDate1);
            preparedStmt.setInt(4, tf4);
            preparedStmt.setInt(5, tf5);
            preparedStmt.setInt(6, tf6);
            preparedStmt.setString(7, tf7);
            preparedStmt.setInt(8, tf8);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje civije");

        } catch (Exception e) {
            System.err.println("greska u dodajCiviju");
            System.err.println(e.getMessage());
        }
    }

    public void dodajKobilice(int tf1, int tf2, int tf4, String tf5) {
        try {
            String query = "INSERT INTO kobilica (DELOVI_ID, KOBILICA_ID, DELOVI_DATUMIZRADE, DELOVI_CENA, KOBILICA_MARKA)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            Date DPCurrentDate1 = Date.valueOf(DPCurrentDate);
            preparedStmt.setInt(1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setDate(3, DPCurrentDate1);
            preparedStmt.setInt(4, tf4);
            preparedStmt.setString(5, tf5);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje kobilice");

        } catch (Exception e) {
            System.err.println("greska u dodajKobilicu");
            System.err.println(e.getMessage());
        }
    }

    public void dodajTelo(int tf1, int tf2, int tf4, int tf5, int tf6) {
        try {
            String query = "INSERT INTO telo (DELOVI_ID, TELO_ID, DELOVI_DATUMIZRADE, DELOVI_CENA, TELO_TIP, TELO_VELICINA)"
                    + "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            Date DPCurrentDate1 = Date.valueOf(DPCurrentDate);
            preparedStmt.setInt(1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setDate(3, DPCurrentDate1);
            preparedStmt.setInt(4, tf4);
            preparedStmt.setInt(5, tf5);
            preparedStmt.setInt(6, tf6);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje tela");

        } catch (Exception e) {
            System.err.println("greska u dodajTelo");
            System.err.println(e.getMessage());
        }
    }

    public void dodajZicu(int tf1, int tf2, int tf4, int tf5) {
        try {
            String query = "INSERT INTO zica (DELOVI_ID, ZICA_ID, DELOVI_DATUMIZRADE, DELOVI_CENA, ZICA_TIP)"
                    + "values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            Date DPCurrentDate1 = Date.valueOf(DPCurrentDate);
            preparedStmt.setInt(1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setDate(3, DPCurrentDate1);
            preparedStmt.setInt(4, tf4);
            preparedStmt.setInt(5, tf5);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje zice");

        } catch (Exception e) {
            System.err.println("greska u dodajZicu");
            System.err.println(e.getMessage());
        }
    }

    public void dodajProdaju(int tf1, String tf2) {
        try {
            String query = "INSERT INTO prodaja (PRODAJA_ID, PRODAJA_LOKACIJA, PROAJA_DATUM)"
                    + "values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            Date DPCurrentDate1 = Date.valueOf(DPCurrentDate);
            preparedStmt.setInt(1, tf1);
            preparedStmt.setString(2, tf2);
            preparedStmt.setDate(3, DPCurrentDate1);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje Prodaje");

        } catch (Exception e) {
            System.err.println("greska u dodajProdaju");
            System.err.println(e.getMessage());
        }
    }

    public void dodajMandolinu(int tf1, int tf2, int tf3) {
        try {
            String query = "INSERT INTO mandolina (PROIZVOD_ID, MANDOLINA_ID, PROIZOVD_CENA)"
                    + "values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setInt(3, tf3);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje mandoline");

        } catch (Exception e) {
            System.err.println("greska u dodajMandolinu");
            System.err.println(e.getMessage());
        }
    }

    public void dodajProizvod(int tf1, int tf2) {
        try {
            String query = "INSERT INTO proizvod (PROIZVOD_ID, PROIZOVD_CENA)"
                    + "values (?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, tf1);
            preparedStmt.setInt(2, tf2);
            ;

            preparedStmt.executeUpdate();
            System.out.println("Uspesno dodavanje proizvoda");

        } catch (Exception e) {
            System.err.println("greska u dodajProizvod");
            System.err.println(e.getMessage());
        }
    }

    public ArrayList ispisiZice() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM zica";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("DELOVI_ID");
                String ime = rs.getString("ZICA_ID");
                int prezime = rs.getInt("DELOVI_CENA");
                int velicina = rs.getInt("ZICA_TIP");

                izlaz = "\nID  " + aID
                        + "\nID ZICE: " + ime
                        + "\ncena: " + prezime
                        + "velcina zice: " + velicina
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList ispisiProdaje() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM prodaja";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("PRODAJA_ID");
                String ime = rs.getString("PRODAJA_LOKACIJA");

                izlaz = "\nID prodaje  " + aID
                        + "\nna lokaciji: " + ime
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList ispisiTelo() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM telo";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("DELOVI_ID");
                String ime = rs.getString("TELO_ID");
                int prezime = rs.getInt("DELOVI_CENA");
                int tip = rs.getInt("TELO_TIP");
                int velicina = rs.getInt("TELO_VELICINA");

                izlaz = "\nID dela " + aID
                        + "\nID TELA: " + ime
                        + "\ncena: " + prezime
                        + "tip tela: " + tip
                        + "velicina tela: " + velicina
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList ispisiMandoline() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT *  FROM mandolina";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("PROIZVOD_ID");
                String ime = rs.getString("MANDOLINA_ID");
                int prezime = rs.getInt("PROIZOVD_CENA");

                izlaz = "\nID autora " + aID
                        + "\nime autora: " + ime
                        + "\nprezime autora: " + prezime
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList ispisiCivije() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT *  FROM civija";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("DELOVI_ID");
                String ime = rs.getString("CIVIJA_ID");
                int prezime = rs.getInt("DELOVI_CENA");
                String marka = rs.getString("CIVIJA_MARKA");

                izlaz = "\nID dela " + aID
                        + "\nid civije je: " + ime
                        + "\nCena: " + prezime
                        + "\n marka civije je:" + marka
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList ispisiKobilice() {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            String query = "SELECT *  FROM kobilica";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int aID = rs.getInt("DELOVI_ID");
                String ime = rs.getString("KOBILICA_ID");
                int prezime = rs.getInt("DELOVI_CENA");
                String marka = rs.getString("KOBILICA_MARKA");

                izlaz = "\nID dela " + aID
                        + "\nid kobilice je: " + ime
                        + "\nCena: " + prezime
                        + "\n marka kobilice je:" + marka
                        + "\n";

                lista.add(izlaz);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }



    public void updateAutora(int tf1, String tf2, String tf3, String tf4) {
        try {
            String query = "UPDATE autor SET AUTORIME = ? , AUTORPREZIME = ?, AUTOROPIS = ? WHERE AUTORID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, tf2);
            preparedStmt.setString(2, tf3);
            preparedStmt.setString(3, tf4);
            preparedStmt.setInt(4, tf1);

            preparedStmt.executeUpdate();
            System.out.println("Uspesno update autora");

        } catch (Exception e) {
            System.err.println("greska u updateAutora");
            System.err.println(e.getMessage());
        }
    }

 

    public void updateKnjiga(int tf1, String tf2, int tf3, int tf4, int tf5) {
        try {
            String query = "UPDATE knjiga SET BIBLIOTEKAID = ?, KNJIGAIME = ?, KNJIGAGODIZDANJA = ?, BRPRIMERAKA = ? WHERE ISBN = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(5, tf1);
            preparedStmt.setString(2, tf2);
            preparedStmt.setInt(3, tf3);
            preparedStmt.setInt(4, tf4);
            preparedStmt.setInt(1, tf5);

            preparedStmt.executeUpdate();
            System.out.println("Uspesno udpate knjige!");

        } catch (Exception e) {
            System.err.println("greska u updateKnjiga");
            System.err.println(e.getMessage());
        }
    }

 

    public void updateOpstina(int tf1, String tf2, int tf3) {
        try {
            String query = "UPDATE opstina SET BIBLIOTEKAID = ?, OPSTINANAZIV = ? WHERE OPSTINAID =?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, tf1);
            preparedStmt.setString(2, tf2);
            preparedStmt.setInt(3, tf3);

            preparedStmt.executeUpdate();
            System.out.println("Uspesno UPDATE opstina");

        } catch (Exception e) {
            System.err.println("greska u updateOpstina");
            System.err.println(e.getMessage());
        }
    }

 

    public void updateDomara(int tf1, int tf2) {
        try {
            String query = "UPDATE domar SET DOMARID = ? WHERE ZAPOSLENIID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, tf2);
            preparedStmt.setInt(2, tf1);

            preparedStmt.executeUpdate();
            System.out.println("Uspesno update domara");

        } catch (Exception e) {
            System.err.println("greska u updateDomar");
            System.err.println(e.getMessage());
        }
    }

 

    public void updateZaposleni(int tf1, String tf2, String tf3, int tf4) {
        try {
            String query = "UPDATE zaposleni SET BIBLIOTEKAID =?, ZAPOSLENIIME = ?, ZAPOSLENIPREZIME = ? WHERE ZAPOSLENIID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, tf1);
            preparedStmt.setString(2, tf2);
            preparedStmt.setString(3, tf3);
            preparedStmt.setInt(4, tf4);

            preparedStmt.executeUpdate();
            System.out.println("Uspesno UPDATE Zaposlenog");

        } catch (Exception e) {
            System.err.println("greska u updateZaposleni");
            System.err.println(e.getMessage());
        }
    }


    public void izbrisiAutora(int x) {

        try {
            String query = "DELETE from AUTOR where AUTORID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, x);

            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void izbrisiKnjigu(int x) {

        try {
            String query = "DELETE from knjiga WHERE ISBN = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, x);

            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void izbrisiOpstinu(int x) {

        try {
            String query = "DELETE FROM opstina WHERE OPSTINAID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, x);

            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void izbrisiZaposlenog(int x) {

        try {
            String query = "DELETE FROM zaposleni WHERE ZAPOSLENIID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, x);

            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }



}
