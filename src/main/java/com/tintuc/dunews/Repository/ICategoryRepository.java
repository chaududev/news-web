package com.tintuc.dunews.Repository;

import com.tintuc.dunews.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}

