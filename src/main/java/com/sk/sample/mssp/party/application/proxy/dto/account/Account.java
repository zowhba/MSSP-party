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
public class Account extends AbstractEntity implements AggregateRoot {
	private String email;
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	private MemberType memberType;
	
	@Enumerated(EnumType.STRING)
	private MembershipLevelType membershipLevelType;
	
	private Address address;
	
	public Account(String email, String name, MemberType memberType) {
		this(email, name, memberType, MembershipLevelType.SILVER);
	}
	
	public Account(String email, String name, MemberType memberType, MembershipLevelType membershipLevelType) {
		this.email = email;
		this.name = name;
		this.memberType = memberType;
		this.membershipLevelType = membershipLevelType;

	}
}
