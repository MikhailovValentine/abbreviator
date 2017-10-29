package ru.urlshortening.abbreviator.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.urlshortening.abbreviator.service.ShortURLGenerator;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class Base36ShortURLGenerator implements ShortURLGenerator {

    public static final char[] ALPHABET = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};
    public static final int ALPHABET_SIZE = 36;

    @Value("#{T(Integer).parseInt('${short_url.length}')}")
    private int urlLength;

    @Override
    public String generateNextShortURL() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder shortURL = new StringBuilder(urlLength);
        for (int i = 0; i < urlLength; i++)
            shortURL.append(ALPHABET[random.nextInt(ALPHABET_SIZE)]);
        return shortURL.toString();
    }
}
