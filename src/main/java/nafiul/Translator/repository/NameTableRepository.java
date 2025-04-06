package nafiul.Translator.repository;

import nafiul.Translator.entity.NameTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameTableRepository extends JpaRepository<NameTable,Long> {
}
