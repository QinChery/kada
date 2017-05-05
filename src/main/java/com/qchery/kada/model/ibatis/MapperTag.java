package com.qchery.kada.model.ibatis;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("mapper")
public class MapperTag {

    @XStreamAsAttribute
    private String namespace;
    
    @XStreamAlias("resultMap")
    private ResultMapTag resultMapTag;

    @XStreamImplicit
    private List<InsertTag> insertTags;

    public MapperTag(String namespace) {
        super();
        this.namespace = namespace;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public ResultMapTag getResultMapTag() {
        return resultMapTag;
    }

    public void setResultMapTag(ResultMapTag resultMapTag) {
        this.resultMapTag = resultMapTag;
    }

    public List<InsertTag> getInsertTags() {
        return insertTags;
    }

    public void setInsertTags(List<InsertTag> insertTags) {
        this.insertTags = insertTags;
    }

}