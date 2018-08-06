package org.weekendsoft.mpa.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.weekendsoft.mpa.masterdata.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
