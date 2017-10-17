package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.gson.UserGson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.util.Date;

class UserGsonParser implements IUserParser {

    private final String mSource;

    public UserGsonParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws JSONException {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class,new TypeAdapter()).create();
        return gson.fromJson(mSource, UserGson.class);
    }
}
