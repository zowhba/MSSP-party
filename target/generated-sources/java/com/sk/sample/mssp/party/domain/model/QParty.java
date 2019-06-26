package com.sk.sample.mssp.party.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParty is a Querydsl query type for Party
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParty extends EntityPathBase<Party> {

    private static final long serialVersionUID = -1255833649L;

    public static final QParty party = new QParty("party");

    public final com.sk.sample.mssp.shared.base.QAbstractEntity _super = new com.sk.sample.mssp.shared.base.QAbstractEntity(this);

    public final DateTimePath<java.util.Date> expireDate = createDateTime("expireDate", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath leaderId = createString("leaderId");

    public final StringPath name = createString("name");

    public final NumberPath<Long> numberOfMember = createNumber("numberOfMember", Long.class);

    public final EnumPath<PartyStatusType> partyStatusType = createEnum("partyStatusType", PartyStatusType.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public QParty(String variable) {
        super(Party.class, forVariable(variable));
    }

    public QParty(Path<? extends Party> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParty(PathMetadata metadata) {
        super(Party.class, metadata);
    }

}

