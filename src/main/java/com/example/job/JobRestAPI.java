package com.example.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobRestAPI {

    @Autowired
    private JobService jobsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Job> getListJobs() {
        return jobsService.getAll();
    }

    @GetMapping(value = "/getbynom/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Job getJobByNom(@PathVariable(value = "nom") String nom) {
        return jobsService.getbyname(nom);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Job getJobByID(@PathVariable(value = "id") Integer id) {
        return jobsService.getbyid(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") int id, @RequestBody Job job){
        return new ResponseEntity<>(jobsService.updateJob(id, job),
                HttpStatus.OK);
    }

}