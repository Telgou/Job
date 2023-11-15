package com.example.job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job,Integer> {

    @Query("select j from Job j where j.Service like :name")
    public Job jobByNom(@Param("name") String n);

    @Query("select j from Job j where j.ID = :id")
    public Job jobByID(@Param("id") Integer id);


}