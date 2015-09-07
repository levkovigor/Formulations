package bfkltd.formulations.entity;

import bfkltd.formulations.entity.CategoryApplication;
import bfkltd.formulations.entity.CategoryStructural;
import bfkltd.formulations.entity.InciProperty;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-07T16:43:50")
@StaticMetamodel(Inci.class)
public class Inci_ { 

    public static volatile SingularAttribute<Inci, String> nameRu;
    public static volatile CollectionAttribute<Inci, InciProperty> inciPropertyCollection;
    public static volatile SingularAttribute<Inci, String> cas;
    public static volatile SingularAttribute<Inci, String> nameUa;
    public static volatile SingularAttribute<Inci, String> description;
    public static volatile CollectionAttribute<Inci, CategoryStructural> categoryStructuralCollection;
    public static volatile SingularAttribute<Inci, Integer> id;
    public static volatile SingularAttribute<Inci, String> nameEn;
    public static volatile CollectionAttribute<Inci, CategoryApplication> categoryApplicationCollection;
    public static volatile SingularAttribute<Inci, String> einecs;
    public static volatile SingularAttribute<Inci, String> smile;

}