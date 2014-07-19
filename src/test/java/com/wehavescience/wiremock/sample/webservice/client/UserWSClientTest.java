package com.wehavescience.wiremock.sample.webservice.client;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.wehavescience.wiremock.sample.model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.wehavescience.wiremock.sample.utils.XMLUtils.asXml;
import static org.junit.Assert.assertEquals;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class UserWSClientTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    private UserWSClient userService;

    @Before
    public void setUp() throws Exception {
        stubFor(post(urlMatching("/ws/users/1"))
                .withHeader("Content-Type", equalTo("application/xml"))
                .withRequestBody(equalToXml(asXml(createUserMock())))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(asXml(createUserMock()))));

        stubFor(get(urlEqualTo("/ws/users/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withBody(asXml(createUserMock()))));

        userService = new UserWSClient("http://localhost:8089/ws/users/");
    }

    @Test
    public void testAddUser() throws Exception {
        User response = userService.addUser(createUserMock());
        assertEquals(response, createUserMock());
    }

    @Test
    public void testFetchUser() throws Exception {
        User response = userService.fetchUser(createUserMock().getId());
        assertEquals(response, createUserMock());
    }

    private User createUserMock() {
        return new User(1, "Gabriel", 21, "Systems Analyst");
    }
}