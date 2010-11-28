package com.noodle.common;

/**
 * FIXME: DOCUMENT ME!!!
 */
public enum StandardSearchField implements SearchField {

    FIELD_NAME("field_name"/*, some stuff */);

    private final String fieldName;

    StandardSearchField(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String getFieldName() {
        return this.fieldName;
    }
}
