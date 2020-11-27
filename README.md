# Monkey_bankee
First project of the second year of Bachelor Web Development.

Realization of a desktop application for a bank in order to automate customer prospecting with a targeting according to the statue and revenues.

## Making the application work

To launch the MonkeyBankee application, add a file named "DBUtil" under the following path "monkey_bankee/src/com.monkey_bankee/util/DBUtil".

The file is in the following form : 

```
package com.monkey_bankee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // static final : attribut constant
    private static final String URL="jdbc:postgresql://127.0.0.1/monkeyBankee";
    private static final String USER="Votre user";
    private static final String PASS="Votre mot de passe";

    private Connection connection;

    // throws : on laisse la méthode qui va appeler le constructeur gérer l'exception
    public DBUtil() throws SQLException{
        try{
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to the PostgreSQL server successfully.\n");
        } catch (SQLException e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    protected Connection getConnection(){
        return this.connection;
    }
}
