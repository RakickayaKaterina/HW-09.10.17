package com.github.rakickayakaterina.jsonparsing.parsers.models;

import java.util.Date;
import java.util.List;

public interface IUser {

    String getId();

    int getIndex();

    String getGuid();

    boolean getIsActive();

    String getBalance();

    String getPicture();

    int getAge();

    String getName();

    String getGender();

    Date getRegistered();

    List<String> getTags();

    List<IFriend> getFriends();
}
