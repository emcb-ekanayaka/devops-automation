package com.inventory.printit.service.impl;

import com.inventory.printit.dto.CompanyDto;
import com.inventory.printit.dto.requestdto.RequestRegistryDto;
import com.inventory.printit.dto.responsedto.CommonResponseDto;
import com.inventory.printit.exception.EntryNotFoundException;
import com.inventory.printit.repo.CompanyRepository;
import com.inventory.printit.service.CompanyService;
import com.inventory.printit.utill.Generator;
import com.inventory.printit.utill.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
}
