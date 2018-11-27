package shahid.services;

import java.util.List;

import shahid.models.Article;

public interface ArticleService {

	List<Article> findAllUserArticles(List<String> userId);
}
