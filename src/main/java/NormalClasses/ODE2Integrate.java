package NormalClasses;

import Interfaces.ODEEquation;
import Interfaces.ODEStep;
import Interfaces.ODEUpdate;

public class ODE2Integrate
{
    // Makes the integration with the method that comes as an argument.
    double t0;
    double tf;
    double x0;
    double v0;
    ODEEquation function;
    ODEEquation functionDEV;
    ODEUpdate updateODE;

    public ODE2Integrate(double t0, double tf, double x0, double v0, ODEEquation function, ODEEquation functionDEV, ODEUpdate updateODE)
    {
        this.t0 = t0;
        this.tf = tf;
        this.x0 = x0;
        this.v0 = v0;
        this.function = function;
        this.functionDEV = functionDEV;
        this.updateODE = updateODE;
    }

    public void integrate(ODEStep method, double dt)
    {
        double ti = t0;
        double xi = x0;
        double vi = v0;
        while(ti <= tf)
        {
            updateODE.update(ti,xi,vi);
            xi = method.stepX(ti,xi,vi,function,functionDEV);
            vi = method.stepV(ti,xi,vi,function, functionDEV);
            ti += dt;
        }
    }
}
