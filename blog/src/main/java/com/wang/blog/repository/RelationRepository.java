package com.wang.blog.repository;

import com.wang.blog.domain.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relation,Integer> {
}
