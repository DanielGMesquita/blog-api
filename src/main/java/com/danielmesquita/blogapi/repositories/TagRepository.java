package com.danielmesquita.blogapi.repositories;

import com.danielmesquita.blogapi.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
