package model;

import java.util.ArrayList;

/**
 * Created by User on 07.09.2016.
 */
public class DisperseInclusion implements Inclusion {
    private double e;
    private double v;
    private double k;
    private double m;
    private double liamda;
    private double g;
    private double gr;
    private double gs;
    private String name;
    private static ArrayList<Inclusion> allDisperses = new ArrayList();

    public DisperseInclusion(){
        allDisperses.add(this);
    }

    public static ArrayList<Inclusion> getAllDisperses() {
        return allDisperses;
    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getLiamda() {
        return liamda;
    }

    public void setLiamda(double liamda) {
        this.liamda = liamda;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getGr() {
        return gr;
    }

    public void setGr(double gr) {
        this.gr = gr;
    }

    public double getGs() {
        return gs;
    }

    public void setGs(double gs) {
        this.gs = gs;
    }
}
