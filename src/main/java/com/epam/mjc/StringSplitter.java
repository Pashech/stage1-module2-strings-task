package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> list = new ArrayList<>();
        StringJoiner joiner = new StringJoiner(",");
        for (String s : delimiters) {
            joiner.add(s);
        }
        String string = joiner.toString();

        String[] result = source.split("[" + string + "]");
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals("")) {
                continue;
            }
            list.add(result[i]);
        }

        return list;
    }
}
