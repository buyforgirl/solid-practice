package com.theladders.solid.srp.apply.resumeprocess;

import com.theladders.solid.srp.http.RequestHandler;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;

/**
 * Created by lliao on 6/12/14.
 */
public class ExistingResumeProcessor extends ResumeProcessor
{
    public ExistingResumeProcessor(RequestHandler requestHandler,
                                   MyResumeManager myResumeManager)
    {
        super(requestHandler, myResumeManager);
    }

    private Resume retrieveResume()
    {
        return myResumeManager.getActiveResume(requestHandler.extractJobseeker().getId());
    }

    @Override
    public Resume resumeProcess() {
        return retrieveResume();
    }
}
