package ru.urlshortening.abbreviator.service.validator;

import org.junit.Test;
import ru.urlshortening.abbreviator.models.URLAbbreviation;

import static org.junit.Assert.*;

public class URLAbbreviationValidatorTest {

    private URLAbbreviationValidator validator = new URLAbbreviationValidator();

    @Test
    public void isValid() throws Exception {
        assertNotNull(validator);

        assertFalse(validator.isValid(new URLAbbreviation("", ""), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "dffdgfd"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "www.dffdgfd"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "www.dffdgfd.com"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "dffdgfd.com"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "dffdgfd.com/"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "dffdgfd.com/dgdf"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "ftp://dffdgfd.com"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "ftp://dffdgfd.com/"), null));
        assertFalse(validator.isValid(new URLAbbreviation("", "ftp://dffdgfd.com/dfgd"), null));


        assertTrue(validator.isValid(new URLAbbreviation("", "http://dffdgfd.com"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "http://dffdgfd.com/dfgd"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "http://dffdgfd.com/2343"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "http://dffdgfd.com/2-343ghj"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "https://www.google.ru/search?newwindow=1&q=test"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "https://яндекс.рф"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "https://яндекс.рф/search/?lr=65&msid=150861"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "http://ko.wikipedia.org/wiki/위키백과:대문"), null));
        assertTrue(validator.isValid(new URLAbbreviation("", "http://stackoverflow.com/questions/2742852/これは、これを日本語のテキストです"), null));

    }

}