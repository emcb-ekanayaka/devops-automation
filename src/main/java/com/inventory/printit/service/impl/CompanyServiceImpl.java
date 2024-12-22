package com.inventory.printit.service.impl;

import com.inventory.printit.dto.CompanyDto;
import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.dto.responsedto.CompanyResponseDto;
import com.inventory.printit.dto.responsedto.paginated.PaginatedResponseCompanyDto;
import com.inventory.printit.entity.Company;
import com.inventory.printit.exception.EntryNotFoundException;
import com.inventory.printit.repo.CompanyRepository;
import com.inventory.printit.service.CompanyService;
import com.inventory.printit.utill.Generator;
import com.inventory.printit.utill.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private Generator generator;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyRepository companyRepo;

    @Override
    public CommonResponseDto saveCompany(RequestRegistryDto dto) {
        System.out.println("IMPL 1 Data -- " + dto);
        try {
            String companyGenerateNum = "IBM-C" + "-" + generator.generateFourNumbers();
            String comId =  generator.generateFourNumbers();
            CompanyDto companyDto = new CompanyDto(
                    comId,
                    companyGenerateNum,
                    dto.getCompanyName(),
                    dto.getComAddressOne(),
                    dto.getComAddressTwo(),
                    dto.getComAddressThree(),
                    dto.getBrNumber()
            );
            System.out.println("IMPL 2 Data -- " + companyDto);
            System.out.println(companyMapper.dtoToCompanyEntity(companyDto));
            companyRepo.save(companyMapper.dtoToCompanyEntity(companyDto));

            return new CommonResponseDto(201, "Company  saved!", companyDto.getCompanyCode(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public PaginatedResponseCompanyDto allCompany() throws SQLException {
        try {
            List<Company> allCompaniesForProvidedId = companyRepo.findAll();
            List<CompanyResponseDto> companyResponseDto = new ArrayList<>();

            for (Company c : allCompaniesForProvidedId) {
                companyResponseDto.add(
                        new CompanyResponseDto(
                               c.getId(),
                                c.getCompanyCode(),
                                c.getCompanyName(),
                                c.getComAddressOne(),
                                c.getComAddressTwo(),
                                c.getComAddressThree(),
                                c.getBrNumber()
                        )
                );
            }
            return new PaginatedResponseCompanyDto(
                    companyRepo.count(),
                    companyResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }

    @Override
    public PaginatedResponseCompanyDto companyById(String companyId) throws SQLException {
        try {
            List<Company> comObj = companyRepo.getCompany(companyId);
            List<CompanyResponseDto> companyResponseDto = new ArrayList<>();

            for (Company c : comObj) {
                companyResponseDto.add(
                        new CompanyResponseDto(
                                c.getId(),
                                c.getCompanyCode(),
                                c.getCompanyName(),
                                c.getComAddressOne(),
                                c.getComAddressTwo(),
                                c.getComAddressThree(),
                                c.getBrNumber()
                        )
                );
            }
            return new PaginatedResponseCompanyDto(
                    1L,
                    companyResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }

    @Override
    public CommonResponseDto updateCompany(RequestRegistryDto dto, String companyId) {
        try {
            Company companyObj = companyRepo.getById(companyId);
            companyObj.setCompanyName(dto.getCompanyName());
            companyObj.setComAddressOne(dto.getComAddressOne());
            companyObj.setComAddressTwo(dto.getComAddressTwo());
            companyObj.setComAddressThree(dto.getComAddressThree());
            companyObj.setBrNumber(dto.getBrNumber());

            companyRepo.save(companyObj);
            return new CommonResponseDto(201, "Company  Updated!", companyObj.getCompanyCode(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeCompany(String companyId) {
        Optional<Company> company = companyRepo.findById(companyId);
        if (company.isPresent()) {
            companyRepo.delete(company.get());
            return new CommonResponseDto(201, "Company was deleted!", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Student...!");
        }
    }
}
