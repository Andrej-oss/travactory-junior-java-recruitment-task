package com.travactory.recruitment.junior.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private Date dateOfBirth;

    public String getFirstName() {
        return this.firstName;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGender() {
        String genderFullName;
        switch (this.gender) {
            case "F":
                genderFullName = "Female";
                break;
            case "M":
                genderFullName = "Male";
                break;
            default:
                genderFullName = "Unknown gender " + this.gender;
        }
        return genderFullName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
}
