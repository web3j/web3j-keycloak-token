package org.web3j.examples.domain.spi.impl;

import java.util.*;
import javax.persistence.*;
import org.keycloak.connections.jpa.*;
import org.keycloak.models.*;
import org.keycloak.models.utils.*;
import org.web3j.examples.domain.*;
import org.web3j.examples.domain.jpa.*;
import org.web3j.examples.domain.spi.*;

public class ExampleServiceImpl implements ExampleService {

    private final KeycloakSession session;

    public ExampleServiceImpl(KeycloakSession session) {
        this.session = session;
        if (getRealm() == null) {
            throw new IllegalStateException("The service cannot accept a session without a realm in its context.");
        }
    }

    private EntityManager getEntityManager() {
        return session.getProvider(JpaConnectionProvider.class).getEntityManager();
    }

    protected RealmModel getRealm() {
        return session.getContext().getRealm();
    }

    @Override
    public List<CompanyRepresentation> listCompanies() {
        List<Company> companyEntities = getEntityManager().createNamedQuery("findByRealm", Company.class)
                .setParameter("realmId", getRealm().getId())
                .getResultList();

        List<CompanyRepresentation> result = new LinkedList<>();
        for (Company entity : companyEntities) {
            result.add(new CompanyRepresentation(entity));
        }
        return result;
    }

    @Override
    public CompanyRepresentation findCompany(String id) {
        Company entity = getEntityManager().find(Company.class, id);
        return entity==null ? null : new CompanyRepresentation(entity);
    }

    @Override
    public CompanyRepresentation addCompany(CompanyRepresentation company) {
        Company entity = new Company();
        String id = company.getId()==null ?  KeycloakModelUtils.generateId() : company.getId();
        entity.setId(id);
        entity.setName(company.getName());
        entity.setRealmId(getRealm().getId());
        getEntityManager().persist(entity);

        company.setId(id);
        return company;
    }

    public void close() {
        // Nothing to do.
    }
}
