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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/parties")
public class PartyRestController implements PartyService {
	@Autowired
	private PartyService partyService;
	
	//@Autowired
	//private AccountProxy accountProxy;
	
	@Override
	@ApiOperation(value = "등록된 모든 파티 정보 조회")
    @GetMapping
	public List<Party> findAll() {
		return partyService.findAll(); 
	}
	
	@Override
	@ApiOperation(value = "특정 파티 정보 조회")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "파티 고유키", required = true, dataType = "Long", paramType = "path"),
    })
	@GetMapping("/{id}")
	public Party findById(@PathVariable("id") Long id) {
		return partyService.findById(id);
	}

	@Override
	@ApiOperation(value = "파티 등록")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "파티명", required = true, dataType = "String", paramType = "path"),
        @ApiImplicitParam(name = "leaderId", value = "파티 리더 ID", required = true, dataType = "String", paramType = "path"),
        @ApiImplicitParam(name = "numberOfMember", value = "파티원 수", required = true, dataType = "Long", paramType = "path"),
        @ApiImplicitParam(name = "startDate", value = "파티시작일", required = true, dataType = "Date", paramType = "path"),
        @ApiImplicitParam(name = "expireDate", value = "파티종료일", required = true, dataType = "Date", paramType = "path"),
    })
	@PostMapping
	public Party register(@RequestBody Party party) {
		return partyService.register(party);
	}

	@Override
	@ApiOperation(value = "파티 가입")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "partyId", value = "파티고유키", required = true, dataType = "Long", paramType = "path"),
        @ApiImplicitParam(name = "userId", value = "멤버 ID", required = true, dataType = "String", paramType = "path"),
    })
	@PostMapping("/join")
	public PartyMember join(@RequestBody PartyMember partyMember) {
		//Account account = accountProxy.findAccounByUserId(partyMember.getUserId());
		//System.out.println("Buyer: " + account.toString());
		return partyService.join(partyMember);
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
