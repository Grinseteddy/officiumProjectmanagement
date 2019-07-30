package com.annegret.officium.projectmangement.entities;

public class Link {

    public enum linkType {
        PDF,
        HyperLink
    }

    public enum relation {
        Object,
        Assignee,
        Thread
    }

    private String href;

    private linkType linkType;

    private relation relation;

    public Link() {

    }

    public Link(String href, linkType linkType, relation relation) {
        this.href=href;
        this.linkType=linkType;
        this.relation=relation;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Link.linkType getLinkType() {
        return linkType;
    }

    public void setLinkType(Link.linkType linkType) {
        this.linkType = linkType;
    }

    public Link.relation getRelation() {
        return relation;
    }

    public void setRelation(Link.relation relation) {
        this.relation = relation;
    }
}
