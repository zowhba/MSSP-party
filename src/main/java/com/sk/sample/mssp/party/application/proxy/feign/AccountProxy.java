package com.sk.sample.mssp.party.application.proxy.feign;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.sample.mssp.party.application.proxy.dto.account.Member;

@Service
public class AccountProxy {
	
	  @Autowired private AccountClient accountClient;
	  
	  public Member findAccount(Long id) { return
	  accountClient.findAccount(id).getContent(); }
	  
	  public Collection<Member> findAllAccounts() { return
	  accountClient.findAllAccounts().getContent(); }
	  
	  public Collection<Member> findAllAccounts(int size) { return
	  accountClient.findAllAccounts(size).getContent(); }
	  
	  public Member findAccounByName(String name) { return
	  accountClient.findAccount(name); }
	  
	  public Member findAccounByUserId(String userId) { return
	  accountClient.findAccountByUserId(userId); }
	 
	
	@FeignClient(name="members", url="http://13.124.104.113:11001", configuration=FeignClientConfiguration.class)
	interface AccountClient {
		@GetMapping("members/{id}")
		Resource<Member> findAccount(@PathVariable("userId") Long id);
		
		@GetMapping("members")
		Resources<Member> findAllAccounts();
		
		@GetMapping("members")
		Resources<Member> findAllAccounts(@RequestParam("size") int size);
		
		@GetMapping("members/search/userId")
		Member findAccountByUserId(@RequestParam(value="userId", required=true) String userId);
		
		@GetMapping("members/search/name")
		Member findAccount(@RequestParam(value="name", required=true) String name);
	}
}
