package tech.noetzold.reps.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.noetzold.reps.model.ObjRep;
import tech.noetzold.reps.model.StatusRep;

@Repository
public interface ObjRepRepository extends JpaRepository<ObjRep, Long> {
	
	@Cacheable("books")
	List<ObjRep> findByStatus(StatusRep status, Pageable sort);

	@Query("select p from ObjRep p join p.user u where u.username = :username")
	List<ObjRep> findAllByUsuario(@Param("username")String username);

	@Query("select p from ObjRep p join p.user u where u.username = :username and p.status = :status")
	List<ObjRep> findByStatusEUsuario(@Param("status")StatusRep status, @Param("username")String username);

}