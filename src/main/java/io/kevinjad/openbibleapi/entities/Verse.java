package io.kevinjad.openbibleapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_kjv")
public class Verse {

    @Id
    private int id;
    @Column(name = "b")
    private int b;
    @Column(name = "c")
    private int c;
    @Column(name = "v")
    private int v;
    @Column(name = "t")
    private String t;
    
    public Verse() {

    }

    public Verse(int id, int b, int c, int v, String text) {
        this.id = id;
        this.b = b;
        this.c = c;
        this.v = v;
        this.t = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public String getT() {
        return t;
    }

    public void setT(String text) {
        this.t = text;
    }

}
