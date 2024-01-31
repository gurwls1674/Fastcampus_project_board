package com.fastcampus.board.repository;

import com.fastcampus.board.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA연결 테스트")
@Import(com.fastcampus.board.config.JpaConfig.class)
@DataJpaTest
class ArticleRepositoryTest {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public ArticleRepositoryTest(@Autowired ArticleRepository articleRepository,@Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("조회 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //given

        //when
        List<Article> articles = articleRepository.findAll();
        //then
        assertThat(articles)
                .isNotNull()
                .hasSize(1000);

    }

    @DisplayName("등록테스트")
    @Test
    void givenTestDate_whenInserting_thenWorksFine(){
        //given
        long previousCount = articleRepository.count();

        //when
         articleRepository.save(Article.of("new article","new content","new hashTag"));
        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount);
    }

    @DisplayName("수정테스트")
    @Test
    void givenTestDate_whenUpdating_thenWorksFine(){
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        System.out.println("검색된 id : "+article.getId());
        System.out.println("검색된 title : "+article.getTitle());
        System.out.println("검색된 content "+article.getContent());
        System.out.println("검색된 hashtag "+article.getHashtag());
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);

        //when
        Article savedArticle = articleRepository.save(article);
        articleRepository.flush();
        System.out.println("수정된 id : "+savedArticle.getId());
        System.out.println("수정된 title : "+savedArticle.getTitle());
        System.out.println("수정된 content "+savedArticle.getContent());
        System.out.println("수정된 hashtag "+savedArticle.getHashtag());
        //then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag",updatedHashtag);
    }

    @DisplayName("삭제테스트")
    @Test
    void givenTestDate_whenDeleting_thenWorksFine(){
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size();

        //when
        articleRepository.delete(article);

        //then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount-1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentsSize);

    }

}