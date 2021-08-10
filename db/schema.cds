namespace sap.capire.petsService;

using { Currency, cuid, managed, sap.common.CodeList } from '@sap/cds/common';

using { Currency, cuid, managed } from '@sap/cds/common';
using { sap.capire.products.Products} from '@sap/capire-products';

entity Books as projection on Products; extend Products with {
 // Note: we map Books to Products to allow reusing AdminService as is
 author : Association to Authors;
 }

entity Authors : cuid {
firstname : String(111);
lastname  : String(111);
books     : Association to many Books on books.author = $self;
}

@Capabilities.Updatable: false
entity Orders : cuid, managed {
items    : Composition of many OrderItems on items.parent = $self;
total    : Decimal(9,2) @readonly;
currency : Currency;
}

@Capabilities.Updatable: false
entity OrderItems : cuid {
parent    : Association to Orders not null;
book_ID   : UUID;
amount    : Integer;
netAmount : Decimal(9,2) @readonly;
}


///////// --my--
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

entity Cats : cuid {    //todo
    hasWool: Boolean;
}

entity Dogs : cuid {    //todo
    hasBreed : Boolean;
}

type PetType : String enum {    //todo
    Cat; Dog;     // или просто cat; dog; ??
}


/*
entity Products : cuid, managed {
    title    : localized String(111);
    descr    : localized String(1111);
    stock    : Integer;
    price    : Decimal(9,2);
    currency : Currency;
    category : Association to Categories;
}

entity Categories : CodeList {
    key ID   : Integer;
    parent   : Association to Categories;
    children : Composition of many Categories on children.parent = $self;
}*/
