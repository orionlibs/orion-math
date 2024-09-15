package io.github.orionlibs.orion_math.number;

public class NumberTypes
{
    public static NumberType get(Number x)
    {
        if(x instanceof Complex)
        {
            return NumberType.ComplexNumber;
        }
        else if(x instanceof Byte || x instanceof Short || x instanceof Integer || x instanceof Long)
        {
            if(x.longValue() >= 0L)
            {
                return NumberType.NaturalNumber;
            }
            else
            {
                return NumberType.IntegerNumber;
            }
        }
        else
        {
            return NumberType.RealNumber;
        }
    }
}
