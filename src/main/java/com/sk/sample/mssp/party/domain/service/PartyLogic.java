package com.sk.sample.mssp.party.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.model.PartyMember;
import com.sk.sample.mssp.party.domain.repository.PartyMemberRepository;
import com.sk.sample.mssp.party.domain.repository.PartyRepository;

@Service("partyLogic")
public class PartyLogic implements PartyService {
	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private PartyMemberRepository partyMemberRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Party findById(Long id) {
		return partyRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Party> findAll() {
		return partyRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Party> findAll(Pageable pageable) {
		return partyRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Party register(Party party) {
		return partyRepository.save(party);
	}

	@Override
	@Transactional
	public PartyMember join(PartyMember partyMember) {
		return partyMemberRepository.save(partyMember);
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional public Party update(Long id, Party newAccount) { Party
	 * oldAccount = partyRepository.findOne(id); if(oldAccount != null) {
	 * BeanUtils.copyProperties(newAccount, oldAccount, "id"); return
	 * partyRepository.save(oldAccount); } else { return null; } }
	 * 
	 * @Override
	 * 
	 * @Transactional public void delete(Long id) { partyRepository.delete(id); }
	 */
}
