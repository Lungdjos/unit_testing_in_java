package com.unittestingproject.unittesting.repo;

import com.unittestingproject.unittesting.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(
            "select case when count(p) > 0 then true else false end " +
                    "from Person p " +
                    "where p.id = ?1 "
    )
    Boolean isPersonExistById(long id);
}
