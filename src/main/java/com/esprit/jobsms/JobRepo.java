package com.esprit.jobsms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {
    //Afficher tous les jobs ==> finAll()

    //Q2 afficher par nom ou id
    @Query("SELECT j FROM Job j WHERE j.id = :id OR j.service = :service")
    Job getJobByIdOrName(@Param("id") int id, @Param("service") String service);
    @Modifying
    @Query("UPDATE Job j SET j.etat = true WHERE j.id = :id")
    void changeStateToTrue(@Param("id") int id);

    @Modifying
    @Query("UPDATE Job j SET j.etat = false WHERE j.id = :id")
    void changeStateToFalse(@Param("id") int id);




}
