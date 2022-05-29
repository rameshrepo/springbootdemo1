package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CodedValuesLookup {
    private Integer codedValueId;
    private String service;
    private String type;
    private String code;
    private String value;
}
