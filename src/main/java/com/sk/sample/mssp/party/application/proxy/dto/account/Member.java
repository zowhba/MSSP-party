package com.sk.sample.mssp.party.application.proxy.dto.account;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.mssp.shared.base.AbstractEntity;
import com.sk.sample.mssp.shared.base.AggregateRoot;
import com.sk.sample.mssp.shared.domain.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Member extends AbstractEntity implements AggregateRoot {
	private String email;
	private String name;
	
	private String userId;
	private String password;
	private String telephone;
	
	
	@Enumerated(EnumType.ORDINAL)
	private MemberType memberType;
	
	private Address address;
		
	public Member(String userId, String password, String email, String name, String telephone) {
		this.name=name;
		this.email = email;
		this.telephone = telephone;
		this.userId=userId;
		this.password=password;

	}
}

