package com.sk.sample.mssp.party.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.model.PartyMember;
import com.sk.sample.mssp.party.domain.service.PartyService;

@RestController
@RequestMapping("/v1/parties")
public class PartyRestController implements PartyService {
	@Autowired
	private PartyService partyService;

	@Override
	@GetMapping
	public List<Party> findAll() {
		return partyService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Party findById(@PathVariable("id") Long id) {
		return partyService.findById(id);
	}

	@Override
	@PostMapping
	public Party register(@RequestBody Party party) {
		return partyService.register(party);
	}

	@Override
	@PostMapping("/join")
	public PartyMember join(@RequestBody PartyMember partyMember) {
		return partyService.join(partyMember);
	}

	@Override
	@PutMapping("/{id}")
	public Party update(@PathVariable("id") Long id, @RequestBody Party party) {
		return partyService.update(id, party);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		partyService.delete(id);
	}
	
	@Override
	//@GetMapping
	public Page<Party> findAll(Pageable pageable) {
		return partyService.findAll(pageable); 
	}


}
