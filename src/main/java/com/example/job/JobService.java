package com.example.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAll(){
        return jobRepository.findAll();
    }

    public Job getbyname(String nom){
        return jobRepository.jobByNom(nom);
    }
    public Job getbyid(Integer id){
        return jobRepository.jobByID(id);
    }
    public  Job updateJob(int id, Job newJob){
        if (jobRepository.findById(id).isPresent()){
            Job existingJob = jobRepository.findById(id).get();

            existingJob.setEtat(newJob.getEtat());

            return  jobRepository.save(existingJob);
        }
        else { return null;}
    }

}