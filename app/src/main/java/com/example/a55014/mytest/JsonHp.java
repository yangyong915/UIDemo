package com.example.a55014.mytest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import org.json.JSONException;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 地址： https://sites.google.com/site/gson/gson-user-guide#TOC-Serializing-and-
 * Deserializing-Gener
 */
public class JsonHp {

    private static Gson mGsonConverter;

    /**
     * json数据反序列化
     */
    @SuppressWarnings("unchecked")
    public static <T> T Deserializate(String jsonStr, Class<T> tclass) throws JSONException {
        return (T) getGsonConverter().fromJson(jsonStr, tclass);
    }

    /**
     * json数据反序列化(泛型)
     */
    @SuppressWarnings("unchecked")
    public static <T> T Deserializate(String jsonStr, TypeToken<T> typeToken) throws JSONException {
        return (T) getGsonConverter().fromJson(jsonStr, typeToken.getType());
    }

    /**
     * json数据序列化
     */
    public static <T> String Serialization(T tclass) throws JSONException {
        String json = getGsonConverter().toJson(tclass);
        return json;
    }

    /**
     * 获取通用的gson转换器
     *
     * @return
     * @author zqs
     * @createTime 2016年6月30日 下午11:02:31
     */
    public static Gson getGsonConverter() {
        if (mGsonConverter == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.serializeNulls();
            gsonBuilder.setExclusionStrategies(new MyExclusionStrategy());
            gsonBuilder.registerTypeAdapter(String.class, new DeserializateStringAdapter());
            gsonBuilder.registerTypeAdapter(Boolean.class, new DeserializateBooleanAdapter());
            gsonBuilder.registerTypeAdapter(boolean.class, new DeserializateBooleanAdapter());
            gsonBuilder.disableHtmlEscaping();
            mGsonConverter = gsonBuilder.create();
        }
        return mGsonConverter;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public @interface Foo {
    }

    public static class MyExclusionStrategy implements ExclusionStrategy {

        @Override
        public boolean shouldSkipClass(Class<?> arg0) {
            return false;
        }

        @Override
        public boolean shouldSkipField(FieldAttributes arg0) {
            return arg0.getAnnotation(Foo.class) != null;
        }

    }

    /**
     * 可以将json中的null——》string 转成空串；
     * 即 将服务端返回的String null类型的值强制转成""（空串）
     *
     * @author zqs
     * @createTime 2016年6月30日 下午10:39:19
     */
    private static class DeserializateStringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }

    /**
     * 可以将json串中的 0，1， 转换成boolean；
     * 即 boolean 支持将 1，0, "1","0" 转换成对应的true、false
     *
     * @author zqs
     * @createTime 2016年6月30日 下午10:40:19
     */
    private static class DeserializateBooleanAdapter extends TypeAdapter<Boolean> {
        public Boolean read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return false;
            }
            try {
                return reader.nextBoolean(); // 如果是true false 正常转换
            } catch (Exception e) {
                // e.printStackTrace();
                try {
                    return reader.nextInt() != 0; // 如果是数组类型
                } catch (Exception e2) {
                    // e2.printStackTrace();
                    try {
                        String s = reader.nextString(); // 如果是string类型
                        if (s.equals("0") || s.equals("")) {
                            return false;
                        }
                        return true;
                    } catch (Exception e3) {
                    }
                }
            }
            return false;
        }

        public void write(JsonWriter writer, Boolean value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
