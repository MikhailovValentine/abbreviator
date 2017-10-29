package ru.urlshortening.abbreviator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.urlshortening.abbreviator.models.URLAbbreviation;
import ru.urlshortening.abbreviator.repository.URLRepository;
import ru.urlshortening.abbreviator.service.AddNewURLAbbreviation;
import ru.urlshortening.abbreviator.service.URLAbbreviatorService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Validated
@Service
public class MultistorageURLAbbreviatorStorage implements URLAbbreviatorService, AddNewURLAbbreviation {

    @Autowired
    private URLRepository storage;

    @Override
    public void addURLAbbreviation(URLAbbreviation abbreviation) {
        throw new NotImplementedException();
    }

    @Override
    public String getURLForAbbreviation(String shortURL) {
        return storage.findByShortURL(shortURL).getRealURL();
    }
}
