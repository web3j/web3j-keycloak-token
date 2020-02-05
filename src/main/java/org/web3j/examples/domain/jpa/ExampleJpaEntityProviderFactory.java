package org.web3j.examples.domain.jpa;

import org.keycloak.*;
import org.keycloak.connections.jpa.entityprovider.*;
import org.keycloak.models.*;

public class ExampleJpaEntityProviderFactory implements JpaEntityProviderFactory{

    protected static final String ID = "example-entity-provider";

    @Override
    public JpaEntityProvider create(KeycloakSession session) {
        return new ExampleJpaEntityProvider();
    }


    @Override
    public String getId() {
        return ID;
    }

    @Override
    public int order() {
        return 0;
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
