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
}

