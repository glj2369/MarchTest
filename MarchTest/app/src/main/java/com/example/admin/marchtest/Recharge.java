package com.example.admin.marchtest;

public class Recharge
{
    private String id;
    private String carid;
    private String money;
    private String person;
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Recharge(String id, String carid, String money, String person, String date) {
        this.id = id;
        this.carid = carid;
        this.money = money;
        this.person = person;
        this.date = date;
    }
}
