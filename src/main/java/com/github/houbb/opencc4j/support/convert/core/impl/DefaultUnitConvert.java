package com.github.houbb.opencc4j.support.convert.core.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.support.convert.context.UnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;

import java.util.List;
import java.util.Map;

/**
 * 默认的中文单个词组/单词转换实现
 *
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public class DefaultUnitConvert implements UnitConvert {

    @Override
    public String convert(UnitConvertContext context) {
        final String unit = context.getUnit();
        final Map<String, List<String>> charMap = context.getCharData();
        final Map<String, List<String>> phaseMap = context.getPhraseData();
        final Map<String, List<String>> idiomsMap = context.getIdiomData();
        final Map<String, List<String>> variantsMap = context.getVariantsData();
        return this.getPhraseResult(unit, phaseMap, charMap, idiomsMap, variantsMap);
    }

    /**
     * 对于词组的转换
     *
     * @param original  original
     * @param phraseMap 词组集合
     * @param charMap   单个单词集合
     * @return java.lang.String
     */
    private String getPhraseResult(final String original,
                                   final Map<String, List<String>> phraseMap,
                                   final Map<String, List<String>> charMap,
                                   final Map<String, List<String>> idiomMap,
                                   final Map<String, List<String>> variantsMap) {
        // 词语列表
        List<String> phraseList = phraseMap.get(original);

        // 待处理常用语候选
        String phrase = original;
        // 默认选择第一个
        if (CollectionUtil.isNotEmpty(phraseList)) {
            phrase = phraseList.get(0);
        }

        char[] chars = phrase.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            String result = getCharResult(Character.toString(c), charMap, variantsMap);
            stringBuilder.append(result);
        }
        phrase = stringBuilder.toString();

        //常用语转换
        List<String> idiomList = idiomMap.get(phrase);

        if (CollectionUtil.isNotEmpty(idiomList)) {
            return idiomList.get(0); // 替换
        }

        return phrase;
    }

    /**
     * 对于单个生词的转换
     *
     * @param original   original
     * @param charMap    字符集合
     * @param variantMap 变体集合
     * @return java.lang.String
     */
    private String getCharResult(final String original,
                                 final Map<String, List<String>> charMap,
                                 final Map<String, List<String>> variantMap) {
        List<String> charList = charMap.get(original);
        String charStr = original;
        if (CollectionUtil.isNotEmpty(charList)) {
            charStr = charList.get(0);
        }
        List<String> variantList = variantMap.get(charStr);
        if (CollectionUtil.isNotEmpty(variantList)) { // 存在变体
            return variantList.get(0); // 返回第一个
        } else {
            return charStr; // 未找到字符替换
        }
    }

}
