package com.example.demo.streams;

import org.springframework.util.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

}
