package com.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @OneToMany(mappedBy = "client")
    private List<Order> orderHistory;

    @OneToOne()
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private FileInfo profilePicture;

    @Column(name = "confirm_code")
    private String confirmCode;

    public enum State{
        CONFIRMED, NOT_CONFIRMED;
    }

    @Enumerated(value = EnumType.STRING)
    private State state;

}
