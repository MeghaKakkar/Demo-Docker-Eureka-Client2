package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.entity.Certificate;
import com.example.demo.repo.CertificateRepo;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
	
	@Autowired
	private CertificateRepo certificateRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path ="/addCert")
	public ResponseEntity<Certificate> addCert(@RequestBody Certificate certificate) {
		
		Certificate certificateAdded = certificateRepo.save(certificate);
		return new ResponseEntity<>(certificateAdded, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getCert/{certificateId}")
	public ResponseEntity<List<Certificate>> getCertificateById(@PathVariable Integer certificateId){
		System.out.println("Certificate Id received : "+certificateId);
		Optional<Certificate> certificate=certificateRepo.findById(certificateId);
		List<Certificate> certificateList=new ArrayList<Certificate>();
		if(certificate.isPresent()) {
			certificateList.add(certificate.get());
		}
		return new ResponseEntity<>(certificateList, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getAllCert")
	public ResponseEntity<List<Certificate>> getAllCertificates() {
		List<Certificate> certificateList = certificateRepo.findAll();
		return new ResponseEntity<>(certificateList, HttpStatus.OK);
	}
	
}
