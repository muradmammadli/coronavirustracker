package com.example.koronavirusapp;

public class about {

    private String aboutTitle;
    private String aboutBody;
    private boolean expanded;
    public about(String aboutTitle, String aboutBody) {
        this.aboutTitle = aboutTitle;
        this.aboutBody = aboutBody;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getAboutTitle() {
        return aboutTitle;
    }

    public void setAboutTitle(String aboutTitle) {
        this.aboutTitle = aboutTitle;
    }

    public String getAboutBody() {
        return aboutBody;
    }

    public void setAboutBody(String aboutBody) {
        this.aboutBody = aboutBody;
    }
}
