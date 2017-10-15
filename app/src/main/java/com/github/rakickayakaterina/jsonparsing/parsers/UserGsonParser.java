package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.gson.UserGson;
import com.google.gson.Gson;

import org.json.JSONException;

public class UserGsonParser implements IUserParser {

    String mSource;

    public UserGsonParser(String pSource) {
        mSource = pSource;
    }



    @Override
    public IUser parse() throws JSONException {
        return new Gson().fromJson(mSource, UserGson.class);
    }
}
