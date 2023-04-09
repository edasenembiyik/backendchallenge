package com.enoca.backendchallenge.controller;

import com.enoca.backendchallenge.dto.request.CompanyRequestDto;
import com.enoca.backendchallenge.dto.response.CompanyResponseDto;
import com.enoca.backendchallenge.repository.entity.Company;
import com.enoca.backendchallenge.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.enoca.backendchallenge.constant.Endpoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {
    private final CompanyService companyService;

    @CrossOrigin("*")
    @PostMapping(CREATECOMPANY)
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyRequestDto dto) {
        return ResponseEntity.ok(companyService.createCompany(dto));
    }
    @CrossOrigin("*")
    @PutMapping(UPDATE)
    public ResponseEntity<CompanyResponseDto> updateCompany(@RequestBody CompanyRequestDto dto,@RequestParam Long id) {
        return ResponseEntity.ok(companyService.updateCompany(dto,id));
    }
    @CrossOrigin("*")
    @DeleteMapping(DELETE)
    public  ResponseEntity<Boolean> deleteCompanyById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.deleteCompanyById(id));
    }

    @CrossOrigin("*")
    @GetMapping(FINDALL)
    public ResponseEntity<List<Company>> findAllCompanies() {
        return ResponseEntity.ok(companyService.findAllCompanies());
    }

    @CrossOrigin("*")
    @GetMapping(FINDBYID)
    public ResponseEntity<CompanyResponseDto> findCompanyById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

}