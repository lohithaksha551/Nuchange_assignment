package com.nuchange.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.nuchange.Entity.UrlEntity;

public interface UrlRepository extends JpaRepository<UrlEntity, Integer> {

	Optional<UrlEntity> findByUrl(@Param(value="url") String url);
}
