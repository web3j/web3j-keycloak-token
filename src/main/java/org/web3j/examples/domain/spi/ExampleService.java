package org.web3j.examples.domain.spi;

import java.util.*;
import org.keycloak.provider.*;
import org.web3j.examples.domain.*;

public interface ExampleService extends Provider {

    List<CompanyRepresentation> listCompanies();

    CompanyRepresentation findCompany(String id);

    CompanyRepresentation addCompany(CompanyRepresentation company);

}