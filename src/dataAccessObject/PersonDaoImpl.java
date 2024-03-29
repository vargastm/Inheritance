/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObject;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Person;

/**
 *
 * @author tiagomartins
 */
public class PersonDaoImpl implements Serializable {

    private PreparedStatement prepared;
    private ResultSet result;

    public void save(Person person, Connection connection) {
        String query = "INSERT INTO person(name, email, phone, dateOfBirth) VALUES(?, ?, ?, ?)";

        try {
            prepared = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, person.getName());
            prepared.setString(2, person.getEmail());
            prepared.setString(3, person.getPhone());
            prepared.setString(4, person.getDateOfBirth());
            prepared.executeUpdate();
            result = prepared.getGeneratedKeys();
            result.next();
            person.setId(result.getInt(1));

        } catch (Exception e) {
            System.out.println("Erro ao salvar pessoa" + e.getMessage());
        }
    }

    public void change(Person person, Connection connection) {
        String query = "UPDATE person SET name = ?, email = ?, phone = ?, dateOfBirth = ? WHERE idPerson = ?";
       
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, person.getName());
            prepared.setString(2, person.getEmail());
            prepared.setString(3, person.getPhone());
            prepared.setString(4, person.getDateOfBirth());
            prepared.setInt(5, person.getId());
            prepared.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Erro ao alterar pessoa " + e.getMessage());
        }
    }
    
    public void delete(int id) {
        String query = "DELETE FROM person WHERE idPerson = ?";
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            prepared.executeUpdate();
        } catch (Exception e) {
             System.out.println("Erro ao deletar pessoa" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
        
    }
}
