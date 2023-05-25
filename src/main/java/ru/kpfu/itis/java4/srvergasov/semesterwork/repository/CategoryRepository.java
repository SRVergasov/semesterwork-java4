package ru.kpfu.itis.java4.srvergasov.semesterwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> getCategoriesByName(String name);
}
