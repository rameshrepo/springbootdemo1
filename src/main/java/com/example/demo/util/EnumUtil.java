package com.example.demo.util;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumUtil {

    public static <E extends Enum<E>> List<E> getEnumsFromValues(String input, Class<E> enumType) {
        return Arrays.stream(input.split(","))
                .map(str -> Enum.valueOf(enumType, str)).collect(Collectors.toList());
    }

    public static <E extends Enum<E>> String getStringsFromEnums(List<E> enums, String delimiter) {
        if (CollectionUtils.isEmpty(enums)) return null;
        return enums.stream().map(input -> input.name()).collect(Collectors.joining(delimiter));
    }

}
