package com.qchery.kada.builder.hibernate.model;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.HashSet;
import java.util.Set;

/**
 * 联合主键
 *
 * @author Chery
 * @date 2017/2/12 - 下午3:38
 */
public class CompositeId {

    @XStreamImplicit(itemFieldName = "key-property")
    private Set<Property> compositeId = new HashSet<>();

    public Set<Property> getCompositeId() {
        return compositeId;
    }

    public void addKeyProperty(Property property) {
        this.compositeId.add(property);
    }
}