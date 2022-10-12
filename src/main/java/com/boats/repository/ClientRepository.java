package com.boats.repository;

import com.boats.model.ClientModel;
import com.boats.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClients(){
        return (List<ClientModel>) clientCrudRepository.findAll();
    }

    public Optional<ClientModel> getClient(Integer id){
        return clientCrudRepository.findById(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        return  clientCrudRepository.save(clientModel);
    }

    public void deleteClient(ClientModel clientModel){
        clientCrudRepository.delete(clientModel);
    }
}
