package info.garagesalesapp.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDisplay implements JsonInterface {

    @Override
    public String showJson(Object object) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(object);
        System.out.println(json);
        return null;
    }
}
