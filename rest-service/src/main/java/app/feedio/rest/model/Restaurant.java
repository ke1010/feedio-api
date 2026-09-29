    package app.feedio.rest.model;

    import jakarta.persistence.*;
    import lombok.*;

    import java.util.HashSet;
    import java.util.Set;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    @Entity(name = "rest_db")
    public class Restaurant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        String name;
        String address;
        double ratings;
        String imgUrl;
        double latitude;
        double longitude;
        boolean isActive;
        @ManyToMany
        @JoinTable(
                name = "rest_cat_db",
                joinColumns = @JoinColumn(name = "rest_id"),
                inverseJoinColumns = @JoinColumn(name = "cat_id")
        )
        private Set<Category> categories = new HashSet<>();
    }
