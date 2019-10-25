package dataAccessObject;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Corporation;

/**
 *
 * @author Tiago Martins Vargas
 * 
 */
public class CorporationDaoImpl implements Serializable {
    
    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;
    private Corporation corporation;
    private PersonDaoImpl personDaoImpl;

    public void save(Corporation corporation) {
        String query = "INSERT INTO individual(companyIdentificationNumber, idPerson) VALUES(?, ?)";
        personDaoImpl = new PersonDaoImpl();
        try {
            connection = ConnectionFactory.getConnection();
            personDaoImpl.save(corporation, connection);
            prepared = connection.prepareStatement(query);
            prepared.setString(1, corporation.getCompanyIdentificationNumber());
            prepared.setInt(2, corporation.getId());
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar pessoa" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }
}

