package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Work.class)
public abstract class Work_ {

	public static volatile SingularAttribute<Work, Integer> tech_task_id;
	public static volatile SingularAttribute<Work, String> qualification;
	public static volatile SingularAttribute<Work, Integer> id;
	public static volatile SingularAttribute<Work, Integer> workers_amount;

	public static final String TECH_TASK_ID = "tech_task_id";
	public static final String QUALIFICATION = "qualification";
	public static final String ID = "id";
	public static final String WORKERS_AMOUNT = "workers_amount";

}

