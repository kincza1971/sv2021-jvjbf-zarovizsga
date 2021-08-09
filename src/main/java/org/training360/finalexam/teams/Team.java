package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.players.Player;

import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    @OrderBy()
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE})
    private List<Player> players;

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this);
    }

}
