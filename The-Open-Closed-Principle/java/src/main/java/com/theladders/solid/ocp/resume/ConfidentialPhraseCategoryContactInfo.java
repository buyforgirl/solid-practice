package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategoryContactInfo extends ConfidentialPhraseCategory
{
  private int id = 80;
  private String name = "ContactInfo";

  public ConfidentialPhraseCategoryContactInfo (int id, String name)
  {
    super(id, name);
  }

  public boolean isContactCategory()
  {
    return true;
  }
}
