package bfkltd.formulations.entity;

import bfkltd.formulations.entity.InciProperty;
import bfkltd.formulations.entity.Property;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-07T16:43:50")
@StaticMetamodel(PropertyUnit.class)
public class PropertyUnit_ { 

    public static volatile CollectionAttribute<PropertyUnit, InciProperty> inciPropertyCollection;
    public static volatile SingularAttribute<PropertyUnit, String> name;
    public static volatile SingularAttribute<PropertyUnit, Integer> id;
    public static volatile SingularAttribute<PropertyUnit, Property> propertyId;

}