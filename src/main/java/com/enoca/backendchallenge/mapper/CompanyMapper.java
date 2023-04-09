package com.enoca.backendchallenge.mapper;

import com.enoca.backendchallenge.dto.request.CompanyRequestDto;
import com.enoca.backendchallenge.dto.response.CompanyResponseDto;
import com.enoca.backendchallenge.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
    Company toCompany(CompanyRequestDto dto);
    Company toCompany(CompanyResponseDto dto);
    CompanyResponseDto toCompanyResponseDto(Company company);
    CompanyRequestDto toCompanyRequestDto(Company company);
    List<CompanyResponseDto> toCompanyResponseDtoList(List<Company> companies);
}