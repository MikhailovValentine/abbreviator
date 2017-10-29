package ru.urlshortening.abbreviator.repository;

import org.springframework.data.repository.CrudRepository;
import ru.urlshortening.abbreviator.models.URLAbbreviation;

public interface URLRepository extends CrudRepository<URLAbbreviation, String> {

    URLAbbreviation findByShortURL(String shortURL);

}
