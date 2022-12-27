package services;

import dao.ProduitDao;
import dao.entities.Produit;

import java.util.List;

public class ProduitServiceImpl implements ProduitService{
    ProduitDao pdao;

    public ProduitServiceImpl(ProduitDao pdao) {
        this.pdao = pdao;
    }

    @Override
    public List<Produit> getAllProduits() {
       return pdao.findAll();
    }

    @Override
    public void addProduit(Produit p) {
        pdao.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
        pdao.delete(p);
    }


    @Override
    public List<Produit> getProduitsParMc(String mc) {
        return null;
    }
}
