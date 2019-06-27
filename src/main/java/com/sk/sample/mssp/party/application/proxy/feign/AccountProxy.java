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

import com.sk.sample.mssp.party.application.proxy.dto.account.Account;

@Service
public class AccountProxy {
	
	  @Autowired private AccountClient accountClient;
	  
	  public Account findAccount(Long id) { return
	  accountClient.findAccount(id).getContent(); }
	  
	  public Collection<Account> findAllAccounts() { return
	  accountClient.findAllAccounts().getContent(); }
	  
	  public Collection<Account> findAllAccounts(int size) { return
	  accountClient.findAllAccounts(size).getContent(); }
	  
	  public Account findAccounByName(String name) { return
	  accountClient.findAccount(name); }
	  
	  public Account findAccounByUserId(String userId) { return
	  accountClient.findAccountByUserId(userId); }
	 
	
	@FeignClient(name="members", url="http://13.124.104.113:11001", configuration=FeignClientConfiguration.class)
	interface AccountClient {
		@GetMapping("members/{id}")
		Resource<Account> findAccount(@PathVariable("userId") Long id);
		
		@GetMapping("members")
		Resources<Account> findAllAccounts();
		
		@GetMapping("members")
		Resources<Account> findAllAccounts(@RequestParam("size") int size);
		
		@GetMapping("members/search/userId")
		Account findAccountByUserId(@RequestParam(value="userId", required=true) String userId);
		
		@GetMapping("members/search/name")
		Account findAccount(@RequestParam(value="name", required=true) String name);
	}
}
