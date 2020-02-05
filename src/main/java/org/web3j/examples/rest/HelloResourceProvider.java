package org.web3j.examples.rest;

import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.email.EmailException;
import org.keycloak.email.EmailSenderProvider;
import org.keycloak.models.KeycloakContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.services.resource.RealmResourceProvider;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class HelloResourceProvider implements RealmResourceProvider {

    private KeycloakSession session;

    public HelloResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return this;
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain; charset=utf-8")
    public String createUserToken(@FormParam("email") String email) throws EmailException {

        Map<String, String> config = session.getContext().getRealm().getSmtpConfig();
        RealmModel realmModel = session.getContext().getRealm();
        UserModel userModel = session.users().getUserByEmail(email, session.getContext().getRealm());
        if (userModel == null) {
            userModel = session.users().addUser(realmModel, UUID.randomUUID().toString(), email, false, false);
            userModel.setEmail(email);
        }

        String userId = userModel.getId();

        Web3jToken token = new Web3jToken();
        token.setUserId(userId);
        token.setToken(UUID.randomUUID().toString());

        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        em.persist(token);

        session.getProvider(EmailSenderProvider.class).send(config, userModel, "Email Validation", "Please validate your account", "Please validate your account");

        return token.getToken();
    }

    @Override
    public void close() {
    }


}