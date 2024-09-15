package io.github.orionlibs.orion_math.number.complex;

public abstract class AComplex extends Number implements Cloneable
{
    public AComplex()
    {
    }


    abstract public double getRealValue();


    abstract public double getImaginaryValue();
}
