package com.theladders.solid.ocp.resume;

import java.util.HashMap;
import java.util.Map;


public class ConfidentialPhraseCategoryRepository
{
  private final Map<Integer, ConfidentialPhraseCategory> ConfidentialPhraseCategories;

  public ConfidentialPhraseCategory()
  {
    this.ConfidentialPhraseCategories = new HashMap<>();
  }

  public void addConfidentialPhraseCategory(ConfidentialPhraseCategory aCategory)
  {
    ConfidentialPhraseCategories.put(aCategory.getId(), aCategory);
  }

  public Map<Integer, ConfidentialPhraseCategory> getConfidentialPharseCategory()
  {
    return ConfidentialPhraseCategories;
  }

  public ConfidentialPhraseCategoryRepository getContactConfidentialPhraseCategoryRepository()
  {
    ConfidentialPhraseCategoryRepository contactrepository = new ConfidentialPhraseCategoryRepository();
    Map<Integer, ConfidentialPhraseCategory> originalCategories = this.ConfidentialPhraseCategoryRepositories;

    for (ConfidentialPhraseCategory category : originalCategories.values())
    {
      if(category.isContactCategory())
      {
        contactrepository.addConfidentialPhraseCategory(category)
      }
    }

    return contactrepository;
  }

}
