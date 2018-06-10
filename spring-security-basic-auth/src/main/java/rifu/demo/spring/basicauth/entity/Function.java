package rifu.demo.spring.basicauth.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "FUNCTION")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleId_seq")
    @SequenceGenerator(name = "roleId_seq", sequenceName = "role_sequence")
    private Long id;
    @Column(name = "FUNCTION_NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    /**
     * mappedBy represents this property is fetched by the property of the other class, e.g. th foreign key set in the other entity.
     * Here is self reference example. so @OneToMany and @ManyToOne in the same class
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    private Set<Function> children;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Function parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Function> getChildren() {
        return children;
    }

    public void setChildren(Set<Function> children) {
        this.children = children;
    }

    public Function getParent() {
        return parent;
    }

    public void setParent(Function parent) {
        this.parent = parent;
    }
}
