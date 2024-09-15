package io.github.orionlibs.orion_math.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.orion_math.ATest;
import io.github.orionlibs.orion_math.number.complex.Complex;
import io.github.orionlibs.orion_math.number.type.NumberType;
import io.github.orionlibs.orion_math.number.type.NumberTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class NumberTypesTest extends ATest
{
    @Test
    void test_get()
    {
        NumberType type = NumberTypes.get((byte)0);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get((byte)-0);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get((byte)1);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get((short)0);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get((short)-0);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get((short)1);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get(0);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get(-0);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get(1);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get(0L);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get(-0L);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get(1L);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypes.get((byte)-1);
        assertEquals(NumberType.IntegerNumber, type);
        type = NumberTypes.get((short)-1);
        assertEquals(NumberType.IntegerNumber, type);
        type = NumberTypes.get(-1);
        assertEquals(NumberType.IntegerNumber, type);
        type = NumberTypes.get(-1L);
        assertEquals(NumberType.IntegerNumber, type);
        type = NumberTypes.get(0.0f);
        assertEquals(NumberType.RealNumber, type);
        type = NumberTypes.get(-0.0f);
        assertEquals(NumberType.RealNumber, type);
        type = NumberTypes.get(0.0d);
        assertEquals(NumberType.RealNumber, type);
        type = NumberTypes.get(-0.0d);
        assertEquals(NumberType.RealNumber, type);
        type = NumberTypes.get(Complex.of());
        assertEquals(NumberType.ComplexNumber, type);
        type = NumberTypes.get(Complex.of(2, 2));
        assertEquals(NumberType.ComplexNumber, type);
        type = NumberTypes.get(Complex.of(-2, -2));
        assertEquals(NumberType.ComplexNumber, type);
    }
}
