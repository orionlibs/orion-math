package io.github.orionlibs.orion_math.number;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberTypeHierarchy
{
    private static final Map<NumberType, Integer> numberTypeAndRankingMapper;

    static
    {
        Map<NumberType, Integer> numberTypeAndRankingMapperTemp = new HashMap<>();
        numberTypeAndRankingMapperTemp.put(NumberType.NegativeInfinityNumber, 1);
        numberTypeAndRankingMapperTemp.put(NumberType.NaturalNumber, 2);
        numberTypeAndRankingMapperTemp.put(NumberType.IntegerNumber, 3);
        numberTypeAndRankingMapperTemp.put(NumberType.RationalNumber, 4);
        numberTypeAndRankingMapperTemp.put(NumberType.IrrationalNumber, 5);
        numberTypeAndRankingMapperTemp.put(NumberType.RealNumber, 6);
        numberTypeAndRankingMapperTemp.put(NumberType.ComplexNumber, 7);
        numberTypeAndRankingMapperTemp.put(NumberType.PositiveInfinityNumber, 8);
        numberTypeAndRankingMapper = Collections.unmodifiableMap(numberTypeAndRankingMapperTemp);
    }

    public static int getRankingOfNumberType(NumberType numberType)
    {
        return numberTypeAndRankingMapper.get(numberType);
    }


    public static NumberType getNumberTypeForRanking(int ranking)
    {
        return numberTypeAndRankingMapper.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == ranking).collect(Collectors.toList()).get(0).getKey();
    }


    public static NumberType getHighestRankingNumberType(Number x, Number y)
    {
        int rankingOfNumberOfTypeOfX = getRankingOfNumberType(NumberTypes.get(x));
        int rankingOfNumberOfTypeOfY = getRankingOfNumberType(NumberTypes.get(y));
        int maximumRanking = Math.max(rankingOfNumberOfTypeOfX, rankingOfNumberOfTypeOfY);
        return getNumberTypeForRanking(maximumRanking);
    }
}