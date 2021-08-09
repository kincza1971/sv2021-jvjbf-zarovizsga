package org.training360.finalexam.players;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.training360.finalexam.teams.Team;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    @OrderBy()
    private Long id;

    private String name;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private PositionType position;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Team team;

    public Player(String name, LocalDate birthDate, PositionType position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

    public Player(String name, LocalDate birthDate, PositionType position, Team team) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.team = team;
    }
}
