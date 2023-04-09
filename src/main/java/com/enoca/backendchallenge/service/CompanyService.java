package com.enoca.backendchallenge.service;

import com.enoca.backendchallenge.dto.request.*;
import com.enoca.backendchallenge.dto.response.*;
import com.enoca.backendchallenge.exception.ChallengeException;
import com.enoca.backendchallenge.exception.ErrorType;
import com.enoca.backendchallenge.mapper.CompanyMapper;
import com.enoca.backendchallenge.repository.CompanyRepository;
import com.enoca.backendchallenge.repository.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    public CompanyResponseDto createCompany(CompanyRequestDto dto) {
        Company company;
        try {
            company = companyRepository.save(CompanyMapper.INSTANCE.toCompany(dto));
        } catch (Exception e) {
            throw new ChallengeException(ErrorType.COMPANY_NOT_CREATED);
        }
        return CompanyMapper.INSTANCE.toCompanyResponseDto(company);
    }
    public CompanyResponseDto updateCompany(CompanyRequestDto dto, Long id) {
        Company company=companyRepository.findById(id).get();
        try {
            company.setAddress(dto.getAddress());
            company.setName(dto.getName());
            company.setSector(dto.getSector());
            companyRepository.save(company);
            return CompanyMapper.INSTANCE.toCompanyResponseDto(company);
        } catch (Exception e) {
            throw new ChallengeException(ErrorType.COMPANY_NOT_UPDATED);
        }
    }

    public CompanyResponseDto findCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            return CompanyMapper.INSTANCE.toCompanyResponseDto(company.get());
        } else {
            throw new ChallengeException(ErrorType.COMPANY_NOT_FOUND);
        }
    }

    public Boolean deleteCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            companyRepository.deleteById(id);
            return true;
        } else {
            throw new ChallengeException(ErrorType.COMPANY_NOT_DELETED);
        }
    }
    public List<Company> findAllCompanies() {
       return companyRepository.findAll();


    }
}
