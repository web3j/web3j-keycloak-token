package org.web3j.examples.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "WEB3J_TOKENS")
public class Web3jToken {
    @Id
    @Column(name = "TOKEN", nullable = false)
    private String token;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "INFURA_PROJECT")
    private String infuraProject;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInfuraProject() {
        return infuraProject;
    }

    public void setInfuraProject(String infuraProject) {
        this.infuraProject = infuraProject;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Web3jToken token1 = (Web3jToken) o;
        return active == token1.active &&
                token.equals(token1.token) &&
                userId.equals(token1.userId) &&
                Objects.equals(infuraProject, token1.infuraProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, userId, infuraProject, active);
    }

    @Override
    public String toString() {
        return "Web3jToken{" +
                "token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                ", infuraProject='" + infuraProject + '\'' +
                ", active=" + active +
                '}';
    }
}
