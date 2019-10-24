package model;

/**
 *
 * @author Tiago Martins Vargas
 *
 */
public class Corporation extends Person {

    private String companyIdentificationNumber; // company identification number used for tax paying purposes // CNPJ (Brazil), CUIT (Argentina), EIN (Employer Identification Number in USA).

    public Corporation() {
    }

    public Corporation(String companyIdentificationNumber, Integer id, String name, String phone, String email, String dateOfBirth) {
        super(id, name, phone, email, dateOfBirth);
        this.companyIdentificationNumber = companyIdentificationNumber;
    }

    public String getCompanyIdentificationNumber() {
        return companyIdentificationNumber;
    }

    public void setCompanyIdentificationNumber(String companyIdentificationNumber) {
        this.companyIdentificationNumber = companyIdentificationNumber;
    }
}
