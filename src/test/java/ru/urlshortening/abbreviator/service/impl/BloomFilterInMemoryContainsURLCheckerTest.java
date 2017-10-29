package ru.urlshortening.abbreviator.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.urlshortening.abbreviator.models.URLAbbreviation;

import javax.validation.ConstraintViolationException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "contains_element_checker.bloom_filter.expectedInsertions=10000")
public class BloomFilterInMemoryContainsURLCheckerTest {

    @Autowired
    private BloomFilterContainsElementChecker service;

    @Test
    public void testKnownURL() throws Exception {
        assertNotNull(service);

        String shortURL = "xyzrtt";
        service.addURLAbbreviation(new URLAbbreviation(shortURL, "http://test.com"));
        assertFalse(service.noSuchURL(shortURL));
    }

    @Test
    public void testUnKnownURL() throws Exception {
        assertNotNull(service);

        String shortURL = "xyzrer";
        service.addURLAbbreviation(new URLAbbreviation(shortURL, "http://test.com"));
        assertTrue(service.noSuchURL("xyzre2"));
    }

    @Test(expected = ConstraintViolationException.class)
    public void testDoNotCreateInvalidURL() throws Exception {
        assertNotNull(service);

        String shortURL = "xyzrer";
        service.addURLAbbreviation(new URLAbbreviation(shortURL, "test"));
        fail("should be already interrupted with exception");
    }

    @TestPropertySource(properties = "contains_element_checker.bloom_filter.expectedInsertions=1000000000")
    public static class BloomFilterInMemoryContainsURLCheckerTestHugeData
            extends BloomFilterInMemoryContainsURLCheckerTest {
    }
}