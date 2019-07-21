package com.example.itcinfotech;

public class Data {
    private String name;
    private String tempID;
    private String project;
    private String department;
    private String startDate;
    private String endDate;
    private String guide;

    public Data() {
    }

    public Data(String name, String tempID, String project, String department, String startDate, String endDate, String guide) {
        this.name = name;
        this.tempID = tempID;
        this.project = project;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guide = guide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempID() {
        return tempID;
    }

    public void setTempID(String tempID) {
        this.tempID = tempID;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}


