package org.web3j.examples.domain.rest;

import org.keycloak.*;
import org.keycloak.models.*;
import org.keycloak.services.resource.*;

public class ExampleRealmResourceProviderFactory implements RealmResourceProviderFactory{
    public static final String ID = "example";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public RealmResourceProvider create(KeycloakSession session) {
        return new ExampleRealmResourceProvider(session);
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public void close() {
    }

}
