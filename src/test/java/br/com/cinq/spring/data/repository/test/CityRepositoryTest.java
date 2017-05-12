package br.com.cinq.spring.data.repository.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.application.City;
import br.com.cinq.spring.data.sample.application.CityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootApplication
@ActiveProfiles("unit")
public class CityRepositoryTest {

    @Autowired
    private CityRepository dao;

    @Test
    public void testQueryPerson() {
        Assert.assertNotNull(dao);
        Assert.assertTrue(dao.count()>0);
        Long id = 3L; //Should be France
        List<City> list = dao.findByCountryId(id);
        Assert.assertEquals(2, list.size());
    }
}
