package com.github.houbb.opencc4j.support.variants.impl;

import com.github.houbb.opencc4j.support.variants.Variant;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NoVariant implements Variant {

    @Override
    public Map<String, List<String>> data() {
        return Collections.emptyMap();
    }
}
