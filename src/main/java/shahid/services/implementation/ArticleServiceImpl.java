package shahid.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import shahid.models.Article;
import shahid.repositories.ArticleRepository;
import shahid.services.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	private final ArticleRepository articleRepository;
	
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public List<Article> findAllUserArticles(List<String> ids) {
		return articleRepository.findByIdIn(ids);
	}

}
