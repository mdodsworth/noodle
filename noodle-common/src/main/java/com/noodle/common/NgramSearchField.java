package com.noodle.common;

import java.util.regex.Pattern;

/**
 * FIXME: DOCUMENT ME!!!
 */
class NgramSearchField implements SearchField {
    
    private static final Pattern NGRAM_FIELD_PATTERN = Pattern.compile("^ngram[1-5]$]");
    private static final String NGRAM_FIELD_PREFIX = "ngram";
    private final String fieldName;

    // bunch of stuff for ngram fields

    NgramSearchField(int ngramLength) {
        this.fieldName = NGRAM_FIELD_PREFIX + Integer.toString(ngramLength);
    }

    @Override
    public String getFieldName() {
        return this.fieldName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {return false;}
        if (other == this) {return true;}
        if (other instanceof NgramSearchField) {
            NgramSearchField otherSearchField = (NgramSearchField)other;
            if (otherSearchField.getFieldName().equals(this.getFieldName())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.getFieldName().hashCode();
    }
}
