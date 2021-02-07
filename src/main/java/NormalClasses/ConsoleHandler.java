package NormalClasses;

import Interfaces.ODEUpdate;

import java.util.ArrayList;

public class ConsoleHandler implements ODEUpdate
{
    // Array Lists that have the results.
    private ArrayList<Double> time;
    private ArrayList<Double> X;
    private ArrayList<Double> V;
    double  t0;
    double tf;
    double dt;

    public ConsoleHandler(double t0, double tf, double dt)
    {
        time = new ArrayList<>();
        X = new ArrayList<>();
        V = new ArrayList<>();
        this.t0 = t0;
        this.tf = tf;
        this.dt = dt;
    }

    public ArrayList<Double> getTime()
    {
        return time;
    }

    public ArrayList<Double> getX()
    {
        return X;
    }

    public ArrayList<Double> getV()
    {
        return V;
    }


    @Override
    public void update(double t, double x, double v)
    {
        time.add(t);
        X.add(x);
        V.add(v);
    }

    public void printResults()
    {
        double numElements = ((tf-t0)/dt)+1;
        // int i = 0;
        System.out.printf("%15s %15s %15s%n", "Time", "X", "V");
        for (int i = 0; i < numElements; i ++)
        {
            System.out.printf("%15g %15g %15g%n", time.get(i), X.get(i), V.get(i));
        }
//        Other form to make the printing without the error.
//        do {
//            System.out.printf("%15g %15g %15g%n", time.get(i), X.get(i), V.get(i));
//            if(i < numElements)
//            {
//                i ++;
//            }
//            else
//                break;
//
//        } while(i != numElements);
    }
}
