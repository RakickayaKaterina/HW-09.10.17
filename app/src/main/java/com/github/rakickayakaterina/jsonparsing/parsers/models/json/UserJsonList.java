package com.github.rakickayakaterina.jsonparsing.parsers.models.json;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;

import java.util.List;

public class UserJsonList implements IListUser {

    private final List<IUser> mUserList;

    public UserJsonList(final List<IUser> pUserList) {
        mUserList = pUserList;
    }

    @Override
    public List<IUser> getListUser() {

        return mUserList;
    }
}
