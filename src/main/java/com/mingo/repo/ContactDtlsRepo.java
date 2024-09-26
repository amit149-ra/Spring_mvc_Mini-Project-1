package com.mingo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mingo.entity.ContactDetails;
@Repository
public interface ContactDtlsRepo extends CrudRepository<ContactDetails, Integer> {

}
