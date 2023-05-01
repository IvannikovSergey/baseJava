package com.basejava.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CompanySection extends Section{
    private final List<Company> companyList;

    public CompanySection(List<Company> companyList) {
        this.companyList = companyList;
    }

    public CompanySection(Company... companies) {
        this(Arrays.asList(companies));
    }

    public List<Company> getExpierienceList() {
        return companyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySection that = (CompanySection) o;
        return Objects.equals(companyList, that.companyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyList);
    }

    @Override
    public String toString() {
        return companyList.toString();
    }
}
