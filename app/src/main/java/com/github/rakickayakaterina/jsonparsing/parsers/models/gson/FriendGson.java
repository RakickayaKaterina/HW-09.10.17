package com.github.rakickayakaterina.jsonparsing.parsers.models.gson;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IFriend;
import com.google.gson.annotations.SerializedName;

public class FriendGson implements IFriend {
    @SerializedName("id")
    int mId;
    @SerializedName("name")
    String mName;

    @Override
    public int getId() {
        return mId;
    }

    @Override
    public String getName() {
        return mName;
    }
}
