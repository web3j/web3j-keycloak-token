package org.web3j.examples.domain.spi.impl;

import org.keycloak.*;
import org.keycloak.models.*;
import org.web3j.examples.domain.spi.*;

public class ExampleServiceProviderFactoryImpl implements ExampleServiceProviderFactory {

    @Override
    public ExampleService create(KeycloakSession session) {
        return new ExampleServiceImpl(session);
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

    @Override
    public String getId() {
        return "exampleServiceImpl";
    }
}
