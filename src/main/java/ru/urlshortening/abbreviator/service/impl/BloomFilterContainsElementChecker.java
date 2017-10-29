package ru.urlshortening.abbreviator.service.impl;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.urlshortening.abbreviator.models.URLAbbreviation;
import ru.urlshortening.abbreviator.service.AddNewURLAbbreviation;
import ru.urlshortening.abbreviator.service.InMemoryContainsURLChecker;
import ru.urlshortening.abbreviator.service.qualifier.StorageTypeQualifier;

import static ru.urlshortening.abbreviator.service.qualifier.StorageTypeQualifier.Type.IN_MRMORY;

@Service
@StorageTypeQualifier(IN_MRMORY)
public class BloomFilterContainsElementChecker implements InMemoryContainsURLChecker<String>, AddNewURLAbbreviation {

    @Value("#{T(Integer).parseInt('${contains_element_checker.bloom_filter.expectedInsertions}')}")
    private int expectedInsertions = 1000;
    private BloomFilter<String> friends = BloomFilter
            .create(Funnels.stringFunnel(Charsets.UTF_8), expectedInsertions, 0.0001);

    @Override
    public boolean noSuchURL(String url) {
        return !friends.mightContain(url);
    }

    @Override
    public void addURLAbbreviation(URLAbbreviation abbreviation) {
        friends.put(abbreviation.getShortURL());
    }
}
