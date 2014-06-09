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

  public boolean isContactCategory();

}

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
