package com.smk.casier.model;

import java.util.Date;

public abstract class Model {
    protected Date dateCreated;
    protected Date LastModified;
    protected  String createdBy;
    protected  String updatedBy;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return LastModified;
    }

    public void setLastModified(Date lastModified) {
        LastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
