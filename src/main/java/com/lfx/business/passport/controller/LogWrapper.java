package com.lfx.business.passport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * @author liufeixiang
 * @date 2019-07-05 12:55
 */
public class LogWrapper implements Logger {
    private final Logger logger;

    public LogWrapper(String name) {
        this.logger = LoggerFactory.getLogger(name);
    }

    public LogWrapper(Class<?> classType) {
        this.logger = LoggerFactory.getLogger(classType);
    }

    public String getName() {
        return this.logger.getName();
    }

    public boolean isTraceEnabled() {
        return this.logger.isDebugEnabled();
    }

    public void trace(String msg) {
        this.logger.trace(msg);
    }

    public void trace(String format, Object arg) {
        this.logger.trace(format, arg);
    }

    public void trace(String format, Object arg1, Object arg2) {
        this.logger.trace(format, arg1, arg2);
    }

    public void trace(String format, Object... arguments) {
        this.logger.trace(format, arguments);
    }

    public void trace(String msg, Throwable t) {
        this.logger.trace(msg, t);
    }

    public boolean isTraceEnabled(Marker marker) {
        return this.logger.isDebugEnabled(marker);
    }

    public void trace(Marker marker, String msg) {
        this.logger.trace(marker, msg);
    }

    public void trace(Marker marker, String format, Object arg) {
        this.logger.trace(marker, format, arg);
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.trace(marker, format, arg1, arg2);
    }

    public void trace(Marker marker, String format, Object... argArray) {
        this.logger.trace(marker, format, argArray);
    }

    public void trace(Marker marker, String msg, Throwable t) {
        this.logger.trace(marker, msg, t);
    }

    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    public void debug(String msg) {
        this.logger.debug(msg);
    }

    public void debug(String format, Object arg) {
        this.logger.debug(format, arg);
    }

    public void debug(String format, Object arg1, Object arg2) {
        this.logger.debug(format, arg1, arg2);
    }

    public void debug(String format, Object... arguments) {
        this.logger.debug(format, arguments);
    }

    public void debug(String msg, Throwable t) {
        this.logger.debug(msg, t);
    }

    public boolean isDebugEnabled(Marker marker) {
        return this.logger.isDebugEnabled(marker);
    }

    public void debug(Marker marker, String msg) {
        this.logger.debug(marker, msg);
    }

    public void debug(Marker marker, String format, Object arg) {
        this.logger.debug(marker, format, arg);
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.debug(marker, format, arg1);
    }

    public void debug(Marker marker, String format, Object... arguments) {
        this.logger.debug(marker, format, arguments);
    }

    public void debug(Marker marker, String msg, Throwable t) {
        this.logger.debug(marker, msg, t);
    }

    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    public void info(String msg) {
        this.logger.info(msg);
    }

    public void info(String format, Object arg) {
        this.logger.info(format, arg);
    }

    public void info(String format, Object arg1, Object arg2) {
        this.logger.info(format, arg1, arg2);
    }

    public void info(String format, Object... arguments) {
        this.logger.info(format, arguments);
    }

    public void info(String msg, Throwable t) {
        this.logger.info(msg, t);
    }

    public boolean isInfoEnabled(Marker marker) {
        return this.logger.isInfoEnabled(marker);
    }

    public void info(Marker marker, String msg) {
        this.logger.info(marker, msg);
    }

    public void info(Marker marker, String format, Object arg) {
        this.logger.info(marker, format, arg);
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.info(marker, format, arg1, arg2);
    }

    public void info(Marker marker, String format, Object... arguments) {
        this.logger.info(marker, format, arguments);
    }

    public void info(Marker marker, String msg, Throwable t) {
        this.logger.info(marker, msg, t);
    }

    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    public void warn(String msg) {
        this.logger.warn(msg);
    }

    public void warn(String format, Object arg) {
        this.logger.warn(format, arg);
    }

    public void warn(String format, Object... arguments) {
        this.logger.warn(format, arguments);
    }

    public void warn(String format, Object arg1, Object arg2) {
        this.logger.warn(format, arg1, arg2);
    }

    public void warn(String msg, Throwable t) {
        this.logger.warn(msg, t);
    }

    public boolean isWarnEnabled(Marker marker) {
        return this.logger.isWarnEnabled(marker);
    }

    public void warn(Marker marker, String msg) {
        this.logger.warn(marker, msg);
    }

    public void warn(Marker marker, String format, Object arg) {
        this.logger.warn(marker, format, arg);
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.warn(marker, format, arg1, arg2);
    }

    public void warn(Marker marker, String format, Object... arguments) {
        this.logger.warn(marker, format, arguments);
    }

    public void warn(Marker marker, String msg, Throwable t) {
        this.logger.warn(marker, msg, t);
    }

    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    public void error(String msg) {
        this.logger.error(msg);
    }

    public void error(String format, Object arg) {
        this.logger.error(format, arg);
    }

    public void error(String format, Object arg1, Object arg2) {
        this.logger.error(format);
    }

    public void error(String format, Object... arguments) {
        this.logger.error(format, arguments);
    }

    public void error(String msg, Throwable t) {
        this.logger.error(msg, t);
    }

    public boolean isErrorEnabled(Marker marker) {
        return this.logger.isErrorEnabled();
    }

    public void error(Marker marker, String msg) {
        this.logger.error(marker, msg);
    }

    public void error(Marker marker, String format, Object arg) {
        this.logger.debug(marker, format, arg);
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.error(marker, format, arg1, arg2);
    }

    public void error(Marker marker, String format, Object... arguments) {
        this.logger.error(marker, format, arguments);
    }

    public void error(Marker marker, String msg, Throwable t) {
        this.logger.error(marker, msg, t);
    }
}
