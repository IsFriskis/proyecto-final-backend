package es.tfc.MarcosM.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_user_id", nullable = false)
    private Long id;

    @Column(name = "a_user_name")
    private String name;

    @Column(name = "a_user_mail")
    private String mail;

    @Column(name = "a_user_password")
    private String password;

    @Column(name = "a_user_role")
    private String role;

    @Column(name = "a_user_isBan")
    private Boolean isBan;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<MatchEntity> matches;

    @OneToOne(fetch = FetchType.LAZY)
    private PermissionEntity permission;

}
