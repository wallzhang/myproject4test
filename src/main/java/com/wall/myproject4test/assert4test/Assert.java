package com.wall.myproject4test.assert4test;

import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 自定义断言类,仿造spring断言
 * @author 郑昌蔚
 * @date 2020-11-24 12:38
 */
public class Assert {
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * Assert a boolean expression, throwing an {@code IllegalStateException}
     * if the expression evaluates to {@code false}.
     * <p>Call {@link #isTrue} if you wish to throw an {@code IllegalArgumentException}
     * on an assertion failure.
     * <pre class="code">
     * Assert.state(id == null,
     *     () -&gt; "ID for " + entity.getName() + " must not already be initialized");
     * </pre>
     * @param expression a boolean expression
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws IllegalStateException if {@code expression} is {@code false}
     * @since 5.0
     */
    public static void state(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new IllegalStateException(nullSafeGet(messageSupplier));
        }
    }

    /**
     * Assert a boolean expression, throwing an {@code IllegalStateException}
     * if the expression evaluates to {@code false}.
     * @deprecated as of 4.3.7, in favor of {@link #state(boolean, String)}
     */
    @Deprecated
    public static void state(boolean expression) {
        state(expression, "[Assertion failed] - this state invariant must be true");
    }

    /**
     * Assert a boolean expression, throwing an {@code IllegalArgumentException}
     * if the expression evaluates to {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
     * @param expression a boolean expression
     * @param resultCode the exception message to use if the assertion fails
     * @throws MyException if {@code expression} is {@code false}
     */
    public static void isTrue(boolean expression, ResultCode resultCode) {
        if (!expression) {
            throw new MyException(resultCode);
        }
    }




    public static void isTrue(boolean expression) {
        isTrue(expression, ResultCode.ERROR_VALID);
    }

    /**
     * Assert that an object is {@code null}.
     * <pre class="code">Assert.isNull(value, "The value must be null");</pre>
     * @param object the object to check
     * @param resultCode the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(@Nullable Object object, ResultCode resultCode) {
        if (object != null) {
            throw new MyException(resultCode);
        }
    }



    public static void isNull(@Nullable Object object) {
        isNull(object, ResultCode.PARAM_ONLY_NULL);
    }


    public static void notNull(@Nullable Object object, ResultCode resultCode) {
        if (object == null) {
            throw new MyException(resultCode);
        }
    }



    public static void notNull(@Nullable Object object) {
        notNull(object, ResultCode.NOT_EMPTY);
    }

    /**
     * 校验string类型不能为空或者"",但不能校验" "
     * @param text str
     * @param resultCode 枚举类
     */
    public static void hasLength(@Nullable String text, ResultCode resultCode) {
        if (!StringUtils.hasLength(text)) {
            throw new MyException(resultCode);
        }
    }




    public static void hasLength(@Nullable String text) {
        hasLength(text,
                ResultCode.NOT_EMPTY);
    }

    /**
     * 输入参数不能为空并且必须包含一个非空格字符
     * @param text str
     */
    public static void hasText(@Nullable String text, ResultCode resultCode) {
        if (!StringUtils.hasText(text)) {
            throw new MyException(resultCode);
        }
    }


    public static void hasText(@Nullable String text) {
        hasText(text,
                ResultCode.NOT_EMPTY);
    }

    /**
     * 参数一和参数2不能为空,并且1必须包含2
     * @param textToSearch
     * @param substring
     * @param message
     */
    public static void doesNotContain(@Nullable String textToSearch, String substring, String message) {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) &&
                textToSearch.contains(substring)) {
            throw new IllegalArgumentException(message);
        }
    }




    public static void notEmpty(@Nullable Object[] array, ResultCode resultCode) {
        if (ObjectUtils.isEmpty(array)) {
            throw new MyException(resultCode);
        }
    }





    public static void notEmpty(@Nullable Object[] array) {
        notEmpty(array, ResultCode.NOT_EMPTY);
    }

    /**
     * 数组参数不能为空
     */
    public static void noNullElements(@Nullable Object[] array, ResultCode resultCode) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new MyException(resultCode);
                }
            }
        }
    }

    /**
     * 数组参数不能为空
     */
    public static void noNullElements(@Nullable Object[] array) {
        noNullElements(array, ResultCode.NO_NULL_ELEMENTS);
    }


    public static void notEmpty(@Nullable Collection<?> collection, ResultCode resultCode) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new MyException(resultCode);
        }
    }





    public static void notEmpty(@Nullable Collection<?> collection) {
        notEmpty(collection,
                ResultCode.COLLECTION_NOT_NULL);
    }


    public static void notEmpty(@Nullable Map<?, ?> map, ResultCode resultCode) {
        if (CollectionUtils.isEmpty(map)) {
            throw new MyException(resultCode);
        }
    }


    public static void notEmpty(@Nullable Map<?, ?> map) {
        notEmpty(map, ResultCode.NOT_EMPTY);
    }

    /**
     * 参数不能为空并且第一个参数一定能被构造成第二个个参数类型
     * @param type
     * @param obj
     * @param message
     */
    public static void isInstanceOf(Class<?> type, @Nullable Object obj, String message) {
        notNull(type, ResultCode.NOT_EMPTY);
        if (!type.isInstance(obj)) {
            instanceCheckFailed(type, obj, message);
        }
    }




    public static void isInstanceOf(Class<?> type, @Nullable Object obj) {
        isInstanceOf(type, obj, "");
    }




    private static void instanceCheckFailed(Class<?> type, @Nullable Object obj, @Nullable String msg) {
        String className = (obj != null ? obj.getClass().getName() : "null");
        String result = "";
        boolean defaultMessage = true;
        if (StringUtils.hasLength(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            }
            else {
                result = messageWithTypeName(msg, className);
                defaultMessage = false;
            }
        }
        if (defaultMessage) {
            result = result + ("Object of class [" + className + "] must be an instance of " + type);
        }
        throw new IllegalArgumentException(result);
    }



    private static boolean endsWithSeparator(String msg) {
        return (msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith("."));
    }

    private static String messageWithTypeName(String msg, @Nullable Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }

    @Nullable
    private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
