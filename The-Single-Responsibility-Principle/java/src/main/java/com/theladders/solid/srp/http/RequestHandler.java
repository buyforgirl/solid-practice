package com.theladders.solid.srp.http;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.JobSearchService;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;


/**
 * Created by lliao on 6/12/14.
 */
public class RequestHandler
{
    private final HttpRequest request;
    private final JobseekerProfileManager jobseekerProfileManager;
    private final JobSearchService jobSearchService;

    public RequestHandler(HttpRequest request,
                          JobseekerProfileManager jobseekerProfileManager,
                          JobSearchService jobSearchService)
    {
        this.request = request;
        this.jobseekerProfileManager = jobseekerProfileManager;
        this.jobSearchService = jobSearchService;
    }

    public Jobseeker extractJobseeker()
    {
        return request.getSession().getJobseeker();
    }

    public JobseekerProfile extractProfile()
    {
        Jobseeker jobseeker = extractJobseeker();
        return jobseekerProfileManager.getJobSeekerProfile(jobseeker);
    }

    public Integer extractJobId()
    {
        String jobIdString = request.getParameter("jobId");
        return Integer.parseInt(jobIdString);
    }

    public Job extractJob()
    {
        Integer jobId = extractJobId();
        return jobSearchService.getJob(jobId);
    }

    public String extractResumeInfoExisting()
    {
        return request.getParameter("whichResume");
    }

    public String extractResumeInfoActice()
    {
        return request.getParameter("makeResumeActive");
    }
}
