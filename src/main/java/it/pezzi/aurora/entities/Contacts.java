package it.pezzi.aurora.entities;

import javax.persistence.*;

@Entity
@Table(
        name = "contacts",
        catalog = "test",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = { "CONTACTID", "FIRSTNAME", "LASTNAME", "ADDRESS" }
        )}
)
public class Contacts {
    private Long contactId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(
            name = "CONTACTID",
            nullable = false
    )
    public Long getContactId() {
        return this.contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    private String firstname;

    @Column(
            name = "FIRSTNAME",
            nullable = false,
            length = 45
    )
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private String lastname;

    @Column(
            name = "LASTNAME",
            nullable = false,
            length = 45
    )
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private String address;

    @Column(
            name = "ADDRESS",
            length = 45
    )
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
