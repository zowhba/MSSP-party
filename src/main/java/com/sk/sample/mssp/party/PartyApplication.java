package com.sk.sample.mssp.party;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.model.PartyMember;
import com.sk.sample.mssp.party.domain.repository.PartyMemberRepository;
import com.sk.sample.mssp.party.domain.repository.PartyRepository;

@EnableFeignClients
@SpringBootApplication
public class PartyApplication {
	public static void main(String[] args) {
		SpringApplication.run(PartyApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(PartyRepository partyRepository, PartyMemberRepository partyMemberRepository) {	
		return (args) -> {
			insertParty(partyRepository, partyMemberRepository);
			displayParty(partyRepository);
			displayPartyMember(partyMemberRepository);
			
			//executeExample1(partyRepository);
		};
	}
		
	public void insertParty(PartyRepository partyRepository, PartyMemberRepository partyMemberRepository) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, 3);
		
		Party party1 = new Party("NetFlix 3개월 구독방", "kdHong", 3L, new Date(), cal.getTime());
		partyRepository.save(party1);
		
		Party party2 = new Party("Watcha 6개월 구독방", "hdKang", 5L, new Date(), cal.getTime());
		partyRepository.save(party2);
		
		PartyMember partyMember = new PartyMember(party1.getId(), "gcKang");
		partyMemberRepository.save(partyMember);
		
		PartyMember partyMember2 = new PartyMember(party1.getId(), "jhSung");
		partyMemberRepository.save(partyMember2);
		
		PartyMember partyMember3 = new PartyMember(party2.getId(), "jhSung");
		partyMemberRepository.save(partyMember3);
	}
	
	public void displayParty(PartyRepository partyRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Party> partyList = partyRepository.findAll();
		for(Party party : partyList) {
			System.out.println(party.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	public void displayPartyMember(PartyMemberRepository partyMemberRepository) {
		System.out.println("***************************************************************");
		
		Iterable<PartyMember> partyMemberList = partyMemberRepository.findAll();
		for(PartyMember partyMember : partyMemberList) {
			System.out.println(partyMember.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	/*public void executeExample1(PartyRepository partyRepository) {
		Party party = partyRepository.findByEmail("hong@sk.com");
		
		party.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		partyRepository.save(party);
		
		displayParty(partyRepository);
	}
	
	public void executeExample2(PartyRepository partyRepository) {
		List<Party> party = partyRepository.findByAddressZipCode(12345);
		System.out.println("Result: " + party.toString());
	}
	
	public void executeExample3(PartyRepository partyRepository) {
		List<Party> party = partyRepository.findByAddressHomeAddressLike("성남");
		System.out.println("Result: " + party.toString());
	}
	
	public void executeExample4(PartyRepository partyRepository) {
		QParty.party.name.like("강%");
		Party party = partyRepository.findOne(QParty.party.email.eq("hong@sk.com"));
		
		party.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		partyRepository.save(party);
		
		displayParty(partyRepository);
	}
	
	public void executeExample5(PartyRepository partyRepository) {
		List<Party> party = partyRepository.findAll(QParty.party.address.zipCode.eq(12345));
		System.out.println("Result: " + party.toString());
	}
	
	public void executeExample6(PartyRepository partyRepository) {
		List<Party> party = partyRepository.findAll(QParty.party.address.homeAddress.like("성남"));
		System.out.println("Result: " + party.toString());
	}
	
	public void executeExample7(PartyRepository partyRepository) {
		Predicate predicate = QParty.party.memberType.eq(MemberType.BUYER).and(
				              QParty.party.membershipLevelType.eq(MembershipLevelType.VIP));
		List<Party> party = partyRepository.findAll(predicate);
		System.out.println("Result: " + party.toString());
	}*/
	
	/*
	@Bean
	public CommandLineRunner execSampleCode2(@Qualifier("partyLogic") AccountService partyService) {
		return (args) -> {
			Account party = new Account("iu@sk.com", "아이유", MemberType.BUYER, MembershipLevelType.VIP);
			partyService.register(party);
			
			Account result = partyService.findByEmail("iu@sk.com");
			System.out.println("Component API Result - " + result);
			
			result.setAddress(new Address(11111, "서울시 영등포구"));
			partyService.update(result.getId(), result);
			
			Account result2 = partyService.findByEmail("iu@sk.com");
			System.out.println("Component API Result2 - " + result2);
		};
	}
	*/
}
