package com.mfh.table.utils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;


/**
 * @Author: mfh
 * @Date: 2019-02-02 17:25
 **/
public class ReflectionUtils {
    /**
     * 执行set方法，参数类型为String
     * @param t
     * @param field
     * @param val
     * @param <T>
     */
    public static <T> void invokeSetMethodWithStringTypeParams(T t, String field, String val) {
        String methodPrefix = "set";
            try {
                Method method = t.getClass().getMethod(methodPrefix + upperCase(field), String.class);
                invokeMethod(method, t, val);
            } catch (NoSuchMethodException e) {
                recordLog(e);
            }
    }

    public static <T> Object invokeGetMethod(T t, String field) {
        String methodPrefix = "get";
            try {
                Method method = t.getClass().getMethod(methodPrefix + upperCase(field));
                return invokeMethod(method, t);
            } catch (NoSuchMethodException e) {
                recordLog(e);
            }
        return null;
    }

    private static void recordLog(Exception e) {
        e.printStackTrace();
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    private static String upperCase(String str) {
        char[] cs = str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, new Object[0]);
    }

    public static Object invokeMethod(Method method, Object target, Object... args) {
        try {
            return method.invoke(target, args);
        }
        catch (Exception ex) {
            handleReflectionException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    public static void handleReflectionException(Exception ex) {
        if (ex instanceof NoSuchMethodException) {
            throw new IllegalStateException("Method not found: " + ex.getMessage());
        }
        if (ex instanceof IllegalAccessException) {
            throw new IllegalStateException("Could not access method: " + ex.getMessage());
        }
        if (ex instanceof InvocationTargetException) {
            handleInvocationTargetException((InvocationTargetException) ex);
        }
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }

    public static void handleInvocationTargetException(InvocationTargetException ex) {
        rethrowRuntimeException(ex.getTargetException());
    }

    public static void rethrowRuntimeException(Throwable ex) {
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }
}
