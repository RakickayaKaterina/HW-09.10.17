package com.github.rakickayakaterina.jsonparsing.parsers.models.gson;

import com.github.rakickayakaterina.jsonparsing.parsers.models.IListUser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;

import java.util.List;

public class UserGsonList implements IListUser {

    List<IUser> mUserList;

    public UserGsonList(List<IUser> pUserList) {
        mUserList = pUserList;
    }

    @Override
    public List<IUser> getListUser() {

        return mUserList;
    }
}
