package io.github.taissasantos.model.repository;

import io.github.taissasantos.model.entity.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepository extends JpaRepository<Carros, Integer> {
}
