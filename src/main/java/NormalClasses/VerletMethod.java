package NormalClasses;
import Interfaces.CalculateAcceleration;
import Interfaces.ODEEquation;
import Interfaces.ODEStep;

public class VerletMethod implements ODEStep
{
    // Define how will be calculated the values for x and v in a certain interval and function.
    CalculateAcceleration acc;

    public VerletMethod(CalculateAcceleration acc)
    {
        this.acc = acc;
    }

    @Override
    public double stepX(double dt, double x, double v, ODEEquation function, ODEEquation functionDev)
    {
        return x + dt*(v+(dt*acc.a(x))/2);
    }

    @Override
    public double stepV(double dt, double x, double v, ODEEquation function, ODEEquation functionDev)
    {
        return v + dt*(acc.a(x))/2 + dt*(acc.a(stepX(dt,x,v,function,functionDev)))/2;
    }
}
