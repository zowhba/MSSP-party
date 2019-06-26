package com.sk.sample.mssp.party.domain.model;

import javax.persistence.Entity;

import com.sk.sample.mssp.shared.base.AbstractEntity;
import com.sk.sample.mssp.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class PartyMember extends AbstractEntity implements AggregateRoot {
	private Long partyId;
	private String userId;
	
	public PartyMember(Long partyId, String userId) {
		this.partyId = partyId;
		this.userId = userId;

	}
}

