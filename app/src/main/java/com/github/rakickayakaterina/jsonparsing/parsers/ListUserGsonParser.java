package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.gson.UserGson;
import com.github.rakickayakaterina.jsonparsing.parsers.models.gson.UserGsonList;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Arrays;

public class ListUserGsonParser implements IListUserParser {
    String mSource;

    public ListUserGsonParser(String pSource) {
        mSource = pSource;
    }

    @Override
    public IListUser parse() throws JSONException {
        final IUser[] gsonUsers = new Gson().fromJson(mSource,UserGson[].class);
        return new UserGsonList(Arrays.asList(gsonUsers));
    }
}
