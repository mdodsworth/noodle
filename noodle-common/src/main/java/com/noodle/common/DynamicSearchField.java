package com.noodle.common;

import java.util.regex.Pattern;

/**
 * FIXME: DOCUMENT ME!!!
 */
enum DynamicSearchField {

    NGRAM_FIELD("^ngram[1-5]$" /* stuff */),
    SOME_OTHER_FIELD("somePattern[1-3]"),
    ;

    private final Pattern pattern;

    DynamicSearchField(String fieldNamePattern) {
        this.pattern = Pattern.compile(fieldNamePattern);
    }

    SearchField getSearchField(String fieldName) {
        return null;
    }

    boolean matches(String fieldName) {
        return pattern.matcher(fieldName).matches();
    }
}
