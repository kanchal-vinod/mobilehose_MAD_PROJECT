package com.example.mobilehousecard;

public class Card {

    String cNum;
    String cYear;
    String cCvv;
    String cName;


    public Card() {
    }

    public Card(String cNum, String cYear, String cCvv, String cName) {
        this.cNum = cNum;
        this.cYear = cYear;
        this.cCvv = cCvv;
        this.cName = cName;
    }

    public String getcNum() {
        return cNum;
    }

    public void setcNum(String cNum) {
        this.cNum = cNum;
    }

    public String getcYear() {
        return cYear;
    }

    public void setcYear(String cYear) {
        this.cYear = cYear;
    }

    public String getcCvv() {
        return cCvv;
    }

    public void setcCvv(String cCvv) {
        this.cCvv = cCvv;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
