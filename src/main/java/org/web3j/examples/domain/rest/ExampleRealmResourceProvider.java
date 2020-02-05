package org.web3j.examples.domain.rest;

import javax.ws.rs.*;
import org.keycloak.models.*;
import org.keycloak.services.resource.*;

public class ExampleRealmResourceProvider implements RealmResourceProvider {
    private KeycloakSession session;

    public ExampleRealmResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @GET
    @Produces("text/plain; charset=utf-8")
    public String get()  {
       // EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
       // Company myCompany = em.find(Company.class, "123");


        return "Hello World";
    }

    @Override
    public Object getResource() {
        return new ExampleRestResource(session);
    }

    @Override
    public void close() {
    }
}
