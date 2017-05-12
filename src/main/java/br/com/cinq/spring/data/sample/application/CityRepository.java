package br.com.cinq.spring.data.sample.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query(value = "select * from City c join Country co on c.country_id = co.id where co.name like CONCAT_WS('%',:name, '%')", nativeQuery = true) 
	List<City> findByCountry(@Param("name") String name);
	
	@Query(value = "select * from City c where c.country_id = :id", nativeQuery = true)
	List<City> findByCountryId(@Param("id") Long id);
	
	
}
