package com.wehavescience.wiremock.sample.webservice.client;

import com.wehavescience.wiremock.sample.model.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class UserWSClient {
    private final String url;

    public UserWSClient(final String url) {
        this.url = url;
    }

    public User addUser(User user) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url).path(String.valueOf(user.getId()));

        return webTarget
                    .request(MediaType.APPLICATION_XML)
                    .accept(MediaType.APPLICATION_XML)
                    .post(Entity.entity(user, MediaType.APPLICATION_XML), User.class);
    }

    public User fetchUser(int id) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url).path(String.valueOf(id));
        Response response = webTarget
                                .request()
                                .accept(MediaType.APPLICATION_XML_TYPE)
                                .get();

        return response.readEntity(User.class);
    }
}
