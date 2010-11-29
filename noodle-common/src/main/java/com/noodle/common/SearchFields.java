package com.noodle.common;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapMaker;

import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

/**
 * FIXME: DOCUMENT ME!!!
 */
public final class SearchFields {
    private SearchFields() {}

    private static final Function<String,SearchField> DYNAMIC_SEARCH_FIELD_CREATION_FUNCTION = new Function<String, SearchField>() {
        @Override
        public SearchField apply(String fieldName) {

            for (PatternMatchedSearchField dynamicSearchField : PatternMatchedSearchField.values()) {
                if (dynamicSearchField.matches(fieldName)) {
                    return dynamicSearchField.getSearchField(fieldName);
                }
            }

            throw new IllegalArgumentException("unknown search field: " + fieldName);
        }
    };

    private static final Map<String, SearchField> dynamicSearchFieldCache = new MapMaker().initialCapacity(8).softValues().makeComputingMap(DYNAMIC_SEARCH_FIELD_CREATION_FUNCTION);
    private static final Map<String, SearchField> standardSearchFieldMap = StandardSearchFieldCacheHolder.getCache(); // overkill

    public static SearchField ngramFieldOfLength(int ngramLength) {
        return fromFieldName("ngram" + Integer.toString(ngramLength));
    }

    public static SearchField fromFieldName(String fieldName) {
        checkArgument(isNotEmpty(fieldName));

        // check the standard fields
        if (standardSearchFieldMap.containsKey(fieldName)) {
            return standardSearchFieldMap.get(fieldName);
        }
        // check the dynamic field cache
        else {
            return dynamicSearchFieldCache.get(fieldName);
        }
    }

    private static class StandardSearchFieldCacheHolder {
        private static final Map<String, SearchField> cache = initializeCache();

        private static Map<String, SearchField> initializeCache() {
            ImmutableMap.Builder<String, SearchField> cacheMapBuilder = ImmutableMap.builder();

            for (StandardSearchField standardSearchField : StandardSearchField.values()) {
                cacheMapBuilder.put(standardSearchField.getFieldName(), standardSearchField);
            }

            return cacheMapBuilder.build();
        }

        public static Map<String, SearchField> getCache() {
            return cache;
        }
    }
}
