package ru.urlshortening.abbreviator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.urlshortening.abbreviator.service.URLAbbreviatorService;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@CacheDefaults(cacheName = "urls")
@Controller
public class UrlResolverController {

    @Autowired
    private URLAbbreviatorService abbreviatorService;

    @CacheResult
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @GetMapping(value = "/test/{shortURL}")
    public void redirectToLongURL(@PathVariable String shortURL, final HttpServletResponse response) {
        response.setHeader("Date", LocalDateTime.now().toString());
        response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        response.setHeader("Location", "http://" + abbreviatorService.getURLForAbbreviation(shortURL));
        response.setStatus(301);
    }
}
