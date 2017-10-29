package ru.urlshortening.abbreviator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter
//                mappingJackson2HttpMessageConverter =
//                new MappingJackson2HttpMessageConverter();
//        mappingJackson2HttpMessageConverter.setPrettyPrint(true);
//        mappingJackson2HttpMessageConverter.setDefaultCharset
//                (StandardCharsets.UTF_8);
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
//        return mappingJackson2HttpMessageConverter;
//    }
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objMapper = new ObjectMapper();
//        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        objMapper.setSerializationInclusion
//                (JsonInclude.Include.NON_NULL);
//        return objMapper;
//    }
//
//    @Override
//    public void configureMessageConverters(
//            List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        converters.add(mappingJackson2HttpMessageConverter());
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/test/**")
//                .setCacheControl(CacheControl.noCache());
//    }

}
