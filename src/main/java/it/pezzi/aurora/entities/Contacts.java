package it.pezzi.aurora.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        name = "contacts",
        catalog = "test_db",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"CODE"}
        )}
)
public class Contacts {
    private String code;

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
