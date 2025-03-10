package med.voll.api.repositories;

import med.voll.api.domain.entities.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
 }
