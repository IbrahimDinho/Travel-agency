package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer>{
	
	@Query("from Tour t left join fetch t.comments where t.id = :id")
	public Tour getByIdwithComments(@Param("id") int id);
}
