package es.tfc.MarcosM.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "t_match")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_match_id", nullable = false)
    private Long id;

    @Column(name = "a_match_score")
    private float score = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_user_id")
    private UserEntity user;

}
