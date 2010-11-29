package com.noodle.common;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * FIXME: DOCUMENT ME!!!
 */
public class Runner {

    public static void main(String[] args) {

        List<String> fieldNames = Lists.newArrayList("ngram2", "field_name", "ngram0", "ngram6", "ngram11", "asdngram", "ngram3as", "NGRAM4", "ngram4 ", " ngram4", "nGram4");
        for (String fieldName : fieldNames) {
            createSearchFieldWithName(fieldName);
        }

        for (int i = 0; i < 100; i++) {
            createSearchFieldWithName(fieldNames.get(0));
        }

//        Pattern pattern1 = Pattern.compile("ngram[1-5]");
//        Pattern pattern2 = Pattern.compile("^ngram[1-5]$");
//
//        long previousTime = System.nanoTime();
//        for (int i = 0; i < 1000000; i++) {
//            pattern1.matcher("ngram2");
//        }
//        System.out.println(String.format("timeTaken = %s", Long.toString(System.nanoTime() - previousTime)));
//
//        previousTime = System.nanoTime();
//        for (int i = 0; i < 1000000; i++) {
//            pattern2.matcher("ngram2");
//        }
//        System.out.println(String.format("timeTaken = %s", Long.toString(System.nanoTime() - previousTime)));

        SearchFields.ngramFieldOfLength(1);
        
    }

    private static void createSearchFieldWithName(String fieldName) {
        SearchField searchField = null;
        long previousTime = System.nanoTime();

        try {
            searchField = SearchFields.fromFieldName(fieldName);
        }
        catch (Exception e) {}

        System.out.println(String.format("timeTaken = %s: searchField = %s for fieldName = %s", Long.toString(System.nanoTime() - previousTime), searchField != null ? searchField.getFieldName() : "null", fieldName));
    }
}
