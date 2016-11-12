package model;

/**
 * Created by User on 07.09.2016.
 */
public interface Inclusion {

    String getName();
    void setName(String name);

    // E -модуль упругости (упругое свойство)
    double getE();
    void setE(double a);

    // греческая "ню" -модуль упругости (упругое свойство)
    double getV();
    void setV(double a);


    // K - *** (пластичное свойство)
    double getK();
    void setK(double a);

    // M "Эта" - *** (вязкоупругое свойство)
    double getM();
    void setM(double a);

    // Liamda - коеф. теплопроводности (теплопроводное свойство)
    double getLiamda();
    void setLiamda(double a);

    // G "сигма" - предел прочности (прочносное свойство)
    double getG();
    void setG(double a);

    // Gr "сигма" - предел прочности на растяжение (прочносное свойство)
    double getGr();
    void setGr(double a);

    // Gs "сигма" - предел прочности на сжатие (прочносное свойство)
    double getGs();
    void setGs(double a);

}
