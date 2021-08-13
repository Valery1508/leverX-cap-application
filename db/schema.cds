namespace com.leverx.cap.test;

using { cuid } from '@sap/cds/common';

type PetType : String enum {
    Cats; Dogs;     // или просто cat; dog; ??
}

entity Owners : cuid {
    firstName : String(111);
    lastName : String(111);
    pets : Association to many Pets on pets.owner = $self;
}

entity Pets : cuid {
    name : String;
    petType : PetType;
    owner : Association to Owners;
}

entity Cats : cuid {
    hasWool: Boolean;
    @assert.unique pet : Composition of Pets;
}

entity Dogs : cuid {
    hasBreed : Boolean;
    @assert.unique pet : Composition of Pets;
}