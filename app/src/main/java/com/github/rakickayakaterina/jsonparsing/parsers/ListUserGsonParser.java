package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.gson.UserGson;
import com.github.rakickayakaterina.jsonparsing.parsers.models.gson.UserGsonList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.util.Arrays;
import java.util.Date;

class ListUserGsonParser implements IListUserParser {

    private final String mSource;

    public ListUserGsonParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IListUser parse() throws JSONException {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class,new TypeAdapter()).create();
        final IUser[] gsonUsers = gson.fromJson(mSource, UserGson[].class);
        return new UserGsonList(Arrays.asList(gsonUsers));
    }
}
