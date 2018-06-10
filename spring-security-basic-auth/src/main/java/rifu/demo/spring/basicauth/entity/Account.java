package rifu.demo.spring.basicauth.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountId_seq")
    @SequenceGenerator(name = "accountId_seq", sequenceName = "account_sequence")
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
