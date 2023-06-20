package de.wwu.wfm.g2.repository;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.wwu.wfm.g2.data.*;
import javax.transaction.Transactional;

public interface CvRepo extends CrudRepository<Cv,Integer>{

	@Transactional
	@Modifying
	@Query("delete from Cv c where c.application.email=:email")
	public void deleteCv(@Param("email")String email);
	
	@Query("select c from Cv c where c.application.email=:email")
	Collection<Cv> findCvbyCandidateEmail(@Param("email")String email);
}
