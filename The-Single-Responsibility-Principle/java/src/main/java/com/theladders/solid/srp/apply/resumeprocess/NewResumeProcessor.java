package com.theladders.solid.srp.apply.resumeprocess;


import com.theladders.solid.srp.http.RequestHandler;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

/**
 * Created by lliao on 6/12/14.
 */
public class NewResumeProcessor extends ResumeProcessor
{
    private String newResumeFileName;
    private  ResumeManager resumeManager;

    public NewResumeProcessor(RequestHandler requestHandler,
                              MyResumeManager myResumeManager,
                              ResumeManager resumeManager,
                              String newResumeFileName)
    {
        super(requestHandler, myResumeManager);
        this.resumeManager = resumeManager;
        this.newResumeFileName = newResumeFileName;
    }


    private boolean validateResumeActive(Resume resume)
    {
        String resumeActiveStatus = requestHandler.extractResumeInfoActice();
        return resume != null && "yes".equals(resumeActiveStatus);
    }

    private Resume saveNewResume()
    {
        Jobseeker jobseeker = requestHandler.extractJobseeker();
        return resumeManager.saveResume(jobseeker, newResumeFileName);
    }

    private void setResumeActive(Resume resume)
    {
        myResumeManager.saveAsActive(requestHandler.extractJobseeker(), resume);
    }

    @Override
    public Resume resumeProcess()
    {
        Resume resume = saveNewResume();

        if(validateResumeActive(resume))
        {
            setResumeActive(resume);
        }

        return resume;
    }
}
