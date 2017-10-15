package com.github.rakickayakaterina.jsonparsing.parsers.models.json;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IFriend;

import org.json.JSONObject;

public class FriendJson implements IFriend {

    public static final String ID = "id";
    public static final String NAME = "name";
    JSONObject mJSONObject;

    public FriendJson(JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public int getId() {
        return mJSONObject.optInt(ID);
    }

    @Override
    public String getName() {
        return mJSONObject.optString(NAME);
    }
}
