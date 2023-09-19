package com.esprit.jobsms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class JobsMsApplication {
    private final JobService jobService;

//    @Autowired
//    public JobController(JobService jobService) {
//        this.jobService = jobService;
//    }

    @Autowired
    JobRepo jobRepo;

    public JobsMsApplication(JobService jobService) {
        this.jobService = jobService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JobsMsApplication.class, args);
    }
@RequestMapping("/TestFunctionName")
public String getMyNameMouna(){
        return "Hi Mouna!!!";
}

@GetMapping("/getAllJobs")
public List<Job> getAllJobs(){
        return jobService.getAllJobs();
}
// http://localhost:8050/getJobByIdOrName?nom=Police&id=7
    @GetMapping("/getJobByIdOrName")
    public Job getJobByIdOrName(@RequestParam(name = "nom", required = false) String nom,
                                @RequestParam(name = "id", required = false) Integer id) {

            return jobService.getJobByIdOrName(nom, id);


    }


    // http://localhost:8050/getJobByID?id=1
    @GetMapping("/getJobByID")
    public Optional<Job> getJobByID(@RequestParam(name = "id", required = false) Integer id){
        return jobRepo.findById(id);
    }

    // http://localhost:8050/changeState?id=2 (Postman , chnesta3mel l put  <3  )

    @PutMapping("/changeState")
    @Transactional  // transactional houni hiya ki yabda aanndi opertion fel base de donnees (i transaction)
    public Optional<Job> changeState(@RequestParam(name = "id", required = false) Integer id){
        Optional<Job> job = jobRepo.findById(id);

        if (job.isPresent()) {
            Job jobEntity = job.get();
            if (jobEntity.getEtat() == false) {
                jobRepo.changeStateToTrue(id);
            } else {
                jobRepo.changeStateToFalse(id);
            }
            jobRepo.save(jobEntity);
        }

        return job;
    }

}
