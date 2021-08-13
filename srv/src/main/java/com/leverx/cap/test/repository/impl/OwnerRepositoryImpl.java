package com.leverx.cap.test.repository.impl;

import cds.gen.com.leverx.cap.test.Owners;
import cds.gen.com.leverx.cap.test.Owners_;
import com.leverx.cap.test.repository.OwnerRepository;
import com.sap.cds.ql.Insert;
import com.sap.cds.ql.cqn.CqnInsert;
import com.sap.cds.services.persistence.PersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Valeryia Zubrytskaya
 */
@RequiredArgsConstructor
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

    private final PersistenceService db;

    @Override
    public Owners save(Owners ownerToSave) {
        CqnInsert insertNewOwner = Insert.into(Owners_.CDS_NAME).entry(ownerToSave);

        return db.run(insertNewOwner).single(Owners.class);
    }

    @Override
    public Optional<Owners> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean ownerByIdExists(String id) {
        return false;
    }

    @Override
    public long deleteById(String id) {
        return 0;
    }
}
