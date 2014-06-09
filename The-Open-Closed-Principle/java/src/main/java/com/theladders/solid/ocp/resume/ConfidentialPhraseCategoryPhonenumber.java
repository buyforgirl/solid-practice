package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategoryPhonenumber extends ConfidentialPhraseCategory
{
  private int id = 78;
  private String name = "PhoneNumber";

  public ConfidentialPhraseCategoryPhonenumber (int id, String name)
  {
    super(id, name);
  }

  public boolean isContactCategory()
  {
    return true;
  }
}
