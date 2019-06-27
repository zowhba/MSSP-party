package com.sk.sample.mssp.party.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.mssp.party.application.proxy.dto.account.Account;
import com.sk.sample.mssp.party.application.proxy.feign.AccountProxy;
import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.model.PartyMember;
import com.sk.sample.mssp.party.domain.service.PartyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/parties")
public class PartyRestController implements PartyService {
	@Autowired
	private PartyService partyService;
	
	@Autowired
	private AccountProxy accountProxy;
	
	@Override
	@ApiOperation(value = "등록된 모든 파티 정보 조회")
    @GetMapping
	public List<Party> findAll() {
		return partyService.findAll(); 
	}
	
	@Override
	@ApiOperation(value = "특정 파티 정보 조회")
	@GetMapping("/{id}")
	public Party findById(@PathVariable("id") Long id) {
		return partyService.findById(id);
	}

	@Override
	@ApiOperation(value = "파티 등록")
	@PostMapping
	public Party register(@RequestBody Party party) {
		return partyService.register(party);
	}

	@Override
	@ApiOperation(value = "파티 가입")
	@PostMapping("/join")
	public PartyMember join(@RequestBody PartyMember partyMember) {
		Account account = accountProxy.findAccounByUserId(partyMember.getUserId());
		PartyMember result = null;
		if (account != null) {
			result = partyService.join(partyMember);
			System.out.println("Buyer: " + account.toString());
		}
		
		return result;
	}

	/*
	 * @Override
	 * 
	 * @PutMapping("/{id}") public Party update(@PathVariable("id") Long
	 * id, @RequestBody Party party) { return partyService.update(id, party); }
	 * 
	 * @Override
	 * 
	 * @DeleteMapping("/{id}") public void delete(@PathVariable("id") Long id) {
	 * partyService.delete(id); }
	 */
	
	@Override
	@ApiOperation(value = "등록된 모든 파티 정보 조회")
	//@GetMapping
	public Page<Party> findAll(Pageable pageable) {
		return partyService.findAll(pageable); 
	}


}
