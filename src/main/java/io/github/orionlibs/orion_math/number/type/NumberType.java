package io.github.orionlibs.orion_math.number.type;

import io.github.orionlibs.orion_math.utils.OrionEnumeration;

public enum NumberType implements OrionEnumeration
{
    NaturalNumber,
    IntegerNumber,
    RationalNumber,
    IrrationalNumber,
    RealNumber,
    ComplexNumber,
    PositiveNumber,
    NegativeNumber,
    NonpositiveNumber,
    NonnegativeNumber,
    PositiveInfinityNumber,
    NegativeInfinityNumber,
    ValidNumber,
    InvalidNumber;


    @Override
    public String get()
    {
        return null;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof NumberType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof NumberType && this != other;
    }


    public static boolean valueExists(String other)
    {
        NumberType[] values = values();
        for(NumberType value : values)
        {
            if(value.get().equals(other))
            {
                return true;
            }
        }
        return false;
    }


    public static NumberType getEnumForValue(String other)
    {
        NumberType[] values = values();
        for(NumberType value : values)
        {
            if(value.get().equals(other))
            {
                return value;
            }
        }
        return null;
    }
}