package com.enoca.backendchallenge.controller;

import com.enoca.backendchallenge.dto.request.CompanyRequestDto;
import com.enoca.backendchallenge.dto.request.EmployeeRequestDto;
import com.enoca.backendchallenge.dto.response.CompanyResponseDto;
import com.enoca.backendchallenge.dto.response.EmployeResponseDto;
import com.enoca.backendchallenge.repository.entity.Employee;
import com.enoca.backendchallenge.repository.enums.Gender;
import com.enoca.backendchallenge.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.enoca.backendchallenge.constant.Endpoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {
    private final EmployeeService employeeService;
    @CrossOrigin("*")
    @PostMapping(ADDEMPLOYEE)
    public ResponseEntity<EmployeResponseDto> addEmployee(@RequestBody EmployeeRequestDto dto, @RequestParam Gender gender) {
        return ResponseEntity.ok(employeeService.addEmployee(dto,gender));
    }
    @DeleteMapping(DELETE)
    public  ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }
    @CrossOrigin("*")
    @GetMapping(FINDBYID)
    public ResponseEntity<EmployeResponseDto> findEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }
    @CrossOrigin("*")
    @GetMapping(FINDALL)
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }
    @CrossOrigin("*")
    @PutMapping(UPDATE)
    public ResponseEntity<EmployeResponseDto> updateEmployee(@RequestBody EmployeeRequestDto dto, @RequestParam Long id) {
        return ResponseEntity.ok(employeeService.updateEmployee(dto,id));
    }
}
