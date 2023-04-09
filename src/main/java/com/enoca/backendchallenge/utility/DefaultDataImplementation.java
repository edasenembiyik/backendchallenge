package com.enoca.backendchallenge.utility;

import com.enoca.backendchallenge.dto.response.CompanyResponseDto;
import com.enoca.backendchallenge.mapper.CompanyMapper;
import com.enoca.backendchallenge.mapper.EmployeeMapper;
import com.enoca.backendchallenge.repository.CompanyRepository;
import com.enoca.backendchallenge.repository.EmployeeRepository;
import com.enoca.backendchallenge.repository.entity.Company;
import com.enoca.backendchallenge.repository.entity.Employee;
import com.enoca.backendchallenge.repository.enums.Gender;
import com.enoca.backendchallenge.service.CompanyService;
import com.enoca.backendchallenge.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DefaultDataImplementation {
    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @PostConstruct
    private void create() {
        saveDatas();
    }

    private void saveDatas() {

        Company company1 = Company.builder()
                .name("Enoca")
                .sector("Software")
                .address("Turkey")
                .build();
        company1 = companyRepository.save(company1);

        Company company2 = Company.builder()
                .name("Fiat")
                .sector("Otomotiv")
                .address("Italy")
                .build();
        company2 = companyRepository.save(company2);

        Company company3 = Company.builder()
                .name("Vivense")
                .sector("Furnature")
                .address("Denmark")
                .build();
        company3 = companyRepository.save(company3);


        Employee employee = Employee.builder()
                .name("Eda")
                .surname("Biyik")
                .adress("İstanbul")
                .company(company1)
                .gender(Gender.FEMALE)
                .build();
        employeeRepository.save(employee);
        Employee employee1 = Employee.builder()
                .name("Ali")
                .surname("Ak")
                .adress("Ankara")
                .company(company2)
                .gender(Gender.MALE)
                .build();
        employeeRepository.save(employee1);

        Employee employee2 = Employee.builder()
                .name("Esra")
                .surname("Esmer")
                .adress("İzmir")
                .company(company3)
                .gender(Gender.FEMALE)
                .build();
        employeeRepository.save(employee2);

        Employee employee3 = Employee.builder()
                .name("Sena")
                .surname("Tunalı")
                .adress("Adana")
                .company(company2)
                .gender(Gender.FEMALE)
                .build();
        employeeRepository.save(employee3);

        Employee employee4 = Employee.builder()
                .name("Cem")
                .surname("Sever")
                .adress("Giresun")
                .company(company1)
                .gender(Gender.MALE)
                .build();
        employeeRepository.save(employee4);

    }
}
