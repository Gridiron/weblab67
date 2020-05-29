package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bill.class)
public abstract class Bill_ {

	public static volatile SingularAttribute<Bill, Double> amount;
	public static volatile SingularAttribute<Bill, Integer> orderer_id;
	public static volatile SingularAttribute<Bill, Integer> id;
	public static volatile SingularAttribute<Bill, Boolean> is_paid;

	public static final String AMOUNT = "amount";
	public static final String ORDERER_ID = "orderer_id";
	public static final String ID = "id";
	public static final String IS_PAID = "is_paid";

}

