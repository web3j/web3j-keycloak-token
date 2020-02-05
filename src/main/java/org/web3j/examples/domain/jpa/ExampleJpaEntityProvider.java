package org.web3j.examples.domain.jpa;

import java.util.*;
import org.keycloak.connections.jpa.entityprovider.*;

public class ExampleJpaEntityProvider implements JpaEntityProvider {
    @Override
    public List<Class<?>> getEntities() {
        return Collections.<Class<?>>singletonList(Company.class);
    }

    @Override
    public String getChangelogLocation() {
        return "META-INF/example-changelog.xml";
    }

    @Override
    public void close() {
    }

    @Override
    public String getFactoryId() {
        return ExampleJpaEntityProviderFactory.ID;
    }
}
