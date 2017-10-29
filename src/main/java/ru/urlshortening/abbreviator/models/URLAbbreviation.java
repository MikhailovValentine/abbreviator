package ru.urlshortening.abbreviator.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.urlshortening.abbreviator.service.validator.CheckURLAbbreviation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@CheckURLAbbreviation
@Entity
@Table(name = "url_dict", schema = "public")
public class URLAbbreviation {

    @Id
    @Column(name = "short_url")
    private String shortURL;
    @Column(name = "long_url")
    private String realURL;
}
