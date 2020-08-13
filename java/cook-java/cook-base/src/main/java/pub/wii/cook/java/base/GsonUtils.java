package pub.wii.cook.java.base;

import com.google.gson.*;

import java.lang.reflect.Type;

public class GsonUtils {
    static GsonBuilder gsonBuilder = new GsonBuilder();
    private static final Gson gson = new Gson();
    public static final Gson GSON = gsonBuilder
            .registerTypeAdapter(Double.class, new DoubleAdapter())
            .registerTypeAdapter(Float.class, new FloatAdapter())
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                    return fieldAttributes.getName().equals("__isset_bit_vector");
                }

                @Override
                public boolean shouldSkipClass(Class<?> aClass) {
                    return false;
                }
            })
            .create();

    private static class DoubleAdapter implements JsonSerializer<Double> {
        @Override
        public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
            if (src == null || Double.isNaN(src) || Double.isInfinite(src)) {
                return null;
            } else {
                return gson.toJsonTree(src);
            }
        }
    }

    private static class FloatAdapter implements JsonSerializer<Float> {
        @Override
        public JsonElement serialize(Float src, Type typeOfSrc, JsonSerializationContext context) {
            if (src == null || Float.isNaN(src) || Float.isInfinite(src)) {
                return gson.toJsonTree(0);
            } else {
                return gson.toJsonTree(src);
            }
        }
    }
}