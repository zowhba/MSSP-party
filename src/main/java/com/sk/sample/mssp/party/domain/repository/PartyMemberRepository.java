package com.sk.sample.mssp.party.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.mssp.party.domain.model.PartyMember;

@RepositoryRestResource
public interface PartyMemberRepository extends PagingAndSortingRepository<PartyMember, Long>,
                                           QueryDslPredicateExecutor<PartyMember> {
	
	List<PartyMember> findAll();
	
	List<PartyMember> findAll(Predicate predicate); 
	
	List<PartyMember> findById(@Param("partyId") Long partyId);
	
}
