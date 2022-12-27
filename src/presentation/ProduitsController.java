package presentation;

import dao.ProduitDao;
import dao.ProduitDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import dao.entities.Produit;
import javafx.scene.control.TextField;
import services.ProduitService;
import services.ProduitServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ProduitsController implements Initializable {
    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrix;
    @FXML
    private TextField textQte;
    @FXML
    private ListView<Produit> listView;
    private ObservableList<Produit> observableList = FXCollections.observableArrayList();
    private ProduitService produitService;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        produitService = new ProduitServiceImpl(new ProduitDaoImpl());
        listView.setItems(observableList);
        loadProducts();
    }
    @FXML
    private void addProduit(){
        String nom = textNom.getText();
        float prix = Float.parseFloat(textPrix.getText());
        int qte = Integer.parseInt(textQte.getText());

        if(nom.isEmpty()|| prix ==0 || qte == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir tous les champs");
            alert.show();
        }else{
            Produit p =new Produit();
            p.setNom(nom);p.setPrix(prix);p.setQte(qte);
            produitService.addProduit(p);
            loadProducts();
        }
    }
    @FXML
    private void deleteProduit(){
        Produit p=listView.getSelectionModel().getSelectedItem();
        if(p!=null){
            produitService.deleteProduit(p);
            loadProducts();
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez selectionner un element");
            alert.show();
        }

    }
    private void loadProducts(){
        observableList.clear();
        observableList.addAll(produitService.getAllProduits());
    }
}
