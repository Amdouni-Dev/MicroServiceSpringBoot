package com.esprit.jobsms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired

    private final JobRepo jobRepo;

    @Autowired
    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }
    public  List<Job> getAllJobs(){
        return jobRepo.findAll();
    }

    public Job getJobByIdOrName(String nom, int id){
        return jobRepo.getJobByIdOrName(id, nom);
    }

}
