package com.example.demo.streams;

import com.example.demo.dto.CodedValuesLookup;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class CollectorsExample {

    /**
     * Collectors.joining - delimiter, prefix and suffix
     * @return String
     */
    public static String joining(String sql) {
        int numberOfColumns =  StringUtils.countOccurrencesOf(sql, ",");
        return IntStream.rangeClosed(0, numberOfColumns)
                .mapToObj( i -> "%s")
                .collect(Collectors.joining("," , sql + "(", ");" ));
    }

    public static Map<String, Map<String, Map<String,String>>> nestedMap(List<CodedValuesLookup> list) {
        Map<String, Map<String, Map<String, String>>> result =
                list.stream().collect(
                        groupingBy(CodedValuesLookup::getService, groupingBy(CodedValuesLookup::getType,
                                Collectors.toMap(CodedValuesLookup::getCode, CodedValuesLookup::getValue)))
                );
        return result;
    }
}
