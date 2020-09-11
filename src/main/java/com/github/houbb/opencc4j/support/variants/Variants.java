package com.github.houbb.opencc4j.support.variants;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.opencc4j.support.variants.impl.HKVariant;
import com.github.houbb.opencc4j.support.variants.impl.NoVariant;
import com.github.houbb.opencc4j.support.variants.impl.TWVariant;

public class Variants {

    private Variants() {}

    public static Variant defaults() {
        return Instances.singleton(NoVariant.class);
    }

    public static Variant tw() {
        return Instances.singleton(TWVariant.class);
    }

    public static Variant hk() {
        return Instances.singleton(HKVariant.class);
    }
}
