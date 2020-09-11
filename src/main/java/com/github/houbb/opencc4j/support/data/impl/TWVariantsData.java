package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.Data;

import java.util.List;
import java.util.Map;

public class TWVariantsData implements Data {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (TSPhraseData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/TWVariants.txt");
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("台湾变体数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }
}
