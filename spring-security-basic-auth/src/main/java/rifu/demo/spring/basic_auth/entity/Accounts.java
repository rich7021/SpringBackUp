package rifu.demo.spring.basic_auth.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "CREDENTIALS")
    private String credentials;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
