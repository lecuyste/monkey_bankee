package com.monkey_bankee.dao.impl;

import com.monkey_bankee.model.Client;
import com.monkey_bankee.dao.ClientDAO;
import com.monkey_bankee.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAOImpl extends DBUtil implements ClientDAO {

    public ClientDAOImpl() throws SQLException {
        super();
    }

    @Override
    public void addClient(Client client) {

        try {
            String query = "INSERT INTO client " +
                    "(name, firstname, birthdate, email, tel, family_situation, current_account, regular_income, regular_spending, subscription, address_number, additional_address, street_address, postal_code, city_address, created_at)" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = getConnection().prepareStatement(query);
            st.setString(1, client.getName());
            st.setString(2, client.getFirstname());
            st.setString(3, client.getBirthdate());
            st.setString(4, client.getEmail());
            st.setString(5, client.getTel());
            st.setString(6, client.getFamily_situation());
            st.setString(7, client.getCurrent_account());
            st.setString(8, client.getRegular_income());
            st.setString(9, client.getRegular_spending());
            st.setString(10, client.getSubscription());
            st.setString(11, client.getAddress_number());
            st.setString(12, client.getAdditional_address());
            st.setString(13, client.getStreet_address());
            st.setString(14, client.getPostal_code());
            st.setString(15, client.getCity_address());
            st.setTimestamp(16, new java.sql.Timestamp(new java.util.Date().getTime()));

            if (st.executeUpdate() == 1) {
                System.out.println("Client est crée..");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public ArrayList<Client> getAllClient() {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            String query = "SELECT * FROM client";
            PreparedStatement st = getConnection().prepareCall(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                clients.add(transformSqlToClient(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client getByIdClient(int id) {
        Client client = new Client();
        try{
            String query = "SELECT * FROM client WHERE id = ?";
            PreparedStatement st = getConnection().prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                client = transformSqlToClient(rs);
            }
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client getLastClient() {
        Client client = new Client();
        try{
            String query = "SELECT * FROM client ORDER BY id DESC LIMIT 1";
            PreparedStatement st = getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                client = transformSqlToClient(rs);
            }
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public boolean deleteClient(int id) {
        try {
            String query = "DELETE FROM client  WHERE id = ?";
            PreparedStatement st = getConnection().prepareStatement(query);
            st.setInt(1, id);
            // ATTENTION PAS SELECT => executeUpdate();
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private Client transformSqlToClient(ResultSet rs) throws SQLException {

        Client client = new Client();
        client.setId(rs.getInt("id"));
        client.setName(rs.getString("name"));
        client.setFirstname(rs.getString("firstname"));
        client.setBirthdate(rs.getString("birthdate"));
        client.setEmail(rs.getString("email"));
        client.setTel(rs.getString("tel"));
        client.setFamily_situation(rs.getString("family_situation"));
        client.setCurrent_account(rs.getString("current_account"));
        client.setRegular_income(rs.getString("regular_income"));
        client.setRegular_spending(rs.getString("regular_spending"));
        client.setSubscription(rs.getString("subscription"));
        client.setAddress_number(rs.getString("address_number"));
        client.setAdditional_address(rs.getString("additional_address"));
        client.setStreet_address(rs.getString("street_address"));
        client.setPostal_code(rs.getString("postal_code"));
        client.setCity_address(rs.getString("city_address"));
        client.setCreated_at(rs.getTimestamp("created_at"));

        return client;
    }

}
