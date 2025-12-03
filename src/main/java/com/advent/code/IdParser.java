package com.advent.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class IdParser {

    public List<Id> parse(String input) {
        return Arrays.stream(input.trim().split(","))
                .flatMap(idRange -> {
                            List<String> values = List.of(idRange.trim().split("-"));
                            long start = Long.parseLong(values.getFirst());
                            long end = Long.parseLong(values.getLast());
                            return LongStream.range(start, end + 1).mapToObj(Id::new);
                        }
                ).toList();
    }
}
