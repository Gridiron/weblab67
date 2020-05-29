package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Worker.class)
public abstract class Worker_ {

	public static volatile SingularAttribute<Worker, String> qualification;
	public static volatile SingularAttribute<Worker, Integer> project_id;
	public static volatile SingularAttribute<Worker, String> name;
	public static volatile SingularAttribute<Worker, Integer> id;
	public static volatile SingularAttribute<Worker, Boolean> is_manager;

	public static final String QUALIFICATION = "qualification";
	public static final String PROJECT_ID = "project_id";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String IS_MANAGER = "is_manager";

}

