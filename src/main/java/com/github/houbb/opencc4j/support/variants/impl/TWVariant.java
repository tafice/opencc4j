package com.github.houbb.opencc4j.support.variants.impl;

import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;
import com.github.houbb.opencc4j.support.variants.Variant;

import java.util.List;
import java.util.Map;

public class TWVariant implements Variant {

    @Override
    public Map<String, List<String>> data() {
        return OpenccDatas.twVariants().data().getDataMap();
    }
}
