package com.github.houbb.opencc4j.support.datamap;

import java.util.List;
import java.util.Map;

/**
 * 数据 map 接口
 * <p> project: opencc4j-IDataMap </p>
 * <p> create on 2020/5/16 19:33 </p>
 *
 * @author binbin.hou
 * @since 1.5.2
 */
public interface IDataMap {

    /**
     * 繁体=》简体 词组
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> tsPhrase();

    /**
     * 繁体=》简体 单个字
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> tsChar();

    /**
     * 简体=》繁体 词组
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> stPhrase();

    /**
     * 简体=》繁体 单个字
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> stChar();

    /**
     * 台湾常用语
     * @return 结果
     */
    Map<String, List<String>> twIdioms();

    /**
     * 台湾变体
     * @return 结果
     */
    Map<String, List<String>> twVariants();

    /**
     * 香港变体
     * @return 结果
     */
    Map<String, List<String>> hkVariants();

}
