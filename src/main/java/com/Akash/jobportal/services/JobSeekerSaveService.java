package com.Akash.jobportal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Akash.jobportal.entity.JobPostActivity;
import com.Akash.jobportal.entity.JobSeekerProfile;
import com.Akash.jobportal.entity.JobSeekerSave;
import com.Akash.jobportal.repository.JobSeekerSaveRepository;

@Service
public class JobSeekerSaveService {

    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    public JobSeekerSaveService(JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId) {
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job) {
        return jobSeekerSaveRepository.findByJob(job);
    }

    public void addNew(JobSeekerSave jobSeekerSave) {
        jobSeekerSaveRepository.save(jobSeekerSave);
    }
}
