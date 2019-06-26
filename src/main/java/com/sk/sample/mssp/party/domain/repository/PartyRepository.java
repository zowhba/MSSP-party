package com.sk.sample.mssp.party.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.mssp.party.domain.model.Party;

@RepositoryRestResource
public interface PartyRepository extends PagingAndSortingRepository<Party, Long>,
                                           QueryDslPredicateExecutor<Party> {
	
	List<Party> findByNameLike(@Param("name") String name);
	List<Party> findAll();
	
	List<Party> findAll(Predicate predicate); 
	
}
