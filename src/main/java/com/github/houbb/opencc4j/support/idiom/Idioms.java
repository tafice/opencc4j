package com.github.houbb.opencc4j.support.idiom;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.opencc4j.support.idiom.impl.NoIdiom;
import com.github.houbb.opencc4j.support.idiom.impl.TWIdiom;

public class Idioms {
    private Idioms() {}

    public static Idiom defaults() {
        return Instances.singleton(NoIdiom.class);
    }

    public static Idiom tw() {
        return Instances.singleton(TWIdiom.class);
    }
}
