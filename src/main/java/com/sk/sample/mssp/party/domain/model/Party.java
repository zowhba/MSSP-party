package com.sk.sample.mssp.party.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.mssp.shared.base.AbstractEntity;
import com.sk.sample.mssp.shared.base.AggregateRoot;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Party extends AbstractEntity implements AggregateRoot {
	@ApiModelProperty(required = true, value = "파리명")
	private String name;
	private String leaderId;
	private Long numberOfMember;
	private Date startDate;
	private Date expireDate;
	
	@Enumerated(EnumType.STRING)
	private PartyStatusType partyStatusType;
	
	public Party(String name, String leaderId, Long numberOfMember, Date startDate, Date expireDate) {
		this(name, leaderId, numberOfMember, startDate, expireDate, PartyStatusType.OPEN);
	}
	
	public Party(String name, String leaderId, Long numberOfMember, Date startDate, Date expireDate, PartyStatusType partyStatusType) {
		this.name = name;
		this.leaderId = leaderId;
		this.numberOfMember = numberOfMember;
		this.startDate = startDate;
		this.expireDate = expireDate;
		this.partyStatusType = partyStatusType;

	}
}

