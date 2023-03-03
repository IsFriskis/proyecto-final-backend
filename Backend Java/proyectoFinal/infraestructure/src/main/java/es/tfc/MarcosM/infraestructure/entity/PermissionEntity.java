package es.tfc.MarcosM.infraestructure.entity;

import es.tfc.MarcosM.infraestructure.enums.PermissionLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_permissions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_permission_id", nullable = false)
    private Long id;

    @Column(name = "a_permission_role")
    private PermissionLevel role = PermissionLevel.Standard;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private UserEntity user;


}
