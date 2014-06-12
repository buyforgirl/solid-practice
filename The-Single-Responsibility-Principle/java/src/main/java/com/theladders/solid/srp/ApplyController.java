package com.theladders.solid.srp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.theladders.solid.srp.apply.ApplyProcessor;
import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.http.RequestHandler;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.ProfileStatus;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.viewprovider.ViewProvider;


public class ApplyController
{
    private final RequestHandler requestHandler;
    private final ViewProvider viewProvider;
    private final ApplyProcessor applyProcessor;


  public ApplyController(RequestHandler requestHandler,
                         ViewProvider viewProvider,
                         ApplyProcessor applyProcessor)
  {
    this.requestHandler = requestHandler;
    this.viewProvider = viewProvider;
    this.applyProcessor = applyProcessor;
  }

  private boolean validateJob ()
  {
      Job job = requestHandler.extractJob();
      return job != null;
  }

  private boolean validateJobseeker ()
  {
      Jobseeker jobseeker = requestHandler.extractJobseeker();
      JobseekerProfile profile = requestHandler.extractProfile();

      return jobseeker.isPremium() || (!profile.getStatus().equals(ProfileStatus.INCOMPLETE) &&
              !profile.getStatus().equals(ProfileStatus.NO_PROFILE) &&
              !profile.getStatus().equals(ProfileStatus.REMOVED));
  }

  public HttpResponse handle()
  {

    if (!validateJob())
    {
      viewProvider.provideInvalidJobView(requestHandler.extractJobId());
      return viewProvider.getResponse();
    }

    Map<String, Object> model = new HashMap<>();

    List<String> errList = new ArrayList<>();

    try
    {
      applyProcessor.apply();
    }
    catch (Exception e)
    {
      errList.add("We could not process your application.");
      viewProvider.provideErrorView(errList, model);
      return viewProvider.getResponse();
    }

    model.put("jobId", requestHandler.extractJob().getJobId());
    model.put("jobTitle", requestHandler.extractJob().getTitle());

    if (!validateJobseeker())
    {
      viewProvider.provideResumeCompletionView(model);
      return viewProvider.getResponse();
    }

    viewProvider.provideApplySuccessView(model);

    return viewProvider.getResponse();
  }


}
