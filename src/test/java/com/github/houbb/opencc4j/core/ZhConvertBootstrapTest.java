package com.github.houbb.opencc4j.core;

import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import com.github.houbb.opencc4j.support.idiom.Idioms;
import com.github.houbb.opencc4j.support.segment.impl.Segments;
import com.github.houbb.opencc4j.support.variants.Variants;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * 中文转换引导类测试
 * @author binbin.hou
 * @since 1.1.0
 */
public class ZhConvertBootstrapTest {

    /**
     * 转换为简体测试
     * @since 1.1.0
     */
    @Test
    public void toSimpleTest() {
        final String original = "生命不息，奮鬥不止";
        final String result = ZhConvertBootstrap.newInstance().toSimple(original);
        Assert.assertEquals("生命不息，奋斗不止", result);
    }

    /**
     * 转换为繁体测试
     * @since 1.1.0
     */
    @Test
    public void toTraditionalTest() {
        final String original = "生命不息，奋斗不止";
        final String result = ZhConvertBootstrap.newInstance().toTraditional(original);
        Assert.assertEquals("生命不息，奮鬥不止", result);
    }

    /**
     * 设置分词测试
     * @since 1.1.0
     */
    @Test
    public void segmentTest() {
        final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
        final String result = ZhConvertBootstrap.newInstance().toTraditional(original);
        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。", result);

        final String result2 = ZhConvertBootstrap.newInstance().segment(new FooSegment()).toTraditional(original);
        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result2);
    }

    /**
     * 初始化时制定分词类型测试
     * （1）默认是花瓣分词
     * （2）我们测试的时候，直接指定为自定义的分词类型。
     * @since 1.2.0
     */
    @Test
    public void segment2Test() {
        final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
        final String result = ZhConvertBootstrap.newInstance(new FooSegment()).toTraditional(original);
        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
    }

    /**
     * 是否为简体测试
     * @since 1.2.0
     */
    @Test
    public void isSimpleTest() {
        final String simpleChar = "奋";
        final String simplePhrase = "奋斗";
        final String traditionalChar = "奮";
        final String traditionalPhrase = "奮鬥";

        ZhConvertBootstrap convertBootstrap = ZhConvertBootstrap.newInstance();

        Assert.assertTrue(convertBootstrap.isSimple(simpleChar));
        Assert.assertTrue(convertBootstrap.isSimple(simplePhrase));
        Assert.assertFalse(convertBootstrap.isSimple(traditionalChar));
        Assert.assertFalse(convertBootstrap.isSimple(traditionalPhrase));
    }

    /**
     * 是否为繁体测试
     * @since 1.2.0
     */
    @Test
    public void isTraditional() {
        final String simpleChar = "奋";
        final String simplePhrase = "奋斗";
        final String traditionalChar = "奮";
        final String traditionalPhrase = "奮鬥";

        ZhConvertBootstrap convertBootstrap = ZhConvertBootstrap.newInstance();

        Assert.assertTrue(convertBootstrap.isTraditional(traditionalChar));
        Assert.assertTrue(convertBootstrap.isTraditional(traditionalPhrase));
        Assert.assertFalse(convertBootstrap.isTraditional(simpleChar));
        Assert.assertFalse(convertBootstrap.isTraditional(simplePhrase));
    }

    /**
     * 获取简体字（词）列表
     * @since 1.2.0
     */
    @Test
    @Ignore
    public void simpleListTest() {
        final String original = "生命不息奋斗不止";
        ZhConvertBootstrap zhConvertBootstrap = ZhConvertBootstrap.newInstance();
        final List<String> resultList = zhConvertBootstrap.simpleList(original);

        String expectToString = "[生, 命, 不, 息, 奋斗, 不, 止]";
        Assert.assertEquals(expectToString, resultList.toString());
    }

    /**
     * 获取繁体字（词）列表
     * @since 1.2.0
     */
    @Test
    public void traditionalListTest() {
        final String original = "生命不息奮鬥不止";
        ZhConvertBootstrap zhConvertBootstrap = ZhConvertBootstrap.newInstance();
        final List<String> resultList = zhConvertBootstrap.traditionalList(original);

        String expectToString = "[奮, 鬥]";
        Assert.assertEquals(expectToString, resultList.toString());
    }

    @Test
    public void simpleToTraditionalWithIdiomsAndVariantsTest() {
        final String original = "鼠标里面的硅二极管坏了，导致光标分辨率降低。\n" +
                "我们在老挝的服务器的硬盘需要使用互联网算法软件解决异步的问题。\n" +
                "为什么你在床里面睡着？";
        final String ans = "滑鼠裡面的矽二極體壞了，導致游標解析度降低。\n" +
                "我們在寮國的伺服器的硬碟需要使用網際網路演算法軟體解決非同步的問題。\n" +
                "為什麼你在床裡面睡著？";
        ZhConvertBootstrap bootstrap = ZhConvertBootstrap
                .newInstance()
                .segment(Segments.huaBan())
                .variant(Variants.tw())
                .idiom(Idioms.tw());
        String actual = bootstrap.toTraditional(original);
        Assert.assertEquals(ans, actual);
    }

}
