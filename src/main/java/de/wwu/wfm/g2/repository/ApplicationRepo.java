package de.wwu.wfm.g2.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.wwu.wfm.g2.data.Application;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

public interface ApplicationRepo extends CrudRepository<Application,Integer> {
	
	@Query("SELECT a.email from Application a")
	Collection<String> getEmails();
	
	@Query(value="SELECT a from Application a")
	Collection<Application> getAllAplications();
	
	@Query("select a from Application a where a.email=:email")
	Optional<Application> findCandidateByEmail(@Param("email")String email);
	
	@Query("SELECT a.email, SUM(a.email) from Application a GROUP BY a.email HAVING COUNT(a.email) > 1")
	Collection<String> findDuplicates();
	
	@Transactional
	@Modifying
	@Query("delete from Application a where a.email=:email")
	public void deleteCandidate(@Param("email")String email);
	
}
