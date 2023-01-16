/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import bean.*;
import dao.Dao;
import static dao.Dao.findAllBus;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author IDA
 */
public class FXMLDocumentController implements Initializable{
    
    /*variables loader/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
    @FXML
    private AnchorPane splashscreen;

    @FXML
    public static Label chargementMessage;

    
    
    
    /*variables login///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
     @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private Label usernameError;

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginVider;

    @FXML
    private Button loginSeConnecter;

    @FXML
    private CheckBox ch_seSouvenir;

    @FXML
    private Hyperlink hp_MdsOublie;

    @FXML
    private RadioButton rb_administrateur;

    @FXML
    private ToggleGroup categorie;

    @FXML
    private RadioButton rb_caissier;

    @FXML
    private Label passwordError;

    @FXML
    private RadioButton rb_gestionnaire;
    
    
    
    
    /*variables mdpOublie///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    private VBox mdpOublieVbox;

    @FXML
    private Label erreurInformationsMdpOublie;

    @FXML
    private TextField UsernameMdpOublie;

    @FXML
    private PasswordField EmailRecuperationMdpOublie;

    @FXML
    private Button Mdpoublie_vider;

    @FXML
    private Button MdpOublieEnvoye;
    
    
    
    
    
    
    /*variables menuAdministrateur//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    private BorderPane generalborderpane;
     
      @FXML
    private VBox menuVerticalAministrateurVbox;

    @FXML
    private HBox tblbord_menuvertucalAdministraateur;

    @FXML
    private HBox bus_menuverticalAdministrateur;

    @FXML
    private HBox voyage_menuverticalAdministrateur;

    @FXML
    private HBox client_menuverticalAdministrateur;

    @FXML
    private HBox reservation_menuverticalAdministrateur;

    @FXML
    private HBox ticket_menuverticalAdministrateur;

    @FXML
    private HBox trajet_menuverticalAdministrateur;

    @FXML
    private HBox chauffeur_menuverticalAdministrateur;

    @FXML
    private HBox utilisateurs_menuverticalAdmiistrateur;

    @FXML
    private HBox deconnexion_menuverticalAdmiistrateur1;

    @FXML
    private ImageView lancer_recherche;

    @FXML
    private TextField texte_recherche;

    @FXML
    private ImageView moncompte;

    @FXML
    private ImageView petiteListeInformationDeMonCompte;
    
    
    
    
    /*variables menuGestionnaire//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
   @FXML
    private BorderPane generalborderpaneGestionnaire;

    @FXML
    private HBox tblbord_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelTbd_menuverticalGestionnaire;

    @FXML
    private HBox bus_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelBus_menuverticalGestionnaire;

    @FXML
    private HBox voyage_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelVoyage_menuverticalGestionnaire;

    @FXML
    private HBox client_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelClient_menuverticalGestionnaire;

    @FXML
    private HBox reservation_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelReservation_menuverticalGestionnaire;

    @FXML
    private HBox ticket_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelTicket_menuverticalGestionnaire;

    @FXML
    private HBox trajet_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelTrajet_menuverticalGestionnaire;

    @FXML
    private HBox chauffeur_menuverticalGestionnaire;

    @FXML
    private Label indiqueLaPageActuelChauffeur_menuverticalGestionnaire;

     @FXML
    private HBox deconnexion_menuverticalGestionnaire;


    @FXML
    private ImageView menuGestionnairelancer_recherche;

    @FXML
    private TextField menuGestionnairetexte_recherche;

    @FXML
    private ImageView moncompteGestionnaire;

    @FXML
    private ImageView petiteListeInformationDeMonCompteGestionnaire;
    
    
    
    
    /*variables menuCaissier//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
      @FXML
    private BorderPane generalborderpaneCaissier;

    @FXML
    private HBox tblbord_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelTbd_menuverticalCaissier;

    @FXML
    private HBox bus_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelBus_menuverticalCaissier;

    @FXML
    private HBox voyage_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelVoyage_menuverticalCaissier;

    @FXML
    private HBox client_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelClient_menuverticalCaissier;

    @FXML
    private HBox reservation_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelReservation_menuverticalCaissier;

    @FXML
    private HBox ticket_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelTicket_menuverticalCaissier;

    @FXML
    private HBox trajet_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelTrajet_menuverticalCaissier;

    @FXML
    private HBox chauffeur_menuverticalCaissier;

    @FXML
    private Label indiqueLaPageActuelChauffeur_menuverticalCaissier;

    @FXML
    private HBox deconnexion_menuverticalCaissier;

    @FXML
    private ImageView menuCaissierlancer_recherche;

    @FXML
    private TextField menuCaissiertexte_recherche;

    @FXML
    private ImageView moncompteCaissier;

    @FXML
    private ImageView petiteListeInformationDeMonCompteCaissier;
    
    
    
    /* variables dashboardAdministrateur/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
      @FXML
    private VBox dashboardAdministrateur;

    @FXML
    private Label messageAccueilAdministrateurTableauDeBord;

    @FXML
    private VBox bus_image_tableaudebordAdministrateur;

    @FXML
    private Label tbd_administrateur_nbreBusTotal;

    @FXML
    private VBox voyage_image_tableaudebordAdministrateur;

    @FXML
    private Label tbd_administrateur_nbreVoyageTotal;

    @FXML
    private VBox client_image_tableaudebordAdministrateur;

    @FXML
    private Label tbd_administrateur_nbreClientTotal;

    @FXML
    private VBox reservation_image_tableaudebordAdministrateur;

    @FXML
    private Label tbd_administrateur__nbreReservationTotal;

    @FXML
    private VBox ticket_image_tableaudebordAdministrateur;

    @FXML
    private Label tbd_administrateur_nbreTicketTotal;

    @FXML
    private VBox trajet_image_tableaudebordAdministrateur;

    @FXML
    private VBox chauffeur_image_tableaudebordAdministrateur;

    @FXML
    private Label tbd_administrateur_nbreChauffeurTotal;

    @FXML
    private VBox utilisateurs_image_tableaudebordAdministrateur;

    @FXML
    private Label tbd_administrateur_nbreUtilisateurTotal;

    @FXML
    private Label date_du_jourTableauDeBordAdministrateur;

    @FXML
    private TextField performanceDuJourNouveauClientsTableauDeBordAdministrateur;

    @FXML
    private TextField performanceDuJourReservationsEffectueTableauDeBordAdministrateur;

    @FXML
    private TextField performanceDuJourTicketVenduTableauDeBordAdministrateur;

    @FXML
    private TextField performanceDuJourRecetteTableauDeBordAdministrateur;

    @FXML
    private TableView<?> oyageEnCours_table_TableauDeBordAdministrateur;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordAdministrateur_id;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordAdministrateur_depart;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordAdministrateur_arrive;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordAdministrateur_trajet;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordAdministrateur_bus;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordAdministrateur_chauffeur;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordAdministrateur_nbrePassagers;

    @FXML
    private TableView<?> reservationEffectue_table_TableauDeBordAdministrateur;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordAdministrateur_id;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordAdministrateur_voyage;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordAdministrateur_nbreplace;

    @FXML
    private TableView<?> utilisateurConnecte_table_TableauDeBordAdministrateur;

    @FXML
    private TableColumn<?, ?> utilisateurConnecte_table_TableauDeBordAdministrateur_id;

    @FXML
    private TableColumn<?, ?> utilisateurConnecte_table_TableauDeBordAdministrateur_nom;

    @FXML
    private TableColumn<?, ?> utilisateurConnecte_table_TableauDeBordAdministrateur_categorie;

    @FXML
    private TableColumn<?, ?> utilisateurConnecte_table_TableauDeBordAdministrateur_derniereActivite;
    
    
    
    
    
    /*variables dashboardGestionnaire////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
      @FXML
    private VBox dashbordGestionnaireVbox;

    @FXML
    private Label messageAccueilGestionnaireTableauDeBord;

    @FXML
    private VBox bus_image_tableaudebordGestionaire;

    @FXML
    private Label tbd_gestionnaire_nbreBusTotal;

    @FXML
    private VBox voyage_image_tableaudebordGestionnaire;

    @FXML
    private Label tbd_gestionnaire_nbreVoyageTotal;

    @FXML
    private VBox client_image_tableaudebordGestionnaire;

    @FXML
    private Label tbd_gestionnaire_nbreClientTotal;

    @FXML
    private VBox reservation_image_tableaudebordGestionnaire;

    @FXML
    private Label tbd_gestionnaire_nbreReservationTotal;

    @FXML
    private VBox ticket_image_tableaudebordGestionnaire;

    @FXML
    private Label tbd_gestionnaire_nbreTicketTotal;

    @FXML
    private VBox trajet_image_tableaudebordGestionnaire;

    @FXML
    private VBox chauffeur_image_tableaudebordGestionnaire;

    @FXML
    private Label tbd_gestionnaire_nbreChauffeurTotal;

    @FXML
    private Label date_du_jourTableauDeBordGestionnaire;

    @FXML
    private TextField performanceDuJourNouveauClientsTableauDeBordGestionnaire;

    @FXML
    private TextField performanceDuJourReservationsEffectueTableauDeBordGestionnaire;

    @FXML
    private TextField performanceDuJourTicketVenduTableauDeBordGestionnaire;

    @FXML
    private TextField performanceDuJourRecetteTableauDeBordGestionnaire;

    @FXML
    private TableView<?> oyageEnCours_table_TableauDeBordGestionnaire;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordGestionnaire_id;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordGestionnaire_depart;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordGestionnaire_arrive;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordGestionnaire_trajet;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordGestionnaire_bus;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordGestionnaire_chauffeur;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordGestionnaire_nbrePassagers;

    @FXML
    private TableView<?> reservationEffectue_table_TableauDeBordGestionnaire;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordGestionnaire_id;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordGestionnaire_client;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordGestionnaire_voyage;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordGestionnaire_nbrePlace;

    @FXML
    private TableView<?> ticketVendus_table_TableauDeBordGestionnaire;

    @FXML
    private TableColumn<?, ?> ticketVendus_table_TableauDeBordGestionnaire_id;

    @FXML
    private TableColumn<?, ?> ticketVendus_table_TableauDeBordGestionnaire_numero;

    @FXML
    private TableColumn<?, ?> ticketVendus_table_TableauDeBordCaissieticketVendus_table_TableauDeBordGestionnaire_montant;

    
    
    
    /*variables dashboardCaissier////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    private VBox dashbordCaissierVbox;

    @FXML
    private Label messageAccueilCaissierTableauDeBord;

    @FXML
    private VBox bus_image_tableaudebordCaissier;

    @FXML
    private Label tbd_caissier_nbreBusTotal;

    @FXML
    private VBox voyage_image_tableaudebordCaissier;

    @FXML
    private Label tbd_caissier_nbreVoyageTotal;

    @FXML
    private VBox client_image_tableaudebordCaissier;

    @FXML
    private Label tbd_caissier_nbreClientTotal;

    @FXML
    private VBox reservation_image_tableaudebordCaissier;

    @FXML
    private Label tbd_caissier_nbreReservationTotal;

    @FXML
    private VBox ticket_image_tableaudebordCaissier;

    @FXML
    private Label tbd_caissier_nbreTicketTotal;

    @FXML
    private VBox trajet_image_tableaudebordCaissier;

    @FXML
    private VBox chauffeur_image_tableaudebordCaissier;

    @FXML
    private Label tbd_caissier_nbreChauffeurTotal;

    @FXML
    private Label date_du_jourTableauDeBordCaissier;

    @FXML
    private TextField performanceDuJourNouveauClientsTableauDeBordCaissier;

    @FXML
    private TextField performanceDuJourReservationsEffectueTableauDeBordCaissier;

    @FXML
    private TextField performanceDuJourTicketVenduTableauDeBordCaissier;

    @FXML
    private TextField performanceDuJourRecetteTableauDeBordCaissier;

    @FXML
    private TableView<?> oyageEnCours_table_TableauDeBordCaissier;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordCaissier_id;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordCaissier_depart;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordCaissier_arrive;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordCaissier_trajet;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordCaissier_bus;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordCaissier_chauffeur;

    @FXML
    private TableColumn<?, ?> oyageEnCours_table_TableauDeBordCaissier_nbrePassagers;

    @FXML
    private TableView<?> reservationEffectue_table_TableauDeBordCaissier;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordCaissier_id;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordCaissier_client;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordCaissier_voyage;

    @FXML
    private TableColumn<?, ?> reservationEffectue_table_TableauDeBordCaissier_nbrePlace;

    @FXML
    private TableView<?> ticketVendus_table_TableauDeBordCaissier;

    @FXML
    private TableColumn<?, ?> ticketVendus_table_TableauDeBordCaissier_id;

    @FXML
    private TableColumn<?, ?> ticketVendus_table_TableauDeBordCaissier_numero;

    @FXML
    private TableColumn<?, ?> ticketVendus_table_TableauDeBordCaissieticketVendus_table_TableauDeBordCaissier_montant;

    
    /*variables busAdministrateur busGestionnaire///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    @FXML
    private VBox bus_vbox;

    @FXML
    private Label erreur_immatriculation;

    @FXML
    private TextField bus_Immatriculation;

    @FXML
    private TextField id;

    @FXML
    private Label erreur_capacitebus;

    @FXML
    private TextField bus_capacite;

    @FXML
    private Label erreur_statusbus;

    @FXML
    private TextField statusBus;

    @FXML
    private Button btn_effacerbus;

    @FXML
    private Button btn_supprimerbus;

    @FXML
    private Button btn_modifierbus;

    @FXML
    private Button btn_ajouterbus;

    @FXML
    private Button btn_actualiserbus;

    @FXML
    private TableView<Bus> bus_table;

    @FXML
    private TableColumn<Bus, Integer> bus_table_id;

    @FXML
    private TableColumn<Bus, String> bus_table_immatriculation;

    @FXML
    private TableColumn<Bus, Integer> bus_table_capacité;

    @FXML
    private TableColumn<Integer, String> bus_table_status;

    @FXML
    private VBox busrecherche_vbox;

    @FXML
    private ChoiceBox<?> busrecherche_type;

    @FXML
    private ImageView buslancer_recherche;

    @FXML
    private TextField bustexte_recherche;
    
    
    
    
    
    /*variables busCaissier/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    @FXML
    private TableView<?> bus_tableCaissier;

    @FXML
    private TableColumn<?, ?> bus_tableCaissier_id;

    @FXML
    private TableColumn<?, ?> bus_tableCaissier_immatriculation;

    @FXML
    private TableColumn<?, ?> bus_tableCaissier_capacité;

    @FXML
    private TableColumn<?, ?> bus_tableCaissier_status;

    @FXML
    private TableColumn<?, ?> bus_tableCaissier_type;

    @FXML
    private VBox busrecherche_vboxCaissier;

    @FXML
    private ChoiceBox<?> busrecherche_typeCaissier;

    @FXML
    private ImageView buslancer_rechercheCaissier;

    @FXML
    private TextField bustexte_rechercheCaissier;
    
    
    
    
    
    
    /*variables voyage//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
      @FXML
    private Label erreur_dateVoyageVoyage;

    @FXML
    private Label erreur_heureDepartVoyage;

    @FXML
    private TextField heureDepart;

    @FXML
    private DatePicker dateVoyage;

    @FXML
    private Label erreur_busVoyage;

    @FXML
    private Label erreur_chauffeurVoyage;

    @FXML
    private Label erreur_trajetVoyage;

    @FXML
    private Label erreur_limitereservationVoyage;

    @FXML
    private Label erreur_nbreSiegeVoyage;

    @FXML
    private DatePicker limitReservation;

    @FXML
    private TextField siegeDispo;

    @FXML
    private ChoiceBox<?> bus;

    @FXML
    private ChoiceBox<?> chauffeur;

    @FXML
    private ChoiceBox<?> trajet;

    @FXML
    private Button btn_effacerVoyage;

    @FXML
    private Button btn_supprimerVoyage;

    @FXML
    private Button btn_modifierVoyage;

    @FXML
    private Button btn_ajouterVoyage;

    @FXML
    private Button btn_actualiserVoyage;

    @FXML
    private Button btn_creerReservationVoyage;

    @FXML
    private TableView<?> voyage_table;

    @FXML
    private TableColumn<?, ?> voyage_table_id;

    @FXML
    private TableColumn<?, ?> voyage_table_date;

    @FXML
    private TableColumn<?, ?> voyage_table_heureDep;

    @FXML
    private TableColumn<?, ?> voyage_table_heureArriv;

    @FXML
    private TableColumn<?, ?> voyage_table_status;

    @FXML
    private TableColumn<?, ?> voyage_table_limitReservation;

    @FXML
    private TableColumn<?, ?> voyage_table_nbreSiege;

    @FXML
    private TableColumn<?, ?> voyage_table_bus;

    @FXML
    private TableColumn<?, ?> voyage_table_chauffeur;

    @FXML
    private TableColumn<?, ?> voyage_table_trajet;

    @FXML
    private VBox voyagerecherche_vbox;

    @FXML
    private ChoiceBox<?> voyagerecherche_type;

    @FXML
    private ImageView voyagelancer_recherche;

    @FXML
    private TextField voyagetexte_recherche;
    
    
    
    
    /*variables voyageCaissier//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    private TableView<?> voyage_tableCaissier;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_id;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_date;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_heureDep;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_heureArriv;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_status;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_limitReservation;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_nbreSiege;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_bus;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_chauffeur;

    @FXML
    private TableColumn<?, ?> voyage_tableCaissier_trajet;

    @FXML
    private Button btn_creerReservationVoyageCaissier;

    @FXML
    private VBox voyagerecherche_vboxCaissier;

    @FXML
    private ChoiceBox<?> voyagerecherche_typeCaissier;

    @FXML
    private ImageView voyagelancer_rechercheCaissier;

    @FXML
    private TextField voyagetexte_rechercheCaissier;

    
    
    
    /*variables clientAdministrateur clientGestionnaire  clientCaissier///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
    @FXML
    private Label erreur_nomclient;

    @FXML
    private Label erreur_prenomclient;

    @FXML
    private TextField client_nom;

    @FXML
    private TextField client_prenom;

    @FXML
    private Label erreur_adresseclient;

    @FXML
    private Label erreur_contactclient;

    @FXML
    private Label erreur_emailclient;

    @FXML
    private TextArea client_adresse;

    @FXML
    private TextField client_contact;

    @FXML
    private TextField client_email;

    @FXML
    private TextField idclient;

    @FXML
    private Button btn_effacerClient;

    @FXML
    private Button btn_supprimerClient;

    @FXML
    private Button btn_modifierClient;

    @FXML
    private Button btn_ajouterClient;

    @FXML
    private Button btn_actualiserClient;

    @FXML
    private TableView<Client> client_table;

    @FXML
    private TableColumn<Client, Integer> client_table_id;

    @FXML
    private TableColumn<Client, String> client_table_nom;

    @FXML
    private TableColumn<Client, String> client_table_prenom;

    @FXML
    private TableColumn<Client, String> client_table_adresse;

    @FXML
    private TableColumn<Client, String> client_table_contact;

    @FXML
    private TableColumn<Client, String> client_table_email;

    @FXML
    private VBox clientrecherche_vbox;

    @FXML
    private ChoiceBox<?> clientrecherche_type;

    @FXML
    private ImageView clientlancer_recherche;

    @FXML
    private TextField clienttexte_recherche;
    
    
    
    
     /*variables reservationAdministrateur reservationGestionnaire reservationCaissier //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
    @FXML
    private Label erreur_nbrePlaceReservation;

    @FXML
    private Label erreur_clientReservation;

    @FXML
    private ChoiceBox<?> clientReservation;

    @FXML
    private TextField nbrePlaceReservation;

    @FXML
    private Button btn_effacerReservation;

    @FXML
    private Button btn_supprimerReservation;

    @FXML
    private Button btn_ajouterReservation;

    @FXML
    private Button btn_actualiserReservation;

    @FXML
    private Button btn_genererTicketReservation;

    @FXML
    private TableView<?> reservation_table;

    @FXML
    private TableColumn<?, ?> reservation_table_id;

    @FXML
    private TableColumn<?, ?> reservation_table_date;

    @FXML
    private TableColumn<?, ?> reservation_table_nbplace;

    @FXML
    private TableColumn<?, ?> reservation_table_montPaye;

    @FXML
    private TableColumn<?, ?> reservation_table_limAnnul;

    @FXML
    private TableColumn<?, ?> reservation_table_statReser;

    @FXML
    private TableColumn<?, ?> reservation_table_statusPay;

    @FXML
    private TableColumn<?, ?> reservation_table_client;

    @FXML
    private TableColumn<?, ?> reservation_table_voyage;

    @FXML
    private VBox reservationrecherche_vbox;

    @FXML
    private ChoiceBox<?> reservationrecherche_type;

    @FXML
    private ImageView reservationlancer_recherche;

    @FXML
    private TextField reservationtexte_recherche;
    
    
    
    
    /*variables ticketAdministrateur ticketGestionnaire ticketCaissier /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
      @FXML
    private VBox ticketVbox;

    @FXML
    private Pane ticketPanel;

    @FXML
    private TextField numTicket;

    @FXML
    private TextField dateEmissionticket;

    @FXML
    private TextField numReservationTicket;

    @FXML
    private TextField immatriculationbusTicket;

    @FXML
    private TextField villeDepartTicket;

    @FXML
    private TextField villeArriveeTicket;

    @FXML
    private TextField dateVoyageTicket;

    @FXML
    private TextField heureDepartTicket;

    @FXML
    private TextField validiteTicket;

    @FXML
    private TextField heureArriveeTicket;

    @FXML
    private Button btn_supprimerTicket;

    @FXML
    private Button btn_actualiserTicket;

    @FXML
    private Button btn_ImprimerTicket;

    @FXML
    private TableView<?> ticket_table;

    @FXML
    private TableColumn<?, ?> ticket_table_id;

    @FXML
    private TableColumn<?, ?> ticket_table_numero;

    @FXML
    private TableColumn<?, ?> ticket_table_numSiege;

    @FXML
    private TableColumn<?, ?> ticket_table_montant;

    @FXML
    private TableColumn<?, ?> ticket_table_dateEmission;

    @FXML
    private TableColumn<?, ?> ticket_table_validite;

    @FXML
    private TableColumn<?, ?> ticket_table_reservation;

    @FXML
    private VBox ticketrecherche_vbox;

    @FXML
    private ChoiceBox<?> ticketrecherche_type;

    @FXML
    private ImageView ticketlancer_recherche;

    @FXML
    private TextField tickettexte_recherche;
    
    
    
    
/* variables trajetAdministrateur trajetGestionnaire//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
      @FXML
    private Label erreur_villeDepartTrajet;

    @FXML
    private Label erreur_villeArriveeTrajet;

    @FXML
    private Label erreur_tarifTrajet;

    @FXML
    private Label erreur_dureeTrajet;

    @FXML
    private TextField trajet_Tarif;

    @FXML
    private TextField dureeTrajet;

    @FXML
    private ChoiceBox<?> villeDepartTrajet;

    @FXML
    private ChoiceBox<?> villeArriveTrajet;

    @FXML
    private Button btn_effacerTrajet;

    @FXML
    private Button btn_supprimerTrajet;

    @FXML
    private Button btn_modifierTrajet;

    @FXML
    private Button btn_ajouterTrajet;

    @FXML
    private Button btn_actualiserTrajet;

    @FXML
    private TableView<?> trajet_table;

    @FXML
    private TableColumn<?, ?> trajet_table_id;

    @FXML
    private TableColumn<?, ?> trajet_table_villeDepart;

    @FXML
    private TableColumn<?, ?> trajet_table_villeArrivee;

    @FXML
    private TableColumn<?, ?> trajet_table_tarif;

    @FXML
    private TableColumn<?, ?> trajet_table_duree;

    @FXML
    private VBox trajetrecherche_vbox;

    @FXML
    private ChoiceBox<?> trajetrecherche_type;

    @FXML
    private ImageView trajetlancer_recherche;

    @FXML
    private TextField trajettexte_recherche;
    
    
    
    /* variables trajetCaissier//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
      @FXML
    private TableView<?> trajet_tableCaissier;

    @FXML
    private TableColumn<?, ?> trajet_tableCaissier_id;

    @FXML
    private TableColumn<?, ?> trajet_tableCaissier_villeDepart;

    @FXML
    private TableColumn<?, ?> trajet_tableCaissier_villeArrivee;

    @FXML
    private TableColumn<?, ?> trajet_tableCaissier_tarif;

    @FXML
    private TableColumn<?, ?> trajet_tableCaissier_duree;

    @FXML
    private VBox trajetrecherche_vboxCaissier;

    @FXML
    private ChoiceBox<?> trajetrecherche_typeCaissier;

    @FXML
    private ImageView trajetlancer_rechercheCaissier;

    @FXML
    private TextField trajettexte_rechercheCaissier;
    
    
    
    
    
    
/*variables chauffeurAdministrateur chauffeurGestionnaire/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
     @FXML
    private Label erreur_prenomchauffeur;

    @FXML
    private TextField chauffeur_nom;

    @FXML
    private TextField chauffeur_contact;

    @FXML
    private TextField idChauffeur;

    @FXML
    private TextField chauffeur_numTelephone;

    @FXML
    private Label erreur_nomChauffeur;

    @FXML
    private Label erreur_numTelephoneChauffeur;

    @FXML
    private Label erreur_tauxHoraire;

    @FXML
    private ChoiceBox<?> catgorieChauffeur;

    @FXML
    private Label erreur_categorieChauffeur;

    @FXML
    private Button btn_effacerChauffeur;

    @FXML
    private Button btn_supprimerchauffeur;

    @FXML
    private Button btn_modifierChauffeur;

    @FXML
    private Button btn_ajouterchauffeur;

    @FXML
    private Button btn_actualiserchauffeur;

    @FXML
    private TableView<?> chauffeur_table;

    @FXML
    private TableColumn<?, ?> chauffeur_table_id;

    @FXML
    private TableColumn<?, ?> chauffeur_table_nom;

    @FXML
    private TableColumn<?, ?> chauffeur_table_prenom;

    @FXML
    private TableColumn<?, ?> chauffeur_table_numTel;

    @FXML
    private TableColumn<?, ?> chauffeur_table_tauxHoraire;

    @FXML
    private TableColumn<?, ?> chauffeur_table_categorie;

    @FXML
    private VBox recherche_vbox;

    @FXML
    private ChoiceBox<?> chauffeurrecherche_type;

    @FXML
    private ImageView chauffeurlancer_recherche;

    @FXML
    private TextField chauffeurtexte_recherche;
    
    
    
    
/*variables chauffeurCaissier//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    @FXML
    private TableView<?> chauffeur_tableCaissier;

    @FXML
    private TableColumn<?, ?> chauffeur_tableCaissier_id;

    @FXML
    private TableColumn<?, ?> chauffeur_tableCaissier_nom;

    @FXML
    private TableColumn<?, ?> chauffeur_tableCaissier_prenom;

    @FXML
    private TableColumn<?, ?> chauffeur_tableCaissier_numTel;

    @FXML
    private TableColumn<?, ?> chauffeur_tableCaissier_tauxHoraire;

    @FXML
    private TableColumn<?, ?> chauffeur_tableCaissier_categorie;

    @FXML
    private VBox chauffeurrecherche_vboxCaissier;

    @FXML
    private ChoiceBox<?> chauffeurrecherche_typeCaissier;

    @FXML
    private ImageView chauffeurlancer_rechercheCaissier;

    @FXML
    private TextField chauffeurtexte_rechercheCaissier;

    
    
    
    
/*variables utilisateurs Administrateur///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
       @FXML
    private Label erreur_nom;

    @FXML
    private Label erreur_contactUtilisateur;

    @FXML
    private TextField utilisateur_nom;

    @FXML
    private TextField utilisateur_contact;

    @FXML
    private Label erreur_emailUtilisateur;

    @FXML
    private Label erreur_nomUtilisateur;

    @FXML
    private Label erreur_mdpUtilisateur;

    @FXML
    private TextField utilisateur_nomUtilisateur;

    @FXML
    private TextField utilisateur_email;

    @FXML
    private TextField utilisateur_categorie;

    @FXML
    private Label erreur_categorieUtilisateur;

    @FXML
    private PasswordField utilisateur_mdp;

    @FXML
    private Button btn_effacerUtilisateur;

    @FXML
    private Button btn_supprimerUtilisateur;

    @FXML
    private Button btn_modifierUtilisateur;

    @FXML
    private Button btn_ajouterUtilisateur;

    @FXML
    private Button btn_actualiserUtilisateur;

    @FXML
    private TableView<?> utilisateur_table;

    @FXML
    private TableColumn<?, ?> utilisateur_table_id;

    @FXML
    private TableColumn<?, ?> utilisateur_table_nom;

    @FXML
    private TableColumn<?, ?> utilisateur_table_contact;

    @FXML
    private TableColumn<?, ?> utilisateur_table_email;

    @FXML
    private TableColumn<?, ?> utilisateur_table_nomUtilisateur;

    @FXML
    private TableColumn<?, ?> utilisateur_table_mdp;

    @FXML
    private TableColumn<?, ?> utilisateur_table_categorie;

    @FXML
    private TableColumn<?, ?> utilisateur_table_derniereActivite;

    @FXML
    private TableColumn<?, ?> utilisateur_table_dateInscription;

    @FXML
    private VBox utilisateurrecherche_vbox;

    @FXML
    private ChoiceBox<?> utilisateurrecherche_type;

    @FXML
    private ImageView utilisateurlancer_recherche;

    @FXML
    private TextField utilisateurtexte_recherche;
    
   
    
    
    
   
    
    /* Initialisation//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    @Override
    public void initialize(URL location, ResourceBundle resources){
        
    }
    
/*fonctions/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/    
    
    
/*fonction page loader////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
    
    
    
    
/*fonction  page login//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
    @FXML
    void envoyerVersMdpOublie(MouseEvent event) {
     
    }

     @FXML
    void seConnecter(ActionEvent event) throws IOException {
    String username=loginUsername.getText();
    String password=loginPassword.getText();
    Utilisateur u=new Utilisateur(username,password);
    if(rb_administrateur.isSelected()){ 
        generalborderpane = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Stage secondaryStage=new Stage();
        Scene scene1 = new Scene(generalborderpane); 
        
        
        
        secondaryStage.getIcons().add(new Image("/image/5.png"));
        secondaryStage.setTitle("Bus-Gest");
        
        secondaryStage.setScene(scene1);
        secondaryStage.setResizable(false);
        secondaryStage.show();
        Parent root= FXMLLoader.load(getClass().getResource("dashboardvbox1.fxml"));
        generalborderpane.setCenter(root);
       
        
       
        
    }else if(rb_gestionnaire.isSelected()){
        generalborderpaneGestionnaire = FXMLLoader.load(getClass().getResource("menuGestionnaire.fxml"));
        Stage secondaryStage=new Stage();
        Scene scene1 = new Scene(generalborderpaneGestionnaire); 
        
        
        
        secondaryStage.getIcons().add(new Image("/image/5.png"));
        secondaryStage.setTitle("Bus-Gest");
        
        secondaryStage.setScene(scene1);
        secondaryStage.setResizable(false);
        secondaryStage.show();
        Parent root= FXMLLoader.load(getClass().getResource("dashboardvbox2.fxml"));
        generalborderpaneGestionnaire.setCenter(root);
        
    }else if(rb_caissier.isSelected()){
        generalborderpaneCaissier = FXMLLoader.load(getClass().getResource("menuCaissier.fxml"));
        Stage secondaryStage=new Stage();
        Scene scene1 = new Scene(generalborderpaneCaissier); 
        
        
        
        secondaryStage.getIcons().add(new Image("/image/5.png"));
        secondaryStage.setTitle("Bus-Gest");
        
        secondaryStage.setScene(scene1);
        secondaryStage.setResizable(false);
        secondaryStage.show();
        Parent root= FXMLLoader.load(getClass().getResource("dashboardvbox3.fxml"));
        generalborderpaneCaissier.setCenter(root);
        
    }
    
    }

    @FXML
    void viderChamp(ActionEvent event) {
    loginUsername.setText("");
    loginPassword.setText("");
    }
    
    
    
    
/*fonction page mdp oublie//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
   
    
    
    
/* fonction menuAdministrateur////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
      @FXML
    void DeroulerpetiteListeInformationDeMonCompte(MouseEvent event) {

    }

    @FXML
    void activer_deconnexionMenuAdministrateur(MouseEvent event) {

    }

    @FXML
    void bus_menuverticalAdministrateurSourisDedans(MouseEvent event) {
    bus_menuverticalAdministrateur.setStyle("-fx-background-color: #87ceeb; ");
   
    }

    @FXML
    void bus_menuverticalAdministrateurSourisDehors(MouseEvent event) {
    bus_menuverticalAdministrateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void chauffeur_menuverticalAdministrateurSourisDedans(MouseEvent event) {
    chauffeur_menuverticalAdministrateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void chauffeur_menuverticalAdministrateurSourisDehors(MouseEvent event) {
    chauffeur_menuverticalAdministrateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void client_menuverticalAdministrateurSourisDedans(MouseEvent event) {
    client_menuverticalAdministrateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void client_menuverticalAdministrateurSourisDehors(MouseEvent event) {
    client_menuverticalAdministrateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void deconnexion_menuverticalAdmiistrateurSourisDedans(MouseEvent event) {
    deconnexion_menuverticalAdmiistrateur1.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void deconnexion_menuverticalAdmiistrateurSourisDehors(MouseEvent event) {
    deconnexion_menuverticalAdmiistrateur1.setStyle("-fx-background-color: #fff; ");
    }
    
    @FXML
    void menuAdministrateurlancerRechercheGo(MouseEvent event) {

    }
    @FXML
    void envoyerVersMonCompte(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_busMenuAdministrateur(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        Parent root= FXMLLoader.load(getClass().getResource("bus.fxml"));
       
        generalborderpane.setCenter(root);
        

    }

    @FXML
    void envoyer_vers_chauffeurMenuAdministrateur(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("chauffeur.fxml"));
       generalborderpane.setCenter(root);
    }

    @FXML
    void envoyer_vers_clientMenuAdministrateur(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("client.fxml"));
       generalborderpane.setCenter(root);
    }

    @FXML
    void envoyer_vers_reservationMenuAdministrateur(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("reservation.fxml"));
       generalborderpane.setCenter(root);
    }

    @FXML
    void envoyer_vers_tbdMenuAdministrateur(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("dashboardvbox1.fxml"));
       generalborderpane.setCenter(root);
    }

    @FXML
    void envoyer_vers_ticketMenuAdministrateur(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("ticket.fxml"));
       generalborderpane.setCenter(root);
    }

    @FXML
    void envoyer_vers_trajetMenuAdministrateur(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("trajet.fxml"));
       generalborderpane.setCenter(root);
    }

    @FXML
    void envoyer_vers_utilisateurMenuAdministrateur(MouseEvent event) throws IOException {
         
       Parent root= FXMLLoader.load(getClass().getResource("utilisateur.fxml"));
       generalborderpane.setCenter(root);
       
       
       
    }

    @FXML
    void envoyer_vers_voyagemenuAdministrateur(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("voyage.fxml"));
       generalborderpane.setCenter(root);
    }

    @FXML
    void lancer_rechercheSourisDedans(MouseEvent event) {
    lancer_recherche.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void lancer_rechercheSourisDehors(MouseEvent event) {
    lancer_recherche.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void moncompteSourisDedans(MouseEvent event) {
    moncompte.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void moncompteSourisDehors(MouseEvent event) {
    moncompte.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void petiteListeInformationDeMonCompteSourisDedans(MouseEvent event) {
    petiteListeInformationDeMonCompte.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void petiteListeInformationDeMonCompteSourisDehors(MouseEvent event) {
    petiteListeInformationDeMonCompte.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void reservation_menuverticalAdministrateurSourisDedans(MouseEvent event) {
    reservation_menuverticalAdministrateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void reservation_menuverticalAdministrateurSourisDehors(MouseEvent event) {
    reservation_menuverticalAdministrateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void tblbord_menuvertucalAdministraateurSourisDedans(MouseEvent event) {
    tblbord_menuvertucalAdministraateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void tblbord_menuvertucalAdministraateurSourisDehors(MouseEvent event) {
    tblbord_menuvertucalAdministraateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void texte_rechercheSourisDedans(MouseEvent event) {
    texte_recherche.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void texte_rechercheSourisDehors(MouseEvent event) {
    texte_recherche.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void ticket_menuverticalAdministrateurSourisDedans(MouseEvent event) {
    ticket_menuverticalAdministrateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void ticket_menuverticalAdministrateurSourisDehors(MouseEvent event) {
    ticket_menuverticalAdministrateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void trajet_menuverticalAdministrateurSourisDEdans(MouseEvent event) {
    trajet_menuverticalAdministrateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void trajet_menuverticalAdministrateurSourisDehors(MouseEvent event) {
    trajet_menuverticalAdministrateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void utilisateurs_menuverticalAdmiistrateurSourisDedans(MouseEvent event) {
    utilisateurs_menuverticalAdmiistrateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void utilisateurs_menuverticalAdmiistrateurSourisDehors(MouseEvent event) {
    utilisateurs_menuverticalAdmiistrateur.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void voyage_menuverticalAdministrateurSourisDedans(MouseEvent event) {
     voyage_menuverticalAdministrateur.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void voyage_menuverticalAdministrateurSourisDehors(MouseEvent event) {
     voyage_menuverticalAdministrateur.setStyle("-fx-background-color: #fff; ");
    }

    
    
    
    
    /* fonction menuGestionnaire////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
      @FXML
    void DeroulerpetiteListeInformationDeMonCompteGestionnaire(MouseEvent event) {

    }

    @FXML
    void activer_deconnexionMenuGestionnaire(MouseEvent event) {

    }

    @FXML
    void chauffeur_menuverticalGestionnaireSourisDedans(MouseEvent event) {
    chauffeur_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void chauffeur_menuverticalGestionnaireSourisDehors(MouseEvent event) {
    chauffeur_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void client_menuverticalGestionnaireSourisDedans(MouseEvent event) {
    client_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void client_menuverticalGestionnaireSourisDehors(MouseEvent event) {
    client_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void deconnexion_menuverticalGestionnaireSourisDedans(MouseEvent event) {
    deconnexion_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void deconnexion_menuverticalGestionnaireSourisDehors(MouseEvent event) {
    deconnexion_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void envoyerVersMonCompteGestionnaire(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_busMenuGestionnaire(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("bus.fxml"));
        generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void envoyer_vers_busMenuGestionnaireSourisDedans(MouseEvent event) {
    bus_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void envoyer_vers_busMenuGestionnaireSourisDehors(MouseEvent event) {
     bus_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void envoyer_vers_chauffeurMenuGestionnaire(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("chauffeur.fxml"));
       generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void envoyer_vers_clientMenuGestionnaire(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("client.fxml"));
        generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void envoyer_vers_reservationMenuGestionnaire(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("reservation.fxml"));
       generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void envoyer_vers_tbdMenuGestionnaire(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("dashboardvbox2.fxml"));
       generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void envoyer_vers_tbdMenuGestionnaireSourisDedans(MouseEvent event) {
    tblbord_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void envoyer_vers_tbdMenuGestionnaireSourisDehors(MouseEvent event) {
    tblbord_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void envoyer_vers_ticketMenuGestionnaire(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("ticket.fxml"));
       generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void envoyer_vers_trajetMenuGestionnaire(MouseEvent event) throws IOException {
      Parent root= FXMLLoader.load(getClass().getResource("trajet.fxml"));
       generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void envoyer_vers_voyagemenuGestionnaire(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("voyage.fxml"));
       generalborderpaneGestionnaire.setCenter(root);
    }

    @FXML
    void menuGestionnairelancerRechercheGo(MouseEvent event) {

    }

    @FXML
    void menuGestionnairelancer_rechercheSourisDedans(MouseEvent event) {
    menuGestionnairelancer_recherche.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void menuGestionnairelancer_rechercheSourisDehors(MouseEvent event) {
    menuGestionnairelancer_recherche.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void menuGestionnairetexte_rechercheSourisDedans(MouseEvent event) {

    }

    @FXML
    void menuGestionnairetexte_rechercheSourisDehors(MouseEvent event) {

    }

    @FXML
    void moncompteGestionnaireSourisDedans(MouseEvent event) {
    moncompteGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void moncompteGestionnaireSourisDehors(MouseEvent event) {
    moncompteGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void petiteListeInformationDeMonCompteGestionnaireSourisDedans(MouseEvent event) {
    petiteListeInformationDeMonCompteGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void petiteListeInformationDeMonCompteGestionnaireSourisDehors(MouseEvent event) {
    petiteListeInformationDeMonCompteGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void reservation_menuverticalGestionnaireSourisDedans(MouseEvent event) {
    reservation_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void reservation_menuverticalGestionnaireSourisDehors(MouseEvent event) {
    reservation_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void ticket_menuverticalGestionnaireSourisDedans(MouseEvent event) {
    ticket_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void ticket_menuverticalGestionnaireSourisDehors(MouseEvent event) {
    ticket_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void trajet_menuverticalGestionnaireSourisDedans(MouseEvent event) {
    trajet_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void trajet_menuverticalGestionnaireSourisDehors(MouseEvent event) {
    trajet_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void voyage_menuverticalGestionnaireSourisDedans(MouseEvent event) {
    voyage_menuverticalGestionnaire.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void voyage_menuverticalGestionnaireSourisDehors(MouseEvent event) {
    voyage_menuverticalGestionnaire.setStyle("-fx-background-color: #fff; ");
    }
 
    
    
    
    
/* fonction menuCaissier////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
      @FXML
    void DeroulerpetiteListeInformationDeMonCompteCaissier(MouseEvent event) {

    }

    @FXML
    void activer_deconnexionMenuCaissier(MouseEvent event) {

    }

    @FXML
    void chauffeur_menuverticalCaissierSourisDedans(MouseEvent event) {
    chauffeur_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void chauffeur_menuverticalCaissierSourisDehors(MouseEvent event) {
    chauffeur_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void client_menuverticalCaissierSourisDedans(MouseEvent event) {
    client_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void client_menuverticalCaissierSourisDehors(MouseEvent event) {
    client_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void deconnexion_menuverticalCaissierSourisDedans(MouseEvent event) {
    deconnexion_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void deconnexion_menuverticalCaissierSourisDehors(MouseEvent event) {
    deconnexion_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void envoyerVersMonCompteCaissier(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_busMenuCaissier(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("busCaissier.fxml"));
        generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void envoyer_vers_busMenuCaissierSourisDedans(MouseEvent event) {
    bus_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void envoyer_vers_busMenuCaissierSourisDehors(MouseEvent event) {
    bus_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void envoyer_vers_chauffeurMenuCaissier(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("chauffeurCaissier.fxml"));
       generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void envoyer_vers_clientMenuCaissier(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("client.fxml"));
        generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void envoyer_vers_reservationMenuCaissier(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("reservation.fxml"));
       generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void envoyer_vers_tbdMenuCaissier(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("dashboardvbox3.fxml"));
       generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void envoyer_vers_tbdMenuCaissierSourisDedans(MouseEvent event) {
    tblbord_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void envoyer_vers_tbdMenuCaissierSourisDehors(MouseEvent event) {
    tblbord_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void envoyer_vers_ticketMenuCaissier(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("ticket.fxml"));
       generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void envoyer_vers_trajetMenuCaissier(MouseEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("trajetCaissier.fxml"));
       generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void envoyer_vers_voyagemenuCaissier(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("voyageCaissier.fxml"));
        generalborderpaneCaissier.setCenter(root);
    }

    @FXML
    void menuCaissierlancerRechercheGo(MouseEvent event) {

    }

    @FXML
    void menuCaissierlancer_rechercheSourisDedans(MouseEvent event) {
    menuCaissierlancer_recherche.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void menuCaissierlancer_rechercheSourisDehors(MouseEvent event) {
    menuCaissierlancer_recherche.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void menuCaissiertexte_rechercheSourisDedans(MouseEvent event) {

    }

    @FXML
    void menuCaissiertexte_rechercheSourisDehors(MouseEvent event) {

    }

    @FXML
    void moncompteCaissierSourisDedans(MouseEvent event) {
    moncompteCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void moncompteCaissierSourisDehors(MouseEvent event) {
    moncompteCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void petiteListeInformationDeMonCompteCaissierSourisDedans(MouseEvent event) {
    petiteListeInformationDeMonCompteCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void petiteListeInformationDeMonCompteCaissierSourisDehors(MouseEvent event) {
    petiteListeInformationDeMonCompteCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void reservation_menuverticalCaissierSourisDedans(MouseEvent event) {
    reservation_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void reservation_menuverticalCaissierSourisDehors(MouseEvent event) {
    reservation_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void ticket_menuverticalCaissierSourisDedans(MouseEvent event) {
    ticket_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void ticket_menuverticalCaissierSourisDehors(MouseEvent event) {
     ticket_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void trajet_menuverticalCaissierSourisDedans(MouseEvent event) {
    trajet_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void trajet_menuverticalCaissierSourisDehors(MouseEvent event) {
    trajet_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }

    @FXML
    void voyage_menuverticalCaissierSourisDedans(MouseEvent event) {
    voyage_menuverticalCaissier.setStyle("-fx-background-color: #87ceeb; ");
    }

    @FXML
    void voyage_menuverticalCaissierSourisDehors(MouseEvent event) {
    voyage_menuverticalCaissier.setStyle("-fx-background-color: #fff; ");
    }
    
    
    
    
    
    /* fonction dashboardAdministrateur////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void bus_image_tableaudebordAdministrateurSourisDedans(MouseEvent event) {

    }

    @FXML
    void bus_image_tableaudebordAdministrateurSourisDehors(MouseEvent event) {

    }

    @FXML
    void chauffeur_image_tableaudebordAdministrateurSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeur_image_tableaudebordAdministrateurSourisDehors(MouseEvent event) {

    }

    @FXML
    void client_image_tableaudebordAdministrateurSourisDedans(MouseEvent event) {

    }

    @FXML
    void client_image_tableaudebordAdministrateurSourisDehors(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_busTableauDeBordAdministrateur(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
       
    }

    @FXML
    void envoyer_vers_chauffeurTableauDeBordAdministrateur(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_clientTableauDeBordAdministrateur(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_reservationTableauDeBordAdministrateur(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_ticketTableauDeBordAdministrateur(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_trajetTableauDeBordAdministrateur(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_utilisateurTableaudeBordAdministrateur(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_voyageTableauDeBordAdministrateur(MouseEvent event) {

    }

    @FXML
    void reservation_image_tableaudebordAdministrateurSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservation_image_tableaudebordAdministrateurSourisDehors(MouseEvent event) {

    }

    @FXML
    void ticket_image_tableaudebordAdministrateurSourisDedans(MouseEvent event) {

    }

    @FXML
    void ticket_image_tableaudebordAdministrateurSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajet_image_tableaudebordAdministrateurSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajet_image_tableaudebordAdministrateurSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyage_image_tableaudebordAdministrateurSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyage_image_tableaudebordAdministrateurSourisDehors(MouseEvent event) {

    }

    
    
    
    
/*fonction dashboardGestionnaire///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void bus_image_tableaudebordGestionnaireSourisDedans(MouseEvent event) {

    }

    @FXML
    void bus_image_tableaudebordGestionnaireSourisDehors(MouseEvent event) {

    }

    @FXML
    void chauffeur_image_tableaudebordGestionnaireSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeur_image_tableaudebordGestionnaireSourisDehors(MouseEvent event) {

    }

    @FXML
    void client_image_tableaudebordGestionnaireSourisDedans(MouseEvent event) {

    }

    @FXML
    void client_image_tableaudebordGestionnaireSourisDehors(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_busTableauDeBordGestionnaire(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_chauffeurTableauDeBordGestionnaire(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_clientTableauDeBordGestionnaire(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_reservationTableauDeBordGestionnaire(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_ticketTableauDeBordAdministrateurGestionnaire(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_trajetTableauDeBordAdministrateurGestionnaire(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_voyageTableauDeBordGestionnaire(MouseEvent event) {

    }

    @FXML
    void reservation_image_tableaudebordGestionnaireSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservation_image_tableaudebordGestionnaireSourisDehors(MouseEvent event) {

    }

    @FXML
    void ticket_image_tableaudebordGestionnaireSourisDedans(MouseEvent event) {

    }

    @FXML
    void ticket_image_tableaudebordGestionnaireSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajet_image_tableaudebordGestionnaireSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajet_image_tableaudebordGestionnaireSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyage_image_tableaudebordGestionnaireSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyage_image_tableaudebordGestionnaireSourisDehors(MouseEvent event) {

    }
    

 
    
    
/*fonction dashboardCaissier///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     
     @FXML
    void bus_image_tableaudebordCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void bus_image_tableaudebordCaissierSourisDehors(MouseEvent event) {

    }

    @FXML
    void chauffeur_image_tableaudebordCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeur_image_tableaudebordCaissierSourisDehors(MouseEvent event) {

    }

    @FXML
    void client_image_tableaudebordCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void client_image_tableaudebordCaissierSourisDehors(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_busTableauDeBordCaissier(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_chauffeurTableauDeBordCaissier(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_clientTableauDeBordCaissier(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_reservationTableauDeBordCaissier(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_ticketTableauDeBordAdministrateurCaissier(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_trajetTableauDeBordAdministrateurCaissier(MouseEvent event) {

    }

    @FXML
    void envoyer_vers_voyageTableauDeBordCaissier(MouseEvent event) {

    }

    @FXML
    void reservation_image_tableaudebordCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservation_image_tableaudebordCaissierSourisDehors(MouseEvent event) {

    }

    @FXML
    void ticket_image_tableaudebordCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void ticket_image_tableaudebordCaissierSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajet_image_tableaudebordCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajet_image_tableaudebordCaissierSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyage_image_tableaudebordCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyage_image_tableaudebordCaissierSourisDehors(MouseEvent event) {

    }

    
    
/*fonction busAdministrateur busGestionnaire////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    @FXML
    void actualiserbus(ActionEvent event) throws SQLException, ClassNotFoundException {
        bus_table.setItems(findAllBus());
        System.out.println("blablabla");
    }

    @FXML
    void ajouterbus(ActionEvent event) throws SQLException, ClassNotFoundException {
     String immatriculation=bus_Immatriculation.getText();
     String capacite=bus_capacite.getText();
     String status=statusBus.getText();
     if(immatriculation.isEmpty()){
            erreur_immatriculation.setText("!Saisir une immatriculation");
     }else if(capacite.isEmpty()){
            erreur_capacitebus.setText("!Saisir une capacite");
            
     }else if(status.isEmpty()){
            statusBus.setText("valide");
            
     }else{
         int capaciteInt=Integer.parseInt(capacite);
         if(14>capaciteInt&&capaciteInt>90){
                 erreur_capacitebus.setText("!invalide");
         }else{
             Bus b=new Bus(immatriculation,capaciteInt,status);
             if(!Dao.busExist(b)){
                 Dao.createBus(b);
             }
         }
     }
    }

    @FXML
    void busactualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void busactualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void busajouterSourisDedans(MouseEvent event) {

    }

    @FXML
    void busajouterSourisDehors(MouseEvent event) {

    }

    @FXML
    void buseffacerSourisDedans(MouseEvent event) {

    }

    @FXML
    void buseffacerSourisDehors(MouseEvent event) {

    }

    @FXML
    void buslancer_recherche(MouseEvent event) {

    }

    @FXML
    void busmodifierSourisDedans(MouseEvent event) {

    }

    @FXML
    void busmodifierSourisDehors(MouseEvent event) {

    }

    @FXML
    void bussupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void bussupprimerSourisDehors(MouseEvent event) {

    }

    @FXML
    void effacerbus(ActionEvent event) {
     bus_Immatriculation.getText();
     bus_capacite.setText("");
    }

    @FXML
    void modifierPrevesualisationbus(MouseEvent event) {

    }

    @FXML
    void modifierbus(ActionEvent event) {

    }

    @FXML
    void supprimerbus(ActionEvent event) {

    }
    
    
    
    /*fonction busCaissier////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void buslancer_rechercheCaissier(MouseEvent event) {

    }
    
    
    
    
    /*fonction voyageAdministrateur voyageGestionnaire////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void actualiserVoyage(ActionEvent event) {

    }

    @FXML
    void ajouterVoyage(ActionEvent event) {

    }

    @FXML
    void creerReservationVoyage(ActionEvent event) {

    }

    @FXML
    void effacerVoyage(ActionEvent event) {

    }

    @FXML
    void modifierVoyage(ActionEvent event) {

    }

    @FXML
    void modifierVoyagePrevisualisation(MouseEvent event) {

    }

    @FXML
    void supprimerVoyage(ActionEvent event) {

    }

    @FXML
    void voyageactualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyageactualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyageajouterSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyageajouterSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyagecreerReservationSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyagecreerReservationSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyageeffacerSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyageeffacerSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyagelancer_recherche(MouseEvent event) {

    }

    @FXML
    void voyagelancer_rechercheSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyagelancer_rechercheSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyagemodifierSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyagemodifierSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyagesupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyagesupprimerSourisDehors(MouseEvent event) {

    }

    
    
/*fonction voyageCaissier////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
   @FXML
    void creerReservationVoyageCaissier(ActionEvent event) {

    }

    @FXML
    void voyagecreerReservationCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyagecreerReservationCaissierSourisDehors(MouseEvent event) {

    }

    @FXML
    void voyagelancer_rechercheCaissier(MouseEvent event) {

    }

    @FXML
    void voyagelancer_rechercheCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void voyagelancer_rechercheCaissierSourisDehors(MouseEvent event) {

    }
    
    
    
    
    
/*fonction clientAdministrateur clientGestionnaire clientCaissier/////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
  @FXML
    void actualiserClient(ActionEvent event) {

    }

    @FXML
    void ajouterClient(ActionEvent event) {

    }

    @FXML
    void clientactualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void clientactualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void clientajouterSourisDedans(MouseEvent event) {

    }

    @FXML
    void clientajouterSourisDehors(MouseEvent event) {

    }

    @FXML
    void clienteffacerSourisDedans(MouseEvent event) {

    }

    @FXML
    void clienteffacerSourisDehors(MouseEvent event) {

    }

    @FXML
    void clientlancer_recherche(MouseEvent event) {

    }

    @FXML
    void clientmodifierSourisDedans(MouseEvent event) {

    }

    @FXML
    void clientmodifierSourisDehors(MouseEvent event) {

    }

    @FXML
    void clientsupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void clientsupprimerSourisDehors(MouseEvent event) {

    }

    @FXML
    void effacerClient(ActionEvent event) {

    }

    @FXML
    void modifierClient(ActionEvent event) {

    }

    @FXML
    void modifierPrevisualisationClient(MouseEvent event) {

    }

    @FXML
    void supprimerClient(ActionEvent event) {

    }   
    
/*fonction reservationAdministrateur reservationGestionnaire reservationCaissier//////////////////////////////////////////////////////////////////////////////////////////////////*/    
 @FXML
    void actualiserReservation(ActionEvent event) {

    }

    @FXML
    void ajouterReservation(ActionEvent event) {

    }

    @FXML
    void effacerReservation(ActionEvent event) {

    }

    @FXML
    void genererTicketReservation(ActionEvent event) {

    }

    @FXML
    void lancer_recherche(MouseEvent event) {

    }

    @FXML
    void reservationactualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservationactualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void reservationajouterSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservationajouterSourisDehors(MouseEvent event) {

    }

    @FXML
    void reservationeffacerSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservationeffacerSourisDehors(MouseEvent event) {

    }

    @FXML
    void reservationenvoyer_vers_ticket(MouseEvent event) {

    }

    @FXML
    void reservationgenererTicketSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservationgenererTicketSourisDehors(MouseEvent event) {

    }

    @FXML
    void reservationrecherche_typeSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservationrecherche_typeSourisDehors(MouseEvent event) {

    }

    @FXML
    void reservationsupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void reservationsupprimerSourisDehors(MouseEvent event) {

    }

    @FXML
    void supprimerReservation(ActionEvent event) {

    }

    
    
    
    /*fonction ticketAdministrateur ticketGestionnaire ticketCaissier////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    @FXML
    void actualiserTicket(ActionEvent event) {

    }

    @FXML
    void impresionTicketPrevisualisation(MouseEvent event) {

    }

    @FXML
    void imprimerTicket(ActionEvent event) {

    }

    @FXML
    void imprimerTicketSourisDedans(MouseEvent event) {

    }

    @FXML
    void imprimerTicketSourisDehors(MouseEvent event) {

    }

    @FXML
    void supprimerTicket(ActionEvent event) {

    }

    @FXML
    void ticketactualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void ticketactualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void ticketlancer_recherche(MouseEvent event) {

    }

    @FXML
    void ticketlancer_rechercheSourisDedans(MouseEvent event) {

    }

    @FXML
    void ticketlancer_rechercheSourisDehors(MouseEvent event) {

    }

    @FXML
    void ticketsupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void ticketsupprimerSourisDehors(MouseEvent event) {

    }

    
    
/*fonction trajetAdministrateur trajetGestionnaire////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void actualiserTrajet(ActionEvent event) {

    }

    @FXML
    void ajouterTrajet(ActionEvent event) {

    }

    @FXML
    void effacerTrajet(ActionEvent event) {

    }

    @FXML
    void modifierPrevisualisationTrajet(MouseEvent event) {

    }

    @FXML
    void modifierTrajet(ActionEvent event) {

    }

    @FXML
    void supprimerTrajet(ActionEvent event) {

    }

    @FXML
    void trajetactualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajetactualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajetajouterSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajetajouterSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajeteffacerSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajeteffacerSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajetlancer_recherche(MouseEvent event) {

    }

    @FXML
    void trajetlancer_rechercheSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajetlancer_rechercheSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajetmodifierSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajetmodifierSourisDehors(MouseEvent event) {

    }

    @FXML
    void trajetsupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajetsupprimerSourisDehors(MouseEvent event) {

    }
    
    
    
    
    /*fonction trajetCaissier////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    
    
     @FXML
    void trajetlancer_rechercheCaissier(MouseEvent event) {

    }

    @FXML
    void trajetlancer_rechercheCaissierSourisDedans(MouseEvent event) {

    }

    @FXML
    void trajetlancer_rechercheCaissierSourisDehors(MouseEvent event) {

    }
    
    
    
    /*fonction chauffeurAdministrateur chauffeurGestionniare/////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void actualiserchauffeur(ActionEvent event) {

    }

    @FXML
    void ajouterchauffeur(ActionEvent event) {

    }

    @FXML
    void chauffeuractualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeuractualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void chauffeurajouterSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeurajouterSourisDehors(MouseEvent event) {

    }

    @FXML
    void chauffeureffacerSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeureffacerSourisDehors(MouseEvent event) {

    }

    @FXML
    void chauffeurlancer_recherche(MouseEvent event) {

    }

    @FXML
    void chauffeurmodifierSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeurmodifierSourisDehors(MouseEvent event) {

    }

    @FXML
    void chauffeursupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void chauffeursupprimerSourisDehors(MouseEvent event) {

    }

    @FXML
    void effacerChauffeur(ActionEvent event) {

    }

    @FXML
    void modifierPrevisualisationChauffeur(MouseEvent event) {

    }

    @FXML
    void modifierchauffeur(ActionEvent event) {

    }

    @FXML
    void supprimerchauffeur(ActionEvent event) {

    }
    
    
    
    /*fonction chauffeurCaissier/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void chauffeurlancer_rechercheCaissier(MouseEvent event) {

    }
    
    
    /*fonction utilisateurAdministrateur//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
     @FXML
    void AdministrateurmodifierUtilisateurPrevisualisation(MouseEvent event) {

    }

    @FXML
    void actualiserUtilisateur(ActionEvent event) {

    }

    @FXML
    void ajouterUtilisateur(ActionEvent event) throws SQLException, ClassNotFoundException {
     String nom=utilisateur_nom.getText();
     String contact=utilisateur_contact.getText();
     String email=utilisateur_email.getText();
     String nomUtilisateur=utilisateur_nomUtilisateur.getText();
     String mdp=utilisateur_mdp.getText();
     String categorieutil=utilisateur_categorie.getText();
     if(nom.isEmpty()){
         erreur_nom.setText("Saisir un nom");
     }else if(contact.isEmpty()){
         erreur_contactUtilisateur.setText("Saisir un contact");
     }else if(email.isEmpty()){
         erreur_emailUtilisateur.setText("Saisir un email");
     }else if(nomUtilisateur.isEmpty()){
         erreur_nomUtilisateur.setText("Saisir un username");
     }else if(mdp.isEmpty()){
         erreur_mdpUtilisateur.setText("Saisir un mot de passe");
     }else if(categorieutil.isEmpty()){
         erreur_categorieUtilisateur.setText("Choisir une categorie");
     }else{
             erreur_nom.setText("");
             erreur_contactUtilisateur.setText("");
             erreur_emailUtilisateur.setText("");
             erreur_nomUtilisateur.setText("");
             erreur_mdpUtilisateur.setText("");
             erreur_contactUtilisateur.setText("");
             erreur_categorieUtilisateur.setText("");
             java.util.Date date=new java.util.Date();
             Date sqlDate = new java.sql.Date(date.getTime());
             Date sqlDerAc = new java.sql.Date(date.getTime());
             if(!Dao.isValid(contact)){
                 erreur_contactUtilisateur.setText("contact invalide");
             }else{
                 
                Utilisateur util=new Utilisateur(nom,contact,email,nomUtilisateur,mdp,categorieutil,sqlDate);
             if(!Dao.utilisateurExist(util)){
                  Alert a = new Alert(AlertType.NONE);
                  a.setAlertType(AlertType.INFORMATION);
                    a.setContentText("Ce utilisateur existe deja");
                    a.show();
             }else{
                try{
              
              Dao.createUtilisateur(util);
              }catch(SQLException ex){           
                   Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,ex);
                   
              }
             }
            } 
          }
             
    }

    @FXML
    void effacerUtilisateur(ActionEvent event) {

    }

    @FXML
    void modifierUtilisateur(ActionEvent event) {

    }

    @FXML
    void supprimerUtilisateur(ActionEvent event) {

    }

    @FXML
    void utilisateuractualiserSourisDedans(MouseEvent event) {

    }

    @FXML
    void utilisateuractualiserSourisDehors(MouseEvent event) {

    }

    @FXML
    void utilisateurajouterSourisDedans(MouseEvent event) {

    }

    @FXML
    void utilisateurajouterSourisDehors(MouseEvent event) {

    }

    @FXML
    void utilisateureffacerSourisDedans(MouseEvent event) {

    }

    @FXML
    void utilisateureffacerSourisDehors(MouseEvent event) {

    }

    @FXML
    void utilisateurlancer_recherche(MouseEvent event) {

    }

    @FXML
    void utilisateurmodifierSourisDedans(MouseEvent event) {

    }

    @FXML
    void utilisateurmodifierSourisDehors(MouseEvent event) {

    }

    @FXML
    void utilisateursupprimerSourisDedans(MouseEvent event) {

    }

    @FXML
    void utilisateursupprimerSourisDehors(MouseEvent event) {

    }

    
    
    
    
    
    
}