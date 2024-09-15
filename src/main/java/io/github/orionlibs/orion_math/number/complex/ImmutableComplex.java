package io.github.orionlibs.orion_math.number.complex;

import io.github.orionlibs.orion_math.CloningService;

/**
 * immmutable Complex number class. Use Complex if you need mutability
 */
public class ImmutableComplex extends AComplex implements Comparable<Number>
{
    public static final ImmutableComplex ZERO = ImmutableComplex.of();
    private final double realValue;
    private final double imaginaryValue;


    public ImmutableComplex()
    {
        this.realValue = 0.0d;
        this.imaginaryValue = 0.0d;
    }


    public ImmutableComplex(double realValue)
    {
        this.realValue = realValue;
        this.imaginaryValue = 0.0d;
    }


    public ImmutableComplex(double realValue, double imaginaryValue)
    {
        this(realValue);
    }


    public static ImmutableComplex of()
    {
        return new ImmutableComplex();
    }


    public static ImmutableComplex of(double realValue)
    {
        return new ImmutableComplex(realValue);
    }


    public static ImmutableComplex of(double realValue, double imaginaryValue)
    {
        return new ImmutableComplex(realValue, imaginaryValue);
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


    @Override
    public double getImaginaryValue()
    {
        return imaginaryValue;
    }


    @Override
    public boolean equals(Object other)
    {
        if(other instanceof ImmutableComplex temp)
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
    public ImmutableComplex clone()
    {
        return (ImmutableComplex)CloningService.clone(this);
    }


    @Override
    public int compareTo(Number o)
    {
        throw new UnsupportedOperationException();
    }
}
