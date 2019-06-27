package com.sk.sample.mssp.party.application.proxy.dto.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 323403111L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccount account = new QAccount("account");

    public final com.sk.sample.mssp.shared.base.QAbstractEntity _super = new com.sk.sample.mssp.shared.base.QAbstractEntity(this);

    public final com.sk.sample.mssp.shared.domain.QAddress address;

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final EnumPath<MembershipLevelType> membershipLevelType = createEnum("membershipLevelType", MembershipLevelType.class);

    public final EnumPath<MemberType> memberType = createEnum("memberType", MemberType.class);

    public final StringPath name = createString("name");

    public QAccount(String variable) {
        this(Account.class, forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccount(PathMetadata metadata, PathInits inits) {
        this(Account.class, metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.sk.sample.mssp.shared.domain.QAddress(forProperty("address")) : null;
    }

}

