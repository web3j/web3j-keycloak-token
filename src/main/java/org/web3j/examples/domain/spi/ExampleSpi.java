package org.web3j.examples.domain.spi;

import org.keycloak.provider.*;

public class ExampleSpi implements Spi {

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "example";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return ExampleService.class;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return ExampleServiceProviderFactory.class;
    }

}
