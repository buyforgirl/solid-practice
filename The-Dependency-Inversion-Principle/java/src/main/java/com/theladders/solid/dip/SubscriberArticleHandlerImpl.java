package com.theladders.solid.dip;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by lliao on 6/10/14.
 */
public class SubscriberArticleHandlerImpl implements SubcriberArticleHandler
{
    private static final String              IMAGE_PREFIX       = "http://somecdnprovider.com/static/images/careerAdvice/";
    private static final Map<String, String> CATEGORY_IMAGE_MAP = new HashMap<>();

    static
    {
        CATEGORY_IMAGE_MAP.put("Interviewing", "interviewing_thumb.jpg");
        CATEGORY_IMAGE_MAP.put("Job Search", "job_search_thumb.jpg");
        CATEGORY_IMAGE_MAP.put("Networking", "networking_thumb.jpg");
        CATEGORY_IMAGE_MAP.put("Personal Branding", "personalBranding_thumb.jpg");
        CATEGORY_IMAGE_MAP.put("Resume", "resume_thumb.jpg");
        CATEGORY_IMAGE_MAP.put("Salary", "salary_thumb.jpg");
        CATEGORY_IMAGE_MAP.put("Assessment", "salary_thumb.jpg");
        CATEGORY_IMAGE_MAP.put("On the Job", "salary_thumb.jpg");
    }

    private SuggestedArticleDao              suggestedArticleDao;
    private RepositoryManager                repositoryManager;

    public SubscriberArticleHandlerImpl(SuggestedArticleDao suggestedArticleDao,
                                        RepositoryManager repositoryManager)
    {
        this.suggestedArticleDao = suggestedArticleDao;
        this.repositoryManager = repositoryManager;
    }

    public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId)
    {
        SuggestedArticleExample criteria = new SuggestedArticleExample();
        criteria.createCriteria()
                .andSubscriberIdEqualTo(subscriberId)
                .andSuggestedArticleStatusIdIn(Arrays.asList(1, 2))  // must be New or Viewed
                .andSuggestedArticleSourceIdEqualTo(1);

        criteria.setOrderByClause("create_time desc");
        List<SuggestedArticle> dbSuggestions = this.suggestedArticleDao.selectByExampleWithBlobs(criteria);

        // Fetch content associated with SuggestedArticle (based on externalArticleId)
        resolveArticles(dbSuggestions);

        return dbSuggestions;
    }

    private void resolveArticles(List<SuggestedArticle> dbArticles)
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
            node.addProperty("miniImagePath", IMAGE_PREFIX + CATEGORY_IMAGE_MAP.get(category));
        }
    }
}
