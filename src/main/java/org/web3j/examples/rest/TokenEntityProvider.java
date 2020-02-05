package org.web3j.examples.rest;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;

import java.util.Collections;
import java.util.List;

public class TokenEntityProvider implements JpaEntityProvider {
    @Override
    public List<Class<?>> getEntities() {
        return Collections.singletonList(Web3jToken.class);
    }

    @Override
    public String getChangelogLocation() {
        return null;
    }

    @Override
    public String getFactoryId() {
        return TokenEntityProviderFactory.ID;
    }

    @Override
    public void close() {

    }
}
