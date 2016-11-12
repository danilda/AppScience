package model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by User on 07.09.2016.
 */
public class Elasticity {

    private Matrix matrix;
    private Fibers fibers;
    private DisperseInclusion disperse;

    public Elasticity(Matrix matrix, DisperseInclusion disperseFibers , Fibers  fibers){
        this.matrix = matrix;
        this.fibers = fibers;
        this.disperse = disperseFibers;
    }

    public double l(){
        return sqrt(1 - pow((fibers.getD()/fibers.getL()),2));
    }


    public double r1(){
        return ((1-pow(l(),2))/(4*pow(l(), 5)))
                *( ( ( 3 - pow(l(), 2) ) * 0.5 * Math.log( (1+l())/(1-l()) ) ) - 3*l() );
    }

    public double r2(){
        return (3./8.)*(1 - 4*r1() - r3());
    }

    public double r3(){
        return ((1-pow(l(),2))/(pow(l(), 5)))
                *( ( ( 1 - pow(l(), 2) ) * l() + ( 1 - pow(l(), 2) )* 0.5 * Math.log( (1+l())/(1-l()) ) ));
    }

    public double q(){
        return 2*(1 + ((0.1)/(6*r2() + ((matrix.getE())/(fibers.getE() - matrix.getE())))));
    }

    public double q1(){
        return 1./(((matrix.getE())/(disperse.getE() - matrix.getE()))+ 0.4);
    }

    public double ee(double cs, double cf){
        return 1 + (q()*cf + q1()*cs)/(1 - cs - cf + (q()*cf*matrix.getE())/(fibers.getE() - matrix.getE())
                + (q1()*cs*matrix.getE())/(disperse.getE() - matrix.getE()) );
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Fibers getFibers() {
        return fibers;
    }

    public void setFibers(Fibers fibers) {
        this.fibers = fibers;
    }

    public DisperseInclusion getDisperse() {
        return disperse;
    }

    public void setDisperse(DisperseInclusion disperse) {
        this.disperse = disperse;
    }
}
