package com.leverx.cap.test.service;

import cds.gen.com.leverx.cap.test.Owners;
import com.leverx.cap.test.dto.request.OwnerCreateRequestDto;

/**
 * @author Valeryia Zubrytskaya
 */
public interface OwnerService {

    Owners createOwner(OwnerCreateRequestDto ownerCreateRequestDto);
}
