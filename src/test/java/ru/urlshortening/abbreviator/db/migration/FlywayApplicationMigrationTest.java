package ru.urlshortening.abbreviator.db.migration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FlywayApplicationMigrationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test_script_V1__init() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet table = connection.getMetaData()
                    .getTables(null,
                            null,
                            "URL_DICT", null);

            assertTrue(table.next());
        }
    }

    @Test
    public void test_script_V1_1__add_test_data() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM url_dict")) {
                try(ResultSet resultSet = ps.executeQuery();) {
                    assertTrue(resultSet.next());
                }
            }
        }
    }

}
