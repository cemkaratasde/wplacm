package de.wwu.wfm.g2.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.wwu.wfm.g2.data.*;
import de.wwu.wfm.g2.repository.*;

@Controller
public class FormController {
	
	@Autowired
	JobSheetRepo jobSheetRepo;
	
	@Autowired
	CvRepo cvRepo;
	
	@Autowired
	QualificationRepo qualificationRepo;
	
	@Autowired
	CertificateRepo certificaterepo;
	
	@Autowired
	ApplicationRepo applicationRepo;
		
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	private Jobsheet job;
	private Application foundCandidate;
	
	@GetMapping("/apply/{jobsheetId}")
	public String apply(@PathVariable Integer jobsheetId,Model model){
		job = jobSheetRepo.findById(jobsheetId).get();
		model.addAttribute("jobsheet",job);
		model.addAttribute("application",new Application());
		model.addAttribute("cv", new Cv());
		return "apply";
	}
	
	@PostMapping("/apply")
	public String employeeApplication(@ModelAttribute Application application, Cv cv, Jobsheet jobsheet, Model model) {
		application.setJobsheet(job);
		applicationRepo.save(application);
		cvRepo.save(cv);
		applicationRepo.save(application);
		
		LocalDateTime now = LocalDateTime.now();
		application.setAppliedOn(now);
		applicationRepo.save(application);
		
		String[] certificateList= application.getCertificates();
		application.setCertificates(certificateList);
		System.out.println(Arrays.toString(certificateList));
		
		String[] qualificationList= application.getQualifications();
		application.setQualifications(qualificationList);
		
		applicationRepo.save(application);
		return "applicationsuccessfull";
		
	}
	
}
