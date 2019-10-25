package dataAccessObject;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Individual;
import model.Person;

/**
 *
 * @author Tiago Martins Vargas
 * 
 */
public class IndividualDaoImpl implements Serializable {
    
    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;
    private Individual individual;
    private PersonDaoImpl personDaoImpl;

    public void save(Individual individual) {
        String query = "INSERT INTO individual(individualRegistration, identityDocument, idPerson) VALUES(?, ?, ?)";
        personDaoImpl = new PersonDaoImpl();
        try {
            connection = ConnectionFactory.getConnection();
            personDaoImpl.save(individual, connection);
            prepared = connection.prepareStatement(query);
            prepared.setString(1, individual.getIndividualRegistration());
            prepared.setString(2, individual.getIdentityDocument());
            prepared.setInt(3, individual.getId());
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar pessoa" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }
    
    public void change(Individual individual) {
        String query = "UPDATE individual SET individualRegistration = ?, identityDocument = ? WHERE idPerson = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, individual.getIndividualRegistration());
            prepared.setString(2, individual.getIdentityDocument());
            prepared.setInt(3, individual.getId());
            prepared.executeUpdate();
            personDaoImpl = new PersonDaoImpl();
            personDaoImpl.change(individual, connection);
        } catch (Exception e) {
            System.out.println("Erro ao alterar pessoa fisica" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }   
    
    public void delete(int id) {
        personDaoImpl = new PersonDaoImpl();
        personDaoImpl.delete(id);
    }
    
    public Individual listById(int id) {
        String query = "SELECT * FROM individual i INNER JOIN person p on i.idPerson = p.idPerson WHERE p.idPerson = ?";
        
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            individual = new Individual();
            individual.setId(result.getInt("id"));
            individual.setName(result.getString("name"));
            individual.setEmail(result.getString("email"));
            individual.setPhone(result.getString("phone"));
            individual.setDateOfBirth(result.getString("dateOfBirth"));
            individual.setIndividualRegistration(result.getString("individualRegistration"));
            individual.setIdentityDocument(result.getString("identityDocument"));
        } catch (Exception e) {
            System.out.println("Erro ao listar por id" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
        return individual;
    }
}

