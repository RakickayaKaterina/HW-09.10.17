package com.github.rakickayakaterina.jsonparsing;

import com.github.rakickayakaterina.jsonparsing.http.IHttpClient;
import com.github.rakickayakaterina.jsonparsing.mocks.Mocks;
import com.github.rakickayakaterina.jsonparsing.parsers.IUserParser;
import com.github.rakickayakaterina.jsonparsing.parsers.ParserFactory;
import com.github.rakickayakaterina.jsonparsing.parsers.UserGsonParser;
import com.github.rakickayakaterina.jsonparsing.parsers.UserJsonParser;
import com.github.rakickayakaterina.jsonparsing.parsers.models.IUser;
import com.github.rakickayakaterina.jsonparsing.utils.IOUtils;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = 21
)
public class ParserTest {

    public static final String USER_JSON = "user.json";
    InputStream httpStream = Mocks.stream(USER_JSON);
    IHttpClient mHttpClient = mock(IHttpClient.class);

    @Before
    public void init() {
        when(mHttpClient.request(Matchers.anyString())).thenReturn(httpStream);
    }

    @Test
    public void UserJsonTest() throws IOException, JSONException {

        IUserParser userJsonParser = ParserFactory.createParser(ParserFactory.JSON, IOUtils.toString(httpStream));
        IUser user = userJsonParser.parse();
        assertEquals("Jacobson Mclaughlin", user.getName());
        assertEquals(26, user.getAge());
        assertEquals("Alissa Goodman", user.getFriends().get(0).getName());
    }

    @Test
    public void UserGsonTest() throws IOException, JSONException {

        IUserParser userGsonParser = ParserFactory.createParser(ParserFactory.GSON, IOUtils.toString(httpStream));
        IUser user = userGsonParser.parse();
        assertEquals("Jacobson Mclaughlin", user.getName());
        assertEquals(26, user.getAge());
        assertEquals("Alissa Goodman", user.getFriends().get(0).getName());
    }
}