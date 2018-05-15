package com.example.admin.marchtest;

public class CarPark {
    private String icid;
    private String carid;
    private String person;
    private String intime;
    private String outtime;
    private String monry;

    public String getIcid() {
        return icid;
    }

    public void setIcid(String icid) {
        this.icid = icid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getMonry() {
        return monry;
    }

    public void setMonry(String monry) {
        this.monry = monry;
    }

    public CarPark(String icid, String carid, String person, String intime, String outtime, String monry) {
        this.icid = icid;
        this.carid = carid;
        this.person = person;
        this.intime = intime;
        this.outtime = outtime;
        this.monry = monry;
    }
}
