package com.test.lesson4.Models;

import java.util.Date;

public class Summa {

    private double summa;
    private Date date;
    private String name;

    public Summa(double summa, Date date, String name) {

        this.summa = summa;
        this.date = date;
        this.name = name;


    }


    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
