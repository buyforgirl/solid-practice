package com.theladders.solid.ocp.resume;

/*
public enum ConfidentialPhraseCategory
{
  Name(76),
  MailingAddress(79),
  PhoneNumber(78),
  EmailAddress(77),
  ContactInfo(80),
  CompanyName(81),
  WorkExperience(82);

  @SuppressWarnings("unused")
  private int id;

  private ConfidentialPhraseCategory(int id)
  {
    this.id = id;
  }
}
*/

public abstract class ConfidentialPhraseCategory
{
  private int id;
  private String name;

  public ConfidentialPhraseCategory(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public abstract boolean isContactCategory();

}

