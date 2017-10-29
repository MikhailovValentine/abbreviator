package ru.urlshortening.abbreviator.service;

import org.springframework.validation.annotation.Validated;
import ru.urlshortening.abbreviator.models.URLAbbreviation;

import javax.validation.Valid;

@Validated
public interface AddNewURLAbbreviation {
    void addURLAbbreviation(@Valid URLAbbreviation abbreviation);
}
