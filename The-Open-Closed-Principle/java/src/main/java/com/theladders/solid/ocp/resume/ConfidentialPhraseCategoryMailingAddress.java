package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategoryMailingAddress extends ConfidentialPhraseCategory
{
  private int id = 79;
  private String name = "MailingAddress";

  public ConfidentialPhraseCategoryMailingAddress (int id, String name)
  {
    super(id, name);
  }

  public boolean isContactCategory()
  {
    return true;
  }
}
