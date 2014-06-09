package com.theladders.solid.ocp.resume;

import java.util.HashMap;
import java.util.Map;


public class ConfidentialPhraseCategoryRepository
{
  private final Map<Integer, ConfidentialPhraseCategory> ConfidentialPhraseCategories;

  public ConfidentialPhraseCategoryRepository()
  {
    this.ConfidentialPhraseCategories = new HashMap<Integer, ConfidentialPhraseCategory>();
  }

  public void addConfidentialPhraseCategory(ConfidentialPhraseCategory aCategory)
  {
    ConfidentialPhraseCategories.put(aCategory.getId(), aCategory);
  }

  public Map<Integer, ConfidentialPhraseCategory> getConfidentialPhraseCategory()
  {
    return ConfidentialPhraseCategories;
  }

  public ConfidentialPhraseCategoryRepository getContactConfidentialPhraseCategoryRepository()
  {
    ConfidentialPhraseCategoryRepository contactrepository = new ConfidentialPhraseCategoryRepository();
    Map<Integer, ConfidentialPhraseCategory> originalCategories = this.ConfidentialPhraseCategories;

    for (ConfidentialPhraseCategory category : originalCategories.values())
    {
      if(category.isContactCategory())
      {
        contactrepository.addConfidentialPhraseCategory(category);
      }
    }

    return contactrepository;
  }

}
