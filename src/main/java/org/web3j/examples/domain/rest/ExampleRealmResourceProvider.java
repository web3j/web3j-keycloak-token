package org.web3j.examples.domain.rest;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class ExampleRealmResourceProvider implements RealmResourceProvider {
    private KeycloakSession session;

    public ExampleRealmResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return new ExampleRestResource(session);
    }

    @Override
    public void close() {
    }
}
