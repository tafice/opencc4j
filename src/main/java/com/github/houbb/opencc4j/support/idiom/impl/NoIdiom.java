package com.github.houbb.opencc4j.support.idiom.impl;

import com.github.houbb.opencc4j.support.idiom.Idiom;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NoIdiom implements Idiom {

    @Override
    public Map<String, List<String>> data() {
        return Collections.emptyMap();
    }
}
