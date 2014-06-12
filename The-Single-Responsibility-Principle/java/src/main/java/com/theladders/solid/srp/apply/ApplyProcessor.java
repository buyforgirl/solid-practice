package com.theladders.solid.srp.apply;

import com.theladders.solid.srp.http.RequestHandler;
import com.theladders.solid.srp.apply.resumeprocess.ResumeProcessor;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.ApplicationFailureException;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.Resume;

/**
 * Created by lliao on 6/12/14.
 */
public class ApplyProcessor
{
    private ResumeProcessor resumeProcessor;
    private JobApplicationSystem jobApplicationSystem;

    public ApplyProcessor(ResumeProcessor resumeProcessor,
                          JobApplicationSystem jobApplicationSystem)
    {
        this.resumeProcessor = resumeProcessor;
        this.jobApplicationSystem = jobApplicationSystem;
    }

    private Resume resumeForApply()
    {
        return resumeProcessor.resumeProcess();
    }

    private Job jobForApply()
    {
        RequestHandler requestHandler = resumeProcessor.getRequestHandler();
        return requestHandler.extractJob();
    }

    private Jobseeker jobseekerForApply()
    {
        RequestHandler requestHandler = resumeProcessor.getRequestHandler();
        return requestHandler.extractJobseeker();
    }

    public void apply()
    {
        Resume resume = resumeForApply();
        UnprocessedApplication application = new UnprocessedApplication(jobseekerForApply(), jobForApply(), resume);
        JobApplicationResult applicationResult = jobApplicationSystem.apply(application);

        if (applicationResult.failure())
        {
            throw new ApplicationFailureException(applicationResult.toString());
        }
    }
}
