package it.pezzi.aurora.entities;

import javax.persistence.*;

@Entity
@Table(
        name = "contacts",
        catalog = "test",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"CODE"}
        )}
)
public class Contacts {
    private String code;

    @Id
    @Column(
            name = "CODE",
            nullable = false,
            length = 32
    )
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
