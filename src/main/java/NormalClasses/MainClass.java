package NormalClasses;

import Interfaces.CalculateAcceleration;
import Interfaces.ODEEquation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClass
{
    public static void main(String[] args)
    {
        // ZADANIE 2
        double omega = 0.2;
        ODEEquation functionA = ((double x) -> -0.5*Math.pow(omega,2)*Math.pow(x,2));
        ODEEquation functionDEVA = ((double x) -> -Math.pow(omega,2)*x);
        CalculateAcceleration accA = ((double x) -> -Math.pow(omega,2));
        VerletMethod verletMethodA = new VerletMethod(accA);
        ConsoleHandler consoleHandlerA = new ConsoleHandler(0,5,0.01);

        System.out.println("VERLET METHOD FOR HARMONIC OSCILLATOR");
        ODE2Integrate ode2IntegrateA = new ODE2Integrate(0,5,2,0,functionA,functionDEVA,consoleHandlerA);
        ode2IntegrateA.integrate(verletMethodA,0.01);
        consoleHandlerA.printResults();
        System.out.println("\n\n");

        File saveDataA = new File("/Users/davidortegon/Temporales/ResultsVerletZadanie1.txt");
        try (PrintWriter pw = new PrintWriter(saveDataA))
        {
            pw.printf("%15s %15s %15s%n", "Time","x(t)", "v(t)");
            for (int i =  0; i < consoleHandlerA.getTime().size(); i++)
            {
                pw.printf("%15g %15g %15g%n", consoleHandlerA.getTime().get(i), consoleHandlerA.getX().get(i), consoleHandlerA.getV().get(i));
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        // ZADANIE 3
        ODEEquation function = ((double x) -> 24*((2/Math.pow(x,13))-(1/Math.pow(x,7))));
        ODEEquation functionDEV = ((double x) -> (24*(7*Math.pow(x,6)-26))/Math.pow(x,14));
        CalculateAcceleration acc = ((double x) -> (-672*(2*Math.pow(x,6)-13))/Math.pow(x,15));
        VerletMethod verletMethod = new VerletMethod(acc);
        ConsoleHandler consoleHandler = new ConsoleHandler(0,5,0.01);

        System.out.println("VERLET METHOD");
        ODE2Integrate ode2Integrate = new ODE2Integrate(0,5,2,0,function,functionDEV,consoleHandler);
        ode2Integrate.integrate(verletMethod,0.01);
        consoleHandler.printResults();
        System.out.println("\n\n");

        File saveData = new File("/Users/davidortegon/Temporales/ResultsVerletZadanie2.txt");
        try (PrintWriter pw = new PrintWriter(saveData))
        {
            pw.printf("%15s %15s %15s%n", "Time","x(t)", "v(t)");
            for (int i =  0; i < consoleHandler.getTime().size(); i++)
            {
                pw.printf("%15g %15g %15g%n", consoleHandler.getTime().get(i), consoleHandler.getX().get(i), consoleHandler.getV().get(i));
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
