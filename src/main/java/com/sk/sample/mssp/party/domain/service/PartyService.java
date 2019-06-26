package com.sk.sample.mssp.party.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.model.PartyMember;

public interface PartyService {
	Party findById(Long id);
	List<Party> findAll();
	Page<Party> findAll(Pageable pageable);
	
	Party register(Party party);
	Party update(Long id, Party party);

	void delete(Long id);
	PartyMember join(PartyMember partyMember);
}
