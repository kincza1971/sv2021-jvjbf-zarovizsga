package org.training360.finalexam.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training360.finalexam.entities.Player;

public interface PlayersRepository extends JpaRepository<Player, Long> {
}
