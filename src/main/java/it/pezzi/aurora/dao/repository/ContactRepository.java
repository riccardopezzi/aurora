package it.pezzi.aurora.dao.repository;

import it.pezzi.aurora.entities.Contacts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactRepository extends CrudRepository{
    Contacts findByCode(String code);
}
