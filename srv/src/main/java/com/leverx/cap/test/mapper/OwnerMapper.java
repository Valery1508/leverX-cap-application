package com.leverx.cap.test.mapper;

import cds.gen.com.leverx.cap.test.Owners;
import com.leverx.cap.test.dto.request.OwnerCreateRequestDto;
import org.mapstruct.Mapping;

/**
 * @author Valeryia Zubrytskaya
 */

public class OwnerMapper {

    @Mapping(target = "id", ignore = true)
    public Owners toEntity(OwnerCreateRequestDto ownerCreateRequestDto){
        Owners owner = Owners.create();
        owner.setId(ownerCreateRequestDto.get);
        owner.setFirstName(ownerCreateRequestDto.getFirstName());
        owner.setLastName(ownerCreateRequestDto.getLastName());
        return owner;
    }
}
