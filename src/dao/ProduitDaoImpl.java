package dao;

import dao.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements ProduitDao {
    public ProduitDaoImpl() {
    }

    @Override
    public List<Produit> findAll() {
        Connection connection = SingletonConnectionDB.getConnection();
        List<Produit> produits = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement("select * from t_produits");
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Produit p = new Produit();
                p.setID(rs.getInt("ID"));
                p.setNom(rs.getString("nom"));
                p.setPrix(rs.getFloat("prix"));
                p.setQte(rs.getInt("qte"));
                produits.add(p);
            }
        }catch(SQLException e){
                e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit findOne(int id) {
        return null;
    }

    @Override
    public Produit save(Produit o) {

        Connection conn=SingletonConnectionDB.getConnection();
        try {
            PreparedStatement pstm=conn.prepareStatement("insert into t_produits(nom,prix,quantite) " +
                    "values (?,?,?)");
            pstm.setString(1,o.getNom());
            pstm.setFloat(2,o.getPrix());
            pstm.setInt(3,o.getQte());
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(Produit o) {
        return false;
    }

    @Override
    public Produit update(Produit o) {
        return null;
    }

    @Override
    public List<Produit> findProduitsParMc(String mc) {
        return null;
    }
}
