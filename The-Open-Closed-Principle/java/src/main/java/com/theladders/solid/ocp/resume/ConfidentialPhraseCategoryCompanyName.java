package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategoryCompanyName extends ConfidentialPhraseCategory
{
  private int id = 81;
  private String name = "CompanyName";

  public ConfidentialPhraseCategoryCompanyName (int id, String name)
  {
    super(id, name);
  }

  public boolean isContactCategory()
  {
    return false;
  }
}
