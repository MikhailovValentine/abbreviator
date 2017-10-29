package ru.urlshortening.abbreviator.config;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import static java.util.concurrent.TimeUnit.SECONDS;

@EnableCaching
@Configuration
public class CacheConfiguration {

    @Bean
    public JCacheManagerCustomizer cacheManager() {
        return cacheManager -> cacheManager.createCache("urls", new MutableConfiguration<>()
                .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 10)))
                .setStoreByValue(false)
                .setStatisticsEnabled(true));
    }

}
