package me.javaroad.mcloud.common.web;

import java.util.TimeZone;

public abstract class BaseApplication {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
