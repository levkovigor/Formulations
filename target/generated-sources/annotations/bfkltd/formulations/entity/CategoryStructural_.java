package bfkltd.formulations.entity;

import bfkltd.formulations.entity.Inci;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-07T16:43:50")
@StaticMetamodel(CategoryStructural.class)
public class CategoryStructural_ { 

    public static volatile SingularAttribute<CategoryStructural, String> nameRu;
    public static volatile SingularAttribute<CategoryStructural, Integer> parent;
    public static volatile CollectionAttribute<CategoryStructural, Inci> inciCollection;
    public static volatile SingularAttribute<CategoryStructural, String> nameUa;
    public static volatile SingularAttribute<CategoryStructural, Integer> id;
    public static volatile SingularAttribute<CategoryStructural, String> nameEn;

}