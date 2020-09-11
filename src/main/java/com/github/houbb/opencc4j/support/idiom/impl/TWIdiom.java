package com.github.houbb.opencc4j.support.idiom.impl;

import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;
import com.github.houbb.opencc4j.support.idiom.Idiom;

import java.util.List;
import java.util.Map;

public class TWIdiom implements Idiom {

    @Override
    public Map<String, List<String>> data() {
        return OpenccDatas.twIdioms().data().getDataMap();
    }
}
