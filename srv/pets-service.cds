using { com.leverx.cap.test as db } from '../db/schema';

service PetsService {

    entity Pets as projection on db.Pets;

    entity Owners as projection on db.Owners;

    entity CatsPetsView as
        select from db.Cats {
            Cats.ID,
            Cats.hasWool,
            Cats.pet,
            Cats.pet.name,
            Cats.pet.petType,
            Cats.pet.owner
        };

    entity DogsPetsView as
        select from db.Dogs {
            Dogs.ID,
            Dogs.hasBreed,
            Dogs.pet,
            Dogs.pet.name,
            Dogs.pet.petType,
            Dogs.pet.owner
        };

}