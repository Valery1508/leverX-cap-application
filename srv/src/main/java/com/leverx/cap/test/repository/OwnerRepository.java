package com.leverx.cap.test.repository;

import cds.gen.com.leverx.cap.test.Owners;

import java.util.Optional;

/**
 * @author Valeryia Zubrytskaya
 */
public interface OwnerRepository {

    Owners save(Owners ownerToSave);

    Optional<Owners> findById(String id);

    boolean ownerByIdExists(String id);

    long deleteById(String id);

}
