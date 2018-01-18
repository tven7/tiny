package slack.app.tiny.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "link",
        indexes = {@Index(name = "url_lookup", columnList = "url")})
public class Link {

    private static final String PERSISTENCE_UNIT_NAME = "short_links";
    private static EntityManagerFactory factory;
    @GeneratedValue
    @Id
    private int id;
    @Column(nullable = false)
    private String url;
    @Column
    private String code;
    @Column(nullable = false)
    private Date created;
    @Column(nullable = false)
    private Date updated;


    public Link(String $url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Optional createRow() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
        em.flush();
        return Optional.of(this.getId());
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    private EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        return em;
    }
}
