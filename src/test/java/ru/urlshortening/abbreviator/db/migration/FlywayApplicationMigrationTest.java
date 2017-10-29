package ru.urlshortening.abbreviator.db.migration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FlywayApplicationMigrationTest {

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testDefaultSettings() throws Exception {
        String result = template.queryForObject("SELECT to_regclass('PUBLIC.URL_DICT')",
                String.class);

        assertEquals("url_dict", result);
    }
}
