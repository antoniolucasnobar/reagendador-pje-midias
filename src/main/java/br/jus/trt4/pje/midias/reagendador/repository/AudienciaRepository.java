package br.jus.trt4.pje.midias.reagendador.repository;

import br.jus.trt4.pje.midias.reagendador.entidades.Audiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudienciaRepository extends JpaRepository<Audiencia, Integer> {

    public List<Audiencia> findByStatusEnvio(Integer status);
}
