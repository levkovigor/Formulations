package bfkltd.formulations.entity;

import bfkltd.formulations.entity.InciProperty;
import bfkltd.formulations.entity.PropertyUnit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-07T16:43:50")
@StaticMetamodel(Property.class)
public class Property_ { 

    public static volatile SingularAttribute<Property, String> nameRu;
    public static volatile CollectionAttribute<Property, InciProperty> inciPropertyCollection;
    public static volatile SingularAttribute<Property, String> nameUa;
    public static volatile SingularAttribute<Property, Integer> id;
    public static volatile SingularAttribute<Property, String> nameEn;
    public static volatile CollectionAttribute<Property, PropertyUnit> propertyUnitCollection;

}