package io.github.orionlibs.orion_math.number.complex;

import io.github.orionlibs.orion_math.utils.CloningService;

/**
 * mutable Complex number class. Use ImmutableComplex if you need immutability
 */
public class Complex extends AComplex implements Comparable<Number>
{
    public static final Complex ZERO = Complex.of();
    private double realValue = 0.0d;
    private double imaginaryValue = 0.0d;


    public Complex()
    {
    }


    public Complex(double realValue)
    {
        this.realValue = realValue;
    }


    public Complex(double realValue, double imaginaryValue)
    {
        this(realValue);
        this.imaginaryValue = imaginaryValue;
    }


    public static Complex of()
    {
        return new Complex();
    }


    public static Complex of(double realValue)
    {
        return new Complex(realValue);
    }


    public static Complex of(double realValue, double imaginaryValue)
    {
        return new Complex(realValue, imaginaryValue);
    }


    @Override
    public int intValue()
    {
        return (int)getRealValue();
    }


    @Override
    public long longValue()
    {
        return (long)getRealValue();
    }


    @Override
    public float floatValue()
    {
        return (float)getRealValue();
    }


    @Override
    public double doubleValue()
    {
        return getRealValue();
    }


    @Override
    public double getRealValue()
    {
        return realValue;
    }


    public void setRealValue(double realValue)
    {
        this.realValue = realValue;
    }


    @Override
    public double getImaginaryValue()
    {
        return imaginaryValue;
    }


    public void setImaginaryValue(double imaginaryValue)
    {
        this.imaginaryValue = imaginaryValue;
    }


    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Complex temp)
        {
            return this.realValue == temp.getRealValue()
                            && this.imaginaryValue == temp.getImaginaryValue();
        }
        else
        {
            return false;
        }
    }


    @Override
    public String toString()
    {
        if(realValue == Double.NaN || imaginaryValue == Double.NaN)
        {
            return "NaN";
        }
        else if(realValue == Double.NEGATIVE_INFINITY || imaginaryValue == Double.NEGATIVE_INFINITY)
        {
            return "-inf";
        }
        else if(realValue == Double.POSITIVE_INFINITY || imaginaryValue == Double.POSITIVE_INFINITY)
        {
            return "inf";
        }
        else
        {
            if(imaginaryValue < 0.0f)
            {
                return STR."\{Double.toString(realValue)} - \{Double.toString(-imaginaryValue)}i";
            }
            else
            {
                return STR."\{Double.toString(realValue)} + \{Double.toString(imaginaryValue)}i";
            }
        }
    }


    @Override
    public Complex clone()
    {
        return (Complex)CloningService.clone(this);
    }


    @Override
    public int compareTo(Number o)
    {
        throw new UnsupportedOperationException();
    }
}
