package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategoryEmailAddress extends ConfidentialPhraseCategory
{
  private int id = 77;
  private String name = "EmailAddress";

  public ConfidentialPhraseCategoryEmailAddress (int id, String name)
  {
    super(id, name);
  }

  public boolean isContactCategory()
  {
    return true;
  }
}
