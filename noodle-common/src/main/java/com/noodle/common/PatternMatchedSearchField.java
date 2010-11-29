package com.noodle.common;

import java.util.regex.Pattern;

/**
 * FIXME: DOCUMENT ME!!!
 */
enum PatternMatchedSearchField {

    NGRAM_FIELD("ngram[1-5]" /* stuff */),
    SOME_OTHER_FIELD("somePattern[1-3]"),
    ;

    private final Pattern pattern;

    PatternMatchedSearchField(String fieldNamePattern) {
        this.pattern = Pattern.compile(fieldNamePattern);
    }

    SearchField getSearchField(String fieldName) {
        return new DynamicSearchField(fieldName);
    }

    boolean matches(String fieldName) {
        return pattern.matcher(fieldName).matches();
    }

    //======== helper classes ========//

    private static class DynamicSearchField implements SearchField {

        private final String fieldName;

        private DynamicSearchField(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String getFieldName() {
            return fieldName;
        }
    }
}
