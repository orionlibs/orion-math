package io.github.orionlibs.orion_math.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.orion_math.ATest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class NumberTypeHierarchyTest extends ATest
{
    @Test
    void test_get()
    {
        NumberType type = NumberTypeHierarchy.getHighestRankingNumberType(1, 1);
        assertEquals(NumberType.NaturalNumber, type);
        type = NumberTypeHierarchy.getHighestRankingNumberType(1, 1.0f);
        assertEquals(NumberType.RealNumber, type);
        type = NumberTypeHierarchy.getHighestRankingNumberType(Complex.of(), 1L);
        assertEquals(NumberType.ComplexNumber, type);
    }
}
