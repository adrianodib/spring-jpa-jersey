package br.com.cinq.spring.data.sample.application;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	
	@Query(value = "SELECT * FROM Country co WHERE co.name LIKE (CONCAT_WS('%',:name, '%'))", nativeQuery = true) 
	List<Country> findLikeName(@Param("name") String name);

	List<Country> findAll();
}
