package fr.cg95.cvq.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class JSONUtils {

    private static final GsonBuilder gsonBuilder = new GsonBuilder();
    static {
        gsonBuilder.registerTypeAdapter(JsonObject.class, new JsonDeserializer<JsonObject>() {
            @Override
            public JsonObject deserialize(JsonElement arg0, @SuppressWarnings("unused") Type arg1,
                @SuppressWarnings("unused") JsonDeserializationContext arg2)
                throws JsonParseException {
                return arg0.getAsJsonObject();
            }
        });
    }

    public static JsonObject deserialize(String payload) {
        Gson gson = gsonBuilder.create();
        return gson.fromJson(payload, JsonObject.class);
    }
}
