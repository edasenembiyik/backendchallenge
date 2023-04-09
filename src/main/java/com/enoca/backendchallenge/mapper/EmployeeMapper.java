package com.enoca.backendchallenge.mapper;

import com.enoca.backendchallenge.dto.request.EmployeeRequestDto;
import com.enoca.backendchallenge.dto.response.EmployeResponseDto;
import com.enoca.backendchallenge.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    @Mapping(source = "companyId", target = "company.id")
    Employee toEmployee(EmployeeRequestDto dto);
    @Mapping(source = "company.id", target = "companyId")

    EmployeResponseDto toEmployeResponseDto(Employee employee);
    EmployeeRequestDto toEmployeRequesteDto(Employee employee);

}
