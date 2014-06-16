package com.theladders.solid.dip.contentnode;

import com.theladders.solid.dip.suggestedarticle.SuggestedArticle;

import java.util.List;

/**
 * Created by lliao on 6/16/14.
 */
public class ContentNodeController
{
    private static final String              IMAGE_PREFIX       = "http://somecdnprovider.com/static/images/careerAdvice/";
    private RepositoryManager repositoryManager;

    public ContentNodeController(RepositoryManager repositoryManager){
        this.repositoryManager = repositoryManager;
    }

    public void resolveArticles(List<SuggestedArticle> dbArticles)
    {
        for (SuggestedArticle article : dbArticles)
        {

            // Attempt to fetch the actual content;
            ContentNode content = this.repositoryManager.getNodeByUuid(article.getArticleExternalIdentifier());
            if (content != null && ContentUtils.isPublishedAndEnabled(content))
            {
                // Override miniImagePath
                overrideMiniImagePath(content);
                article.setContent(content);
            }
        }
    }

    private static void overrideMiniImagePath(ContentNode node)
    {
        String path = (String) node.getProperty("miniImagePath");

        if (path == null || path.length() == 0)
        {
            String category = (String) node.getProperty("primaryTopic");
            node.addProperty("miniImagePath", IMAGE_PREFIX + CATEGORY_IMAGE_MAP.valueOf(category.toUpperCase()));
        }
    }
}
