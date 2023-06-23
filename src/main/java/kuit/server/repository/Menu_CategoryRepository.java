package kuit.server.repository;

import kuit.server.domain.Menu_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Menu_CategoryRepository extends JpaRepository<Menu_Category, Long> {
}