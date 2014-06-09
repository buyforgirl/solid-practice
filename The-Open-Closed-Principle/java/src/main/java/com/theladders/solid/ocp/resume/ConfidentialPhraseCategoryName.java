package com.theladders.solid.ocp.resume;

public class ConfidentialPhraseCategoryName extends ConfidentialPhraseCategory
{
  private int id = 76;
  private String name = "Name";

  public ConfidentialPhraseCategoryName (int id, String name)
  {
    super(id, name);
  }

  public boolean isContactCategory()
  {
    return false;
  }
}
