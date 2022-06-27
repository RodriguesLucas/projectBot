package br.com.unisc.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.unisc.project.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	Optional<ProductEntity> findByCategoryEntityId(Long id);
	
	@Query(value = "select * from product p where p.category_id =:id", nativeQuery = true)
	List<ProductEntity> findAllByCategoryId(Long id);

	@Query(value = "select * from product p where p.id =:id", nativeQuery = true)
	ProductEntity findByProductById(@Param("id") Long id);

}