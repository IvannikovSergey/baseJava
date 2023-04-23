package com.basejava.webapp.model;

import java.util.Objects;

public class Expierience {

    private final String link;
    private final String startDate;
    private final String endDate;
    private final String title;
    private final String description;

    public Expierience(String link, String startDate, String endDate, String title, String description) {
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expierience that = (Expierience) o;
        return Objects.equals(link, that.link)
                && Objects.equals(startDate, that.startDate)
                && Objects.equals(endDate, that.endDate) && Objects.equals(title, that.title)
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, startDate, endDate, title, description);
    }

    @Override
    public String toString() {
        return "Expierience{" +
                "link='" + link + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
