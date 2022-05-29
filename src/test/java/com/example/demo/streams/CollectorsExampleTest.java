package com.example.demo.streams;

import com.example.demo.dto.CodedValuesLookup;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectorsExampleTest {

    @Test
    public void joining() {
        String sql = "INSERT INTO TABLE (COL1, COL2) VALUES ";
        String result = String.format(CollectorsExample.joining(sql), "'col1value'" , "'col2value'");
        String expected = "INSERT INTO TABLE (COL1, COL2) VALUES ('col1value','col2value');";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void nestedMap() {
        List<CodedValuesLookup> inputCodedValues = new ArrayList<>();
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC1").type("TYPE1").code("CODE1").value("VALUE1").build());
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC1").type("TYPE1").code("CODE2").value("VALUE2").build());
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC1").type("TYPE2").code("CODE3").value("VALUE3").build());
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC1").type("TYPE2").code("CODE4").value("VALUE4").build());
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC2").type("TYPE1").code("CODE1").value("VALUE1").build());
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC2").type("TYPE1").code("CODE2").value("VALUE2").build());
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC2").type("TYPE2").code("CODE3").value("VALUE3").build());
        inputCodedValues.add(CodedValuesLookup.builder().service("SVC2").type("TYPE2").code("CODE4").value("VALUE4").build());
        Map output =  CollectorsExample.nestedMap(inputCodedValues);
    }
}
