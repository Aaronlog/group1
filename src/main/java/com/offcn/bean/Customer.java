package com.offcn.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Customer implements Serializable {
    private int cus_id;
    private String cname;
    private int cage;
    private String caddress;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cname='" + cname + '\'' +
                ", cage=" + cage +
                ", caddress='" + caddress + '\'' +
                '}';
    }
}
