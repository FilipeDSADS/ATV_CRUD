package com.gerenciamento.rpg.Repository;

import com.gerenciamento.rpg.Model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
