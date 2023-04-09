package com.enoca.backendchallenge.dto.response;

import com.enoca.backendchallenge.repository.entity.Company;
import com.enoca.backendchallenge.repository.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeResponseDto {
    private String name;
    private String surname;
    private String adress;
    private Long companyId;
    private Gender gender;
}
