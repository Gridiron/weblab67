package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TechTask.class)
public abstract class TechTask_ {

	public static volatile SingularAttribute<TechTask, Integer> manager_id;
	public static volatile SingularAttribute<TechTask, Integer> orderer_id;
	public static volatile SingularAttribute<TechTask, String> name;
	public static volatile SingularAttribute<TechTask, Boolean> is_project;
	public static volatile SingularAttribute<TechTask, Integer> id;

	public static final String MANAGER_ID = "manager_id";
	public static final String ORDERER_ID = "orderer_id";
	public static final String NAME = "name";
	public static final String IS_PROJECT = "is_project";
	public static final String ID = "id";

}

