package model;

/**
 *
 * @author Tiago Martins Vargas
 *
 */
public class Individual extends Person {

    private String individualRegistration; // indivudal registration used for paying income tax // CPF (Brazil).
    private String identityDocument; // identity document used for prove the identity of an individual // RG (Brazil), Argentina (DNI).

    public Individual() {
    }
    
    public Individual(String individualRegistration, String identityDocument, Integer id, String name, String phone, String email, String dateOfBirth) {
        super(id, name, phone, email, dateOfBirth);
        this.individualRegistration = individualRegistration;
        this.identityDocument = identityDocument;
    }
    
    public String getIndividualRegistration() {
        return individualRegistration;
    }

    public void setIndividualRegistration(String individualRegistration) {
        this.individualRegistration = individualRegistration;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }
}
