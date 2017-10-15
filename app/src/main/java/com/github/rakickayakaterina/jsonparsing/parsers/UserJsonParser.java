package com.github.rakickayakaterina.jsonparsing.parsers;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.json.UserJson;

import org.json.JSONException;
import org.json.JSONObject;

public class UserJsonParser implements IUserParser {

    String mSource;

    public UserJsonParser(String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws JSONException {
        return new UserJson(new JSONObject(mSource));
    }
}
