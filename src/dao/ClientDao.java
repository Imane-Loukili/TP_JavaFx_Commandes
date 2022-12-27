package dao;

import dao.entities.Client;
import dao.entities.Produit;

import java.util.List;

public interface ClientDao extends Dao<Client>{
    List<Client> findClientByName(String mc);

}
