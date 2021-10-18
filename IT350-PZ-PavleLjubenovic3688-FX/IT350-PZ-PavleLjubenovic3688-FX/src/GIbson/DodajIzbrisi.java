package GIbson;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DodajIzbrisi {

    Baza baza = new Baza();
    Stage stagePrikaz;
    Stage noviStage;
    Stage stara;
    Stage lek;

    TextArea tekst;
    GridPane gpane = new GridPane();
    VBox vbox = new VBox();
    ToggleGroup tgroup = new ToggleGroup();
    TextArea txtArea = new TextArea();

    Button ispisi = new Button("Ispisi");
    Button dodaj = new Button("dodaj");
    Button izbrisi = new Button("izbrisi");
    Button update = new Button("update");

    RadioButton rb1 = new RadioButton("Gitare");
    RadioButton rb2 = new RadioButton("Mandoline");
    RadioButton rb3 = new RadioButton("Civije");
    RadioButton rb4 = new RadioButton("KObilice");
    RadioButton rb5 = new RadioButton("Telo");
    RadioButton rb6 = new RadioButton("Zica");
    RadioButton rb7 = new RadioButton("Prodaja");
    RadioButton rb8 = new RadioButton("Proizvod");

    public DodajIzbrisi(Stage stara) {
        this.stagePrikaz = new Stage();
        this.stara = stara;
        this.noviStage = new Stage();

        Button nazad = new Button("Nazad");
        nazad.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stagePrikaz.close();
                stara.setResizable(false);
                stara.show();
            }
        });

        rb1.setToggleGroup(tgroup);
        rb2.setToggleGroup(tgroup);
        rb3.setToggleGroup(tgroup);
        rb4.setToggleGroup(tgroup);
        rb5.setToggleGroup(tgroup);
        rb6.setToggleGroup(tgroup);
        rb7.setToggleGroup(tgroup);
        rb8.setToggleGroup(tgroup);

        vbox.getChildren().add(rb1);
        vbox.getChildren().add(rb2);
        vbox.getChildren().add(rb3);
        vbox.getChildren().add(rb4);
        vbox.getChildren().add(rb5);
        vbox.getChildren().add(rb6);
        vbox.getChildren().add(rb7);
        vbox.getChildren().add(rb8);

        vbox.setPadding(new Insets(15));
        vbox.setSpacing(20);
        vbox.setPrefWidth(250);

        ispisi.setPrefSize(140, 70);
        dodaj.setPrefSize(140, 70);
        izbrisi.setPrefSize(140, 70);
        nazad.setPrefSize(140, 70);

        vbox.getChildren().add(ispisi);
        vbox.getChildren().add(dodaj);
        vbox.getChildren().add(izbrisi);
        vbox.getChildren().add(nazad);
        vbox.getChildren().add(update);

        txtArea.setPrefSize(500, 300);
        txtArea.setId("tekstPolje");
        txtArea.setEditable(false);

        gpane.add(vbox, 0, 0);
        gpane.add(txtArea, 1, 0);
        gpane.setPadding(new Insets(20));

        update.setOnAction(e -> {

            Button nazad1 = new Button("Nazad");
            nazad1.setPrefSize(80, 40);
            GridPane gp = new GridPane();
            gp.setId("mojGrid");

            if (rb1.isSelected()) {
                //update
                Label lblID = new Label("ID autora: ");
                Label lblime = new Label("ime autora: ");
                Label lblPrezime = new Label("prezime autora: ");
                Label lblOpis = new Label("opis autora: ");

                TextField tf1 = new TextField();
                TextField tf2 = new TextField();
                TextField tf3 = new TextField();
                TextField tf4 = new TextField();
                tf1.setId("mojTF");
                tf2.setId("mojTF");
                tf3.setId("mojTF");
                tf4.setId("mojTF");

                Button ok = new Button("Ok");
                ok.setPrefSize(80, 40);

                gp.add(lblID, 0, 0);
                gp.add(lblime, 0, 1);
                gp.add(lblPrezime, 0, 2);
                gp.add(lblOpis, 0, 3);
                gp.add(tf1, 1, 0);
                gp.add(tf2, 1, 1);
                gp.add(tf3, 1, 2);
                gp.add(tf4, 1, 3);

                HBox hb = new HBox();
                Label por = new Label();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 6, 1, 2, 2);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        boolean nesto = true;

                        if (nesto) {
                            int t1 = Integer.parseInt(tf1.getText());
                            String t2 = tf2.getText();
                            String t3 = tf3.getText();
                            String t4 = tf4.getText();

                            //UPDATE AUTORA
                            baza.updateAutora(t1, t2, t3, t4);
                        }

                    }
                });
                gp.add(por, 0, 8, 2, 4);
            } else if (rb2.isSelected()) {

                Label lblISBN = new Label("ISBN: ");
                Label lblbiblID = new Label("id biblioteke: ");
                Label lblimeknjige = new Label("ime knjige: ");
                Label lblgodinaIzdavanja = new Label("godina izdavanja: ");
                Label lblbrPrimeraka = new Label("broj primeraka: ");

                lblISBN.setId("malaLabela");
                lblbiblID.setId("malaLabela");
                lblimeknjige.setId("malaLabela");
                lblgodinaIzdavanja.setId("malaLabela");
                lblbrPrimeraka.setId("malaLabela");
                TextField tfISBN = new TextField();
                TextField tfbiblD = new TextField();
                TextField tfimeknjige = new TextField();
                TextField tfgodinaIzdavanja = new TextField();
                TextField tfbrPrimeraka = new TextField();

                Button ok = new Button("OK");

                gp.add(lblISBN, 0, 0);
                gp.add(lblbiblID, 0, 1);
                gp.add(lblimeknjige, 0, 2);
                gp.add(lblgodinaIzdavanja, 0, 3);
                gp.add(lblbrPrimeraka, 0, 4);

                gp.add(tfISBN, 1, 0);
                gp.add(tfbiblD, 1, 1);
                gp.add(tfimeknjige, 1, 2);
                gp.add(tfgodinaIzdavanja, 1, 3);
                gp.add(tfbrPrimeraka, 1, 4);

                Label por = new Label();
                HBox hb = new HBox();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 0, 7, 2, 2);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        boolean nesto = true;
                        if (nesto) {
                            int t1 = Integer.parseInt(tfISBN.getText());
                            int t2 = Integer.parseInt(tfbiblD.getText());
                            String t3 = tfimeknjige.getText();
                            int t4 = Integer.parseInt(tfgodinaIzdavanja.getText());
                            int t5 = Integer.parseInt(tfbrPrimeraka.getText());

                            baza.updateKnjiga(t1, t3, t5, t4, t5);
                        }
                    }
                });
                gp.add(por, 0, 9, 2, 2);

            } else if (rb3.isSelected()) {

                Label l1 = new Label("opstina id ");
                Label l2 = new Label("bibliotekaid ");
                Label l3 = new Label("opstina naziv ");

                TextField tf1 = new TextField();
                TextField tf2 = new TextField();
                TextField tf3 = new TextField();

                Button ok = new Button("OK");
                ok.setPrefSize(80, 40);
                Label por = new Label();

                gp.add(l1, 0, 0);
                gp.add(l2, 0, 1);
                gp.add(l3, 0, 2);

                gp.add(tf1, 1, 0);
                gp.add(tf2, 1, 1);
                gp.add(tf3, 1, 2);
                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        boolean nesto = true;
                        if (nesto) {
                            int t1 = Integer.parseInt(tf1.getText());
                            int t2 = Integer.parseInt(tf2.getText());
                            String t3 = tf3.getText();
                            //baza UPDATE opstina
                            baza.updateOpstina(t2, t3, t1);
                        }
                    }
                });
                gp.add(por, 0, 9, 2, 2);

                HBox hb = new HBox();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 0, 8, 2, 2);
            } else if (rb4.isSelected()) {
                Label l1 = new Label("zaposleni ID");
                Label l2 = new Label("biblioteka ID");
                Label l3 = new Label("zaposleni ime");
                Label l4 = new Label("zaposleni prezime");

                TextField tf1 = new TextField();
                TextField tf2 = new TextField();
                TextField tf3 = new TextField();
                TextField tf4 = new TextField();
                Button ok = new Button("OK");
                ok.setPrefSize(80, 40);
                Label por = new Label();

                gp.add(l1, 0, 0);
                gp.add(l2, 0, 1);
                gp.add(l3, 0, 2);
                gp.add(l4, 0, 3);

                gp.add(tf1, 1, 0);
                gp.add(tf2, 1, 1);
                gp.add(tf3, 1, 2);
                gp.add(tf4, 1, 3);
                HBox hb = new HBox();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 0, 8, 2, 2);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        boolean nesto = true;
                        if (nesto) {
                            int t1 = Integer.parseInt(tf1.getText());
                            int t2 = Integer.parseInt(tf2.getText());
                            String t3 = tf3.getText();
                            String t4 = tf4.getText();
                            //UPDATE ZAPOSLENI
                            baza.updateZaposleni(t2, t3, t4, t1);
                        }
                    }
                });

            } else if (rb5.isSelected()) {

                Label l1 = new Label("Domar id ");
                Label l2 = new Label("zaposleni ID ");

                TextField tf1 = new TextField();
                TextField tf2 = new TextField();

                Button ok = new Button("OK");
                ok.setPrefSize(80, 40);
                Label por = new Label();

                gp.add(l1, 0, 0);
                gp.add(l2, 0, 1);

                gp.add(tf1, 1, 0);
                gp.add(tf2, 1, 1);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        boolean nesto = true;
                        if (nesto) {
                            int t1 = Integer.parseInt(tf1.getText());
                            int t2 = Integer.parseInt(tf2.getText());

                            baza.updateDomara(t2, t1);
                        }
                    }
                });
                gp.add(por, 0, 9, 2, 2);

                HBox hb = new HBox();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 0, 8, 2, 2);
            }

            nazad1.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    noviStage.close();
                }
            });

            Scene scena = new Scene(gp, 600, 500);
            scena.getStylesheets().add(getClass().getResource("css.css").toString());
            noviStage.setScene(scena);
            noviStage.setResizable(false);
            noviStage.show();
        });

        dodaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Button nazad1 = new Button("Nazad");
                nazad1.setPrefSize(80, 40);
                GridPane gp = new GridPane();
                gp.setId("mojGrid");

                if (rb1.isSelected()) {

                    Label lblID = new Label("ID proizvoda: ");
                    Label lblime = new Label("ID GITARE: ");
                    Label lblPrezime = new Label("CENA GITARE: ");

                    TextField tf1 = new TextField();
                    TextField tf2 = new TextField();
                    TextField tf3 = new TextField();
                    tf1.setId("mojTF");
                    tf2.setId("mojTF");
                    tf3.setId("mojTF");

                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);

                    gp.add(lblID, 0, 0);
                    gp.add(lblime, 0, 1);
                    gp.add(lblPrezime, 0, 2);
                    gp.add(tf1, 1, 0);
                    gp.add(tf2, 1, 1);
                    gp.add(tf3, 1, 2);

                    HBox hb = new HBox();
                    Label por = new Label();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 6, 1, 2, 2);

                    ok.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            boolean nesto = true;

                            if (nesto) {
                                int t1 = Integer.parseInt(tf1.getText());
                                int t2 = Integer.parseInt(tf2.getText());
                                int t3 = Integer.parseInt(tf3.getText());

                                baza.dodajGitaru(t1, t2, t3);
                            }

                        }
                    });
                    gp.add(por, 0, 8, 2, 4);
                } else if (rb2.isSelected()) {

                    Label lblISBN = new Label("ID proizvoda ");
                    Label lblbiblID = new Label("id mandoline: ");
                    Label lblimeknjige = new Label("cena mandoline: ");

                    lblISBN.setId("malaLabela");
                    lblbiblID.setId("malaLabela");
                    lblimeknjige.setId("malaLabela");

                    TextField tfISBN = new TextField();
                    TextField tfbiblD = new TextField();
                    TextField tfimeknjige = new TextField();
           
                    Button ok = new Button("OK");

                    gp.add(lblISBN, 0, 0);
                    gp.add(lblbiblID, 0, 1);
                    gp.add(lblimeknjige, 0, 2);
               

                    gp.add(tfISBN, 1, 0);
                    gp.add(tfbiblD, 1, 1);
                    gp.add(tfimeknjige, 1, 2);
                

                    Label por = new Label();
                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 7, 2, 2);

                    ok.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            boolean nesto = true;
                            if (nesto) {
                                int t1 = Integer.parseInt(tfISBN.getText());
                                int t2 = Integer.parseInt(tfbiblD.getText());
                                int t3 = Integer.parseInt(tfimeknjige.getText()); 
                             

                                baza.dodajMandolinu(t1, t2, t3);
                            }
                        }
                    });
                    gp.add(por, 0, 9, 2, 2);

                } else if (rb3.isSelected()) {

                    Label l1 = new Label("delovi id ");
                    Label l2 = new Label("civija ID");
                    Label l4 = new Label("cena ");
                    Label l5 = new Label("tip civije ");
                    Label l6 = new Label("marka civije ");
                    Label l7 = new Label("velicina civije ");

                    TextField tf1 = new TextField();
                    TextField tf2 = new TextField();
                    TextField tf4 = new TextField();
                    TextField tf5 = new TextField();
                    TextField tf6 = new TextField();
                    TextField tf7 = new TextField();

                    Button ok = new Button("OK");
                    ok.setPrefSize(80, 40);
                    Label por = new Label();

                    gp.add(l1, 0, 0);
                    gp.add(l2, 0, 1);
                    gp.add(l4, 0, 2);
                    gp.add(l5, 0, 3);
                    gp.add(l6, 0, 4);
                    gp.add(l7, 0, 5);
                   

                    gp.add(tf1, 1, 0);
                    gp.add(tf2, 1, 1);
                    gp.add(tf4, 1, 2);
                    gp.add(tf5, 1, 3);
                    gp.add(tf6, 1, 4);
                    gp.add(tf7, 1, 5);
                    ok.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            boolean nesto = true;
                            if (nesto) {
                                int t1 = Integer.parseInt(tf1.getText());
                                int t2 = Integer.parseInt(tf2.getText());
                                int t4 = Integer.parseInt(tf4.getText());
                                int t5 = Integer.parseInt(tf5.getText());
                                String t6 = tf5.getText();
                                int t7 = Integer.parseInt(tf7.getText());
                                baza.dodajCivije(t1, t2, t4, t5, t7, t6, t7);
                            }
                        }
                    });
                    gp.add(por, 0, 9, 2, 2);

                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 8, 2, 2);
                } else if (rb4.isSelected()) {

                    Label l1 = new Label("delovi ID");
                    Label l2 = new Label("kobilicaID");
                    Label l3 = new Label("cena");
                    Label l4 = new Label("marka kobilice");

                    TextField tf1 = new TextField();
                    TextField tf2 = new TextField();
                    TextField tf3 = new TextField();
                    TextField tf4 = new TextField();
                    Button ok = new Button("OK");
                    ok.setPrefSize(80, 40);
                    Label por = new Label();

                    gp.add(l1, 0, 0);
                    gp.add(l2, 0, 1);
                    gp.add(l3, 0, 2);
                    gp.add(l4, 0, 3);

                    gp.add(tf1, 1, 0);
                    gp.add(tf2, 1, 1);
                    gp.add(tf3, 1, 2);
                    gp.add(tf4, 1, 3);
                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 8, 2, 2);

                    ok.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            boolean nesto = true;
                            if (nesto) {
                                int t1 = Integer.parseInt(tf1.getText());
                                int t2 = Integer.parseInt(tf2.getText());
                                int t3 = Integer.parseInt(tf3.getText());
                                String t4 = tf4.getText();
                                baza.dodajKobilice(t1, t2, t3, t4);
                            }
                        }
                    });

                } else if (rb5.isSelected()) {

                    Label l1 = new Label("delovi id ");
                    Label l2 = new Label("telo ID ");
                    Label l3 = new Label("cena ");
                    Label l4 = new Label("tip tela ");
                    Label l5 = new Label("velicina tela ");

                    TextField tf1 = new TextField();
                    TextField tf2 = new TextField();
                    TextField tf3 = new TextField();
                    TextField tf4 = new TextField();
                    TextField tf5 = new TextField();

                    Button ok = new Button("OK");
                    ok.setPrefSize(80, 40);
                    Label por = new Label();

                    gp.add(l1, 0, 0);
                    gp.add(l2, 0, 1);
                    gp.add(l3, 0, 2);
                    gp.add(l4, 0, 3);
                    gp.add(l5, 0, 4);

                    gp.add(tf1, 1, 0);
                    gp.add(tf2, 1, 1);
                    gp.add(tf3, 1, 2);
                    gp.add(tf4, 1, 3);
                    gp.add(tf5, 1, 4);

                    ok.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            boolean nesto = true;
                            if (nesto) {
                                int t1 = Integer.parseInt(tf1.getText());
                                int t2 = Integer.parseInt(tf2.getText());
                                int t3 = Integer.parseInt(tf2.getText());
                                int t4 = Integer.parseInt(tf2.getText());
                                int t5 = Integer.parseInt(tf2.getText());

                                baza.dodajTelo(t1, t2, t4, t5, t5);
                            }
                        }
                    });
                    gp.add(por, 0, 9, 2, 2);

                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 8, 2, 2);
                } else if (rb8.isSelected()) {

                    Label l1 = new Label("Proizvod ID");
                    Label l2 = new Label("Proizvod cena ");

                    TextField tf1 = new TextField();
                    TextField tf2 = new TextField();

                    Button ok = new Button("OK");
                    ok.setPrefSize(80, 40);
                    Label por = new Label();

                    gp.add(l1, 0, 0);
                    gp.add(l2, 0, 1);

                    gp.add(tf1, 1, 0);
                    gp.add(tf2, 1, 1);

                    ok.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            boolean nesto = true;
                            if (nesto) {
                                int t1 = Integer.parseInt(tf1.getText());
                                int t2 = Integer.parseInt(tf2.getText());

                                baza.dodajProizvod(t1, t2);

                            }
                        }
                    });
                    gp.add(por, 0, 9, 2, 2);

                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 8, 2, 2);
                }

                nazad1.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        noviStage.close();
                    }
                });

                Scene scena = new Scene(gp, 600, 500);
                scena.getStylesheets().add(getClass().getResource("css.css").toString());
                noviStage.setScene(scena);
                noviStage.setResizable(false);
                noviStage.show();
            }
        });

        ispisi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (rb1.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiGitare();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();

                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else if (rb2.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiMandoline();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();
//
//                            Baza baza = new Baza();
//                            baza.izbrisiSelektovanTekstPacijent(txtArea);

                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else if (rb3.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiCivije();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();

//                            Baza baza = new Baza();
//                            baza.izbrisiSelektovanTekstFarmaceut(txtArea);
                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else if (rb4.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiKobilice();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();

//                            Baza baza = new Baza();
//                            baza.izbrisiSelektovanTekstKomercijalista(txtArea);
                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else if (rb5.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiTelo();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();

//                            Baza baza = new Baza();
//                            baza.izbrisiSelektovanTekstKomercijalista(txtArea);
                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else if (rb6.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiZice();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();

//                            Baza baza = new Baza();
//                            baza.izbrisiSelektovanTekstKomercijalista(txtArea);
                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else if (rb7.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiProdaje();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();

//                            Baza baza = new Baza();
//                            baza.izbrisiSelektovanTekstKomercijalista(txtArea);
                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else if (rb8.isSelected()) {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiProizvode();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String selected = txtArea.getSelectedText();

//                            Baza baza = new Baza();
//                            baza.izbrisiSelektovanTekstKomercijalista(txtArea);
                            System.out.println(selected);
                            if (selected != "") {
                                txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(), ""));
                            }
                        }
                    });
                } else {
                    txtArea.setText(null);
                }
            }
        });

        izbrisi.setOnAction(e -> {

            Button nazad1 = new Button("Nazad");
            nazad1.setPrefSize(80, 40);
            nazad1.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
//                    stagePrikaz.close();
//                    stara.setResizable(false);
//                    stara.show();
                    noviStage.close();
                }
            });
            GridPane gp = new GridPane();
            gp.setId("mojGrid");

            if (rb1.isSelected()) {
                Baza baza = new Baza();
                Label lblID = new Label("ID autora: ");

                TextField tf1 = new TextField();

                Button ok = new Button("Ok");
                ok.setPrefSize(80, 40);

                gp.add(lblID, 0, 0);
                gp.add(tf1, 1, 0);

                HBox hb = new HBox();
                Label por = new Label();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 6, 1, 2, 2);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        int t1 = Integer.parseInt(tf1.getText());

                        baza.izbrisiAutora(t1);
                    }
                });
            } else if (rb2.isSelected()) {
                Baza baza = new Baza();
                Label lblID = new Label("ID knjige: ");

                TextField tf1 = new TextField();

                Button ok = new Button("Ok");
                ok.setPrefSize(80, 40);

                gp.add(lblID, 0, 0);
                gp.add(tf1, 1, 0);

                HBox hb = new HBox();
                Label por = new Label();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 6, 1, 2, 2);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        int t1 = Integer.parseInt(tf1.getText());

                        baza.izbrisiKnjigu(t1);
                    }
                });
            } else if (rb3.isSelected()) {
                Baza baza = new Baza();
                Label lblID = new Label("ID opstine koju brisete: ");

                TextField tf1 = new TextField();

                Button ok = new Button("Ok");
                ok.setPrefSize(80, 40);

                gp.add(lblID, 0, 0);
                gp.add(tf1, 1, 0);

                HBox hb = new HBox();
                Label por = new Label();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 6, 1, 2, 2);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        int t1 = Integer.parseInt(tf1.getText());

                        baza.izbrisiOpstinu(t1);
                    }
                });
            } else if (rb4.isSelected()) {
                Baza baza = new Baza();
                Label lblID = new Label("ID zaposlenog koga brisete: ");

                TextField tf1 = new TextField();

                Button ok = new Button("Ok");
                ok.setPrefSize(80, 40);

                gp.add(lblID, 0, 0);
                gp.add(tf1, 1, 0);

                HBox hb = new HBox();
                Label por = new Label();
                hb.setId("mojaHB");
                hb.getChildren().add(ok);
                hb.getChildren().add(nazad1);
                gp.add(hb, 6, 1, 2, 2);

                ok.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        int t1 = Integer.parseInt(tf1.getText());

                        baza.izbrisiZaposlenog(t1);
                    }
                });
            }

            Scene scena = new Scene(gp, 600, 500);
            scena.getStylesheets().add(getClass().getResource("css.css").toString());
            noviStage.setScene(scena);
            noviStage.setResizable(false);
            noviStage.show();
        });

        Scene scene = new Scene(gpane, 650, 700);
        scene.getStylesheets().add(getClass().getResource("css.css").toString());
        stagePrikaz.setScene(scene);
        stagePrikaz.setTitle("IT350 - PZ ");
        stagePrikaz.setResizable(false);
        stagePrikaz.show();
    }

    public void setTekst(String tekst) {
        this.tekst.setText(tekst);
        this.tekst.setStyle("-fx-background-color:  white;"
                + "-fx-text-fill: black");
    }
}
