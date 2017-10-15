package com.github.rakickayakaterina.jsonparsing.parsers.models.json;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IFriend;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserJson implements IUser {

    private static final String ID = "_id";
    private static final String INDEX = "index";
    private static final String GUID = "guid";
    private static final String IS_ACTIVE = "isActive";
    private static final String BALANCE = "balance";
    private static final String PICTURE = "picture";
    private static final String AGE = "age";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String REGISTERED = "registered";
    private static final String TAGS = "tags";
    private static final String FRIENDS = "friends";
    private final JSONObject mJSONObject;

    public UserJson(final JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public String getId() {
        return mJSONObject.optString(ID);
    }

    @Override
    public int getIndex() {
        return mJSONObject.optInt(INDEX);
    }

    @Override
    public String getGuid() {
        return mJSONObject.optString(GUID);
    }

    @Override
    public boolean getIsActive() {
        return mJSONObject.optBoolean(IS_ACTIVE);
    }

    @Override
    public String getBalance() {
        return mJSONObject.optString(BALANCE);
    }

    @Override
    public String getPicture() {
        return mJSONObject.optString(PICTURE);
    }

    @Override
    public int getAge() {
        return mJSONObject.optInt(AGE);
    }

    @Override
    public String getName() {
        return mJSONObject.optString(NAME);
    }

    @Override
    public String getGender() {
        return mJSONObject.optString(GENDER);
    }

    @Override
    public Date getRegistered() {
        return new Date(mJSONObject.optLong(REGISTERED));
    }

    @Override
    public List<String> getTags() {
        final JSONArray jsonArray = mJSONObject.optJSONArray(TAGS);
        final List<String> tags = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tags.add(jsonArray.optString(i));
        }
        return tags;
    }

    @Override
    public List<IFriend> getFriends() {
        final JSONArray jsonArray = mJSONObject.optJSONArray(FRIENDS);
        final List<IFriend> friends = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            friends.add(new FriendJson(jsonArray.optJSONObject(i)));
        }
        return friends;
    }
}
