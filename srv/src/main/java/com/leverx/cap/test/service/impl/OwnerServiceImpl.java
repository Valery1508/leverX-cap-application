package com.leverx.cap.test.service.impl;

import cds.gen.com.leverx.cap.test.Owners;
import com.leverx.cap.test.dto.request.OwnerCreateRequestDto;
import com.leverx.cap.test.mapper.OwnerMapper;
import com.leverx.cap.test.repository.OwnerRepository;
import com.leverx.cap.test.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Valeryia Zubrytskaya
 */
@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;

    @Override
    public Owners createOwner(OwnerCreateRequestDto ownerCreateRequestDto) {
        Owners ownerToSave = ownerMapper.toEntity(ownerCreateRequestDto);
        Owners savedOwner = ownerRepository.save(ownerToSave);
        return savedOwner;
    }
}
