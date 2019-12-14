package com.ahmedomer.javaspring.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedomer.javaspring.relationships.models.License;
import com.ahmedomer.javaspring.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	///add a license\\
	public License createLicense(License card) {
		return licenseRepository.save(card);
	}
	///retrieve a license\\\
	public License findLicense(long id) {
		Optional <License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		}
		else {
			return null;
		}
	}
	public static int licenseNumber;
	
	public static int getLicenseNumber() {
		return licenseNumber;
	}
	public static void setLicenseNumber(int licenseNumber) {
		LicenseService.licenseNumber = licenseNumber;
	}
	public String stringLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	public String generateLicenseNumber() {
		if(licenseRepository.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber +=1;
			return stringLicenseNumber(licenseNumber);
		}
		else {
			List<License> top = licenseRepository.findTopByOrderByNumberDesc();
			licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
			return stringLicenseNumber(licenseNumber);
		}
	}
}
