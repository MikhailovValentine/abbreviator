package ru.urlshortening.abbreviator.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "short_url.length=100")
public class Base36ShortURLGeneratorTest {

    @Autowired
    private Base36ShortURLGenerator service;
    @Value("#{T(Integer).parseInt('${short_url.length}')}")
    private int expectedURLLength;

    @Test(timeout = 10_000)
    @Repeat(10)
    public void test() throws Exception {
        assertNotNull(service);

        String generatedNextShortURL = service.generateNextShortURL();
        assertNotNull(generatedNextShortURL);
        assertEquals(generatedNextShortURL.length(), expectedURLLength);

        int size = 100;
        Set<String> collectionOfRandomShortURLs = Stream.generate(() -> service.generateNextShortURL())
                .limit(size).collect(Collectors.toSet());
        assertTrue("Too many dublicates!", collectionOfRandomShortURLs.size() > size - 10);
        if (collectionOfRandomShortURLs.contains(generatedNextShortURL)) {// try again may be unfortunate attempt
            collectionOfRandomShortURLs = Stream.generate(() -> service.generateNextShortURL())
                    .limit(size).collect(Collectors.toSet());
            if (collectionOfRandomShortURLs.contains(generatedNextShortURL))
                fail("Too many dublicates!");
        }
    }
}