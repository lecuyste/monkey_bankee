package com.monkey_bankee.dao;

import com.monkey_bankee.model.Client;
import java.util.ArrayList;

public interface ClientDAO {

    public void addClient(Client client);

    public Client getByIdClient(int id);

    public Client getLastClient();

    public boolean deleteClient(int id);

    public ArrayList<Client> getAllClient();

}
