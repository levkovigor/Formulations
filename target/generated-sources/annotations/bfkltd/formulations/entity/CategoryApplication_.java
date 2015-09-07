package bfkltd.formulations.entity;

import bfkltd.formulations.entity.Inci;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-07T16:43:50")
@StaticMetamodel(CategoryApplication.class)
public class CategoryApplication_ { 

    public static volatile SingularAttribute<CategoryApplication, String> nameRu;
    public static volatile SingularAttribute<CategoryApplication, Integer> parent;
    public static volatile CollectionAttribute<CategoryApplication, Inci> inciCollection;
    public static volatile SingularAttribute<CategoryApplication, String> nameUa;
    public static volatile SingularAttribute<CategoryApplication, Integer> id;
    public static volatile SingularAttribute<CategoryApplication, String> nameEn;

}