package Interfaces;

public interface ODEStep
{
    // Update the step with the calculation that make the method, which is an argument in the ODE2Integrate.
    double stepX(double dt, double x, double v, ODEEquation function, ODEEquation functionDEV);
    double stepV(double dt, double x, double v, ODEEquation function, ODEEquation functionDEV);
}
