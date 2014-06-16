package com.theladders.solid.dip.suggestedarticledao;

import java.util.List;


import com.theladders.solid.dip.suggestedarticle.SuggestedArticle;
import com.theladders.solid.dip.suggestedarticleexample.SuggestedArticleExample;

public interface SuggestedArticleDao
{
  public void updateByPrimaryKeySelective(@SuppressWarnings("unused") SuggestedArticle article);

  public int insertReturnId(@SuppressWarnings("unused") SuggestedArticle suggestedArticle);

  public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleExample criteria);
}
