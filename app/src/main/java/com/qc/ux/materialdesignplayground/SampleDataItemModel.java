package com.qc.ux.materialdesignplayground;

public class SampleDataItemModel {
    private String title;
    private String secondaryText;

    public SampleDataItemModel(String title, String secondaryText) {
        this.title = title;
        this.secondaryText = secondaryText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondaryText() {
        return secondaryText;
    }

    public void setSecondaryText(String secondaryText) {
        this.secondaryText = secondaryText;
    }
}
