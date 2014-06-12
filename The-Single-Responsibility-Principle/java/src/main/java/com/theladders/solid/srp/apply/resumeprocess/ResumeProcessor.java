package com.theladders.solid.srp.apply.resumeprocess;

import com.theladders.solid.srp.http.RequestHandler;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;

/**
 * Created by lliao on 6/12/14.
 */
public abstract class ResumeProcessor
{
    protected RequestHandler requestHandler;
    protected MyResumeManager myResumeManager;

    public ResumeProcessor(RequestHandler requestHandler,
                           MyResumeManager myResumeManager)
    {
        this.requestHandler = requestHandler;
        this.myResumeManager = myResumeManager;
    }

    public abstract Resume resumeProcess();

    public RequestHandler getRequestHandler()
    {
        return requestHandler;
    }
}
