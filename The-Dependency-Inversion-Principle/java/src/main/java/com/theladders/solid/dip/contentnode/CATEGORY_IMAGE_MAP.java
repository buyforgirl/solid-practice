package com.theladders.solid.dip.contentnode;

/**
 * Created by lliao on 6/16/14.
 */
public enum  CATEGORY_IMAGE_MAP
{
    INTERVIEWING("interviewing_thumb.jpg"),
    JOBSEARCH("job_search_thumb.jpg"),
    NETWORKING("networking_thumb.jpg"),
    PERSONALBRANDING("personalBranding_thumb.jpg"),
    RESUME("resume_thumb.jpg"),
    SALARY("salary_thumb.jpg"),
    ASSESSMENT("salary_thumb.jpg"),
    ONTHEJOB("salary_thumb.jpg");

    private final String name;

    private CATEGORY_IMAGE_MAP(String s){
        name = s;
    }



}
