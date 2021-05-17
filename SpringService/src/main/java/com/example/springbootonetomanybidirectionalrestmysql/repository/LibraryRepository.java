package com.example.springbootonetomanybidirectionalrestmysql.repository;

import com.example.springbootonetomanybidirectionalrestmysql.jpa.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Integer> {

}
