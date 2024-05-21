package se.iths.userserviceemi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String userID;

    private String imageUrl;

    private int numberOfMessages;
}
