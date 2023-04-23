package com.basejava.webapp.model;

import java.util.Objects;

public class ContentSection extends Section{

    private final String content;

    public ContentSection(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentSection that = (ContentSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "ContentSection{" +
                "content='" + content + '\'' +
                '}';
    }
}
