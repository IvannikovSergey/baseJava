package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ExpierienceSection extends Section{
    private final List<Expierience> expierienceList;

    public ExpierienceSection(List<Expierience> expierienceList) {
        this.expierienceList = expierienceList;
    }

    public List<Expierience> getExpierienceList() {
        return expierienceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpierienceSection that = (ExpierienceSection) o;
        return Objects.equals(expierienceList, that.expierienceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expierienceList);
    }

    @Override
    public String toString() {
        return "ExpierienceSection{" +
                "expierienceList=" + expierienceList +
                '}';
    }
}
