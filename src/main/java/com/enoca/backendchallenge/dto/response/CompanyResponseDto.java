package com.enoca.backendchallenge.dto.response;

import com.enoca.backendchallenge.repository.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponseDto {
    private Long id;
    private String name;
    private String sector;
    private String address;
 private List<Employee> employees;
}
