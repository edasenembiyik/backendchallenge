package com.enoca.backendchallenge.service;

import com.enoca.backendchallenge.dto.request.CompanyRequestDto;
import com.enoca.backendchallenge.dto.request.EmployeeRequestDto;
import com.enoca.backendchallenge.dto.response.CompanyResponseDto;
import com.enoca.backendchallenge.dto.response.EmployeResponseDto;
import com.enoca.backendchallenge.exception.ChallengeException;
import com.enoca.backendchallenge.exception.ErrorType;
import com.enoca.backendchallenge.mapper.CompanyMapper;
import com.enoca.backendchallenge.mapper.EmployeeMapper;
import com.enoca.backendchallenge.repository.EmployeeRepository;
import com.enoca.backendchallenge.repository.entity.Company;
import com.enoca.backendchallenge.repository.entity.Employee;
import com.enoca.backendchallenge.repository.enums.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeResponseDto addEmployee(EmployeeRequestDto dto, Gender gender) {
        try {
            Employee employee=EmployeeMapper.INSTANCE.toEmployee(dto);
            employee.setGender(gender);
            employee = employeeRepository.save(employee);
          return EmployeeMapper.INSTANCE.toEmployeResponseDto(employee);
        } catch (Exception e) {
            throw new ChallengeException(ErrorType.EMPYOLEE_NOT_CREATED);
        }
    }

    public EmployeResponseDto findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return EmployeeMapper.INSTANCE.toEmployeResponseDto(employee.get());
        } else {
            throw new ChallengeException(ErrorType.EMPYOLEE_NOT_FOUND);
        }
    }

    public List<Employee> findAll() {
            List<Employee> employeeList = employeeRepository.findAll();
            if(employeeList.size()==0)
                throw new ChallengeException(ErrorType.EMPYOLEE_NOT_FOUND);
            return employeeList;
    }


    public Boolean deleteEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            throw new ChallengeException(ErrorType.EMPLOYEE_NOT_DELETED);
        }
    }

    public EmployeResponseDto updateEmployee(EmployeeRequestDto dto, Long id) {
        try {
            Employee employee = employeeRepository.findById(id).get();
            employee.setAdress(dto.getAdress());
            employee.setName(dto.getName());
            employee.setSurname(dto.getSurname());
            employeeRepository.save(employee);
            return EmployeeMapper.INSTANCE.toEmployeResponseDto(employee);
        } catch (Exception e) {
            throw new ChallengeException(ErrorType.EMPYOLEE_NOT_UPDATED);
        }
    }

}
