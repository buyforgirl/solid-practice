package com.theladders.solid.dip.suggestedarticleexample;

/**
 * Created by lliao on 6/16/14.
 */
public class CriteriaFactory
{
    public GeneralCriteria generateCriteria(String criteria)
    {
        if(criteria == null){
            return null;
        }

        if(criteria.equalsIgnoreCase("Criteria")){
            return new Criteria();
        }

        return null;
    }
}
