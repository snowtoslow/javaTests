package com.javaTests.smoketests;


import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SpringRunner.class)
@ActiveProfiles("prod")
@AllArgsConstructor
//now is not working 17.01.20 18:10
//test your existing datasource schema_name = *NAME OF YOUR MAGIC SCHEMA
public class DataStoreHealthTest {

    @Autowired
    private DataSource dataSource;



    @Test
    public void dbPrimaryIsOk(){



        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            Assert.assertThat(metaData,is(equalTo(notNullValue())));

            Assert.assertThat(catalogName,is("fortest"));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
