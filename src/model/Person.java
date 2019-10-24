package model;

import java.io.Serializable;

/**
 *
 * @author Tiago Martins Vargas
 * 
 */
public abstract class Person implements Serializable {
    protected Integer id;
    protected String name;
    protected String phone;
    protected String email;
    protected String dateOfBirth;

    public Person() {
    }
    
    public Person(Integer id, String name, String phone, String email, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
