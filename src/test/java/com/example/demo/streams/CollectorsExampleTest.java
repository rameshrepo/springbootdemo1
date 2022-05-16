package com.example.demo.streams;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectorsExampleTest {

    @Test
    public void joining() {
        String sql = "INSERT INTO TABLE (COL1, COL2) VALUES ";
        String result = String.format(CollectorsExample.joining(sql), "'col1value'" , "'col2value'");
        String expected = "INSERT INTO TABLE (COL1, COL2) VALUES ('col1value','col2value');";
        assertThat(result).isEqualTo(expected);
    }
}
