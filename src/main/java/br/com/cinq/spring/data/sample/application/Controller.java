package br.com.cinq.spring.data.sample.application;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@Produces(MediaType.APPLICATION_JSON)
public class Controller {
	
    @Autowired
    private CityRepository cityRepository;	
	
    @GET
    @RequestMapping(value="rest/cities", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
    public Iterable<City> findAll() {
    	return cityRepository.findAll();
    }
    
    //@RequestMapping(value="rest/cities/{country}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
    @RequestMapping(value="rest/cities", params={"country"}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
    public Iterable<City> findByCountry(@RequestParam String country) {
    	return cityRepository.findByCountry(country);
    }    
}



/*

http://localhost:8080/rest/cities?country=Brazil    == é o que pedem mas não ta vindo


http://localhost:8080/rest/cities/country=Brazil   == ta vindo certo

*/