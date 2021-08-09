package org.training360.finalexam.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training360.finalexam.teams.Team;

public interface TeamsRepository extends JpaRepository<Team, Long> {
}
