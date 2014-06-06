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

  public ConfidentialPhraseCategory getConfidentialPharseCategory(int id)
  {
    return ConfidentialPhraseCategories.get(id);
  }

  public ConfidentialPhraseCategoryRepository getContactConfidentialPharaseCategories()
  {
    ContactConfidentialPharaseCategoryRepository = new ConfidentialPhraseCategoryRepository();
    originalCategories = this.ConfidentialPhraseCategoryRepositories;

    for (ConfidentialPhraseCategory category : originalCategories.values()){
      if(category.isContactCategory()){
        ContactConfidentialPharaseCategoryRepository.addConfidentialPhraseCategory(category)
      }
    }

    return ContactConfidentialPharaseCategoryRepository;
  }

  
}