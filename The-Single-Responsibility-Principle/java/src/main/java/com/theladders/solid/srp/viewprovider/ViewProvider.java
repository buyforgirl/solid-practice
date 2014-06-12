package com.theladders.solid.srp.viewprovider;

import com.theladders.solid.srp.Result;
import com.theladders.solid.srp.http.HttpResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lliao on 6/12/14.
 */
public class ViewProvider
{
    private HttpResponse response;

    public ViewProvider(HttpResponse response)
    {
        this.response = response;
    }

    public void provideApplySuccessView(Map<String, Object> model)
    {
        Result result = new Result("success", model);
        response.setResult(result);
    }

    public void provideResumeCompletionView(Map<String, Object> model)
    {
        Result result = new Result("completeResumePlease", model);
        response.setResult(result);
    }

    public void provideErrorView(List<String> errList, Map<String, Object> model)
    {
        Result result = new Result("error", model, errList);
        response.setResult(result);
    }

    public void provideInvalidJobView(int jobId)
    {
        Map<String, Object> model = new HashMap<>();
        model.put("jobId", jobId);

        Result result = new Result("invalidJob", model);
        response.setResult(result);
    }
    
    public HttpResponse getResponse()
    {
        return response;
    }
}
