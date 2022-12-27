package services;

import dao.entities.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits();
    public void addProduit(Produit p);
    public void deleteProduit(Produit p);
    public List<Produit> getProduitsParMc(String mc);
}
