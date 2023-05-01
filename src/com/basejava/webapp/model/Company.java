package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Company {

    private final String webSite;
    private String name;
    private final List<Period> periods;

    public Company(String webSite, String name, List<Period> periods) {
        this.webSite = webSite;
        this.name = name;
        this.periods = periods;
    }

    public Company(String webSite, String name, Period... periods) {
        this(webSite, name, Arrays.asList(periods));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(webSite, company.webSite) && Objects.equals(periods, company.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webSite, periods);
    }

    @Override
    public String toString() {
        return "Company{" +
                "link='" + webSite + '\'' +
                ", periods=" + periods +
                '}';
    }

    public static class Period {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String description;

        public Period(LocalDate startDate, LocalDate endDate, String title, String description) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Period period = (Period) o;
            return Objects.equals(startDate, period.startDate) && Objects.equals(endDate, period.endDate) && Objects.equals(title, period.title) && Objects.equals(description, period.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, title, description);
        }

        @Override
        public String toString() {
            return "startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description;
        }
    }
}
