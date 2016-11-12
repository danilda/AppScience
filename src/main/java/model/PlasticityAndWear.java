package model;

/**
 * Created by User on 15.09.2016.
 */
public class PlasticityAndWear {
    private Matrix matrix;
    private DisperseInclusion disperse;
    private Fibers  fibers;
    private Elasticity  elasticity;

    public PlasticityAndWear(Matrix matrix, DisperseInclusion disperse , Fibers  fibers){
        this.matrix = matrix;
        this.fibers = fibers;
        this.disperse = disperse;
        elasticity = new Elasticity(matrix, disperse, fibers);
    }

    public double q2(){
        return (1 - 0.4*((1 - 8*elasticity.r1() - 7* elasticity.r2())/(1 - 4*elasticity.r1() - 5* elasticity.r2())) +
                ((2./15.)*(elasticity.r1() - elasticity.r2()))/(elasticity.r2()) )
                /(2*(2*elasticity.r1() + elasticity.r2()));
    }
    public double k1(double c){
        return 1 + 1.5*c;
    }
    public double k2(double c){
        return 1 + (q2() - 1)*c;
    }

    public double t(double cs, double cf){
        return Math.sqrt(k1(cs)*k2(cf))/(elasticity.ee(cs, cf));
    }

}
