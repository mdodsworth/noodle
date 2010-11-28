package com.noodle.common;

/**
 * FIXME: DOCUMENT ME!!!
 */
public final class SearchFields {
    private SearchFields() {}

    SearchField ngramFieldOfLength(int ngramLength) {
        // memoize these
        return new NgramSearchField(ngramLength);
    }

    SearchField fromFieldName(String fieldName) {
        return null;
    }
}
