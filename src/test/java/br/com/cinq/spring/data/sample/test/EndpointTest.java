package br.com.cinq.spring.data.sample.test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.application.City;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class) 
@ActiveProfiles("unit")
public class EndpointTest {

    private final String localhost = "http://localhost:8080";
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetCities() throws InterruptedException {

    	String countryName = "France";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.localhost + "/rest/cities").queryParam("country", countryName);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<City[]> response = this.restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, City[].class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Thread.sleep(2000L);
        City[] cities = response.getBody();
        Assert.assertEquals(2, cities.length);

    }
}

