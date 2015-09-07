package bfkltd.formulations.entity;

import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.entity.InciPropertyPK;
import bfkltd.formulations.entity.Property;
import bfkltd.formulations.entity.PropertyUnit;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-07T16:43:50")
@StaticMetamodel(InciProperty.class)
public class InciProperty_ { 

    public static volatile SingularAttribute<InciProperty, Property> property;
    public static volatile SingularAttribute<InciProperty, String> propertyValue;
    public static volatile SingularAttribute<InciProperty, Inci> inci;
    public static volatile SingularAttribute<InciProperty, PropertyUnit> propertyUnitId;
    public static volatile SingularAttribute<InciProperty, InciPropertyPK> inciPropertyPK;

}