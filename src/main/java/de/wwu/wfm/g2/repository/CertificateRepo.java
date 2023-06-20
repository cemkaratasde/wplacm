package de.wwu.wfm.g2.repository;
import javax.persistence.*;
import org.springframework.data.repository.CrudRepository;
import de.wwu.wfm.g2.data.*;

public interface CertificateRepo extends CrudRepository<Certificate,Integer> {

}
