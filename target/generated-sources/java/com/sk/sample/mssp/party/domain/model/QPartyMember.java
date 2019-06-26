package com.sk.sample.mssp.party.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPartyMember is a Querydsl query type for PartyMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPartyMember extends EntityPathBase<PartyMember> {

    private static final long serialVersionUID = 203136841L;

    public static final QPartyMember partyMember = new QPartyMember("partyMember");

    public final com.sk.sample.mssp.shared.base.QAbstractEntity _super = new com.sk.sample.mssp.shared.base.QAbstractEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> partyId = createNumber("partyId", Long.class);

    public final StringPath userId = createString("userId");

    public QPartyMember(String variable) {
        super(PartyMember.class, forVariable(variable));
    }

    public QPartyMember(Path<? extends PartyMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPartyMember(PathMetadata metadata) {
        super(PartyMember.class, metadata);
    }

}

