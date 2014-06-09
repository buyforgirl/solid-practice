package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategoryWorkExperience extends ConfidentialPhraseCategory
{
  private int id = 82;
  private String name = "WorkExperience";

  public ConfidentialPhraseCategoryWorkExperience (int id, String name)
  {
    super(id, name);
  }

  public boolean isContactCategory()
  {
    return false;
  }
}
