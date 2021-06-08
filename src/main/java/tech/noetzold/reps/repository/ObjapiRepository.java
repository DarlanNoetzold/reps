package tech.noetzold.reps.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.noetzold.reps.model.Objapi;
import tech.noetzold.reps.model.StatusApi;

@Repository
public interface ObjapiRepository extends JpaRepository<Objapi, Long> {
	
	@Cacheable("books")
	List<Objapi> findByStatus(StatusApi status, Pageable sort);

	@Query("select p from Objapi p join p.user u where u.username = :username")
	List<Objapi> findAllByUsuario(@Param("username")String username);

	@Query("select p from Objapi p join p.user u where u.username = :username and p.status = :status")
	List<Objapi> findByStatusEUsuario(@Param("status")StatusApi status, @Param("username")String username);

}