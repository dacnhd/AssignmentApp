package com.example.assignmentapp.entity;

public class Spending {
    private String _id;
    private String name;
    private String des;
    private String detail;
    private String money;
    private String dateat;
    private String category;

    public Spending() {
    }

    public Spending(String _id, String name, String des, String detail, String money, String dateat, String category) {
        this._id = _id;
        this.name = name;
        this.des = des;
        this.detail = detail;
        this.money = money;
        this.dateat = dateat;
        this.category = category;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDateat() {
        return dateat;
    }

    public void setDateat(String dateat) {
        this.dateat = dateat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
