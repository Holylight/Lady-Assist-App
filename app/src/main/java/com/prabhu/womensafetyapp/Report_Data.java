package com.prabhu.womensafetyapp;

public class Report_Data {
    String name, mobilenumber, harass,location, key;

    public Report_Data(String name, String mobilenumber, String harass,String location, String key) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.harass = harass;
        this.location = location;
        this.key = key;
    }

    public Report_Data() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getHarass() {
        return harass;
    }

    public void setHarass(String harass) {
        this.harass = harass;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
