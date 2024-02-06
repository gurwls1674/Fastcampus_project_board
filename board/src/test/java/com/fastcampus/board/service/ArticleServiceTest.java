package com.fastcampus.board.service;

import com.fastcampus.board.domain.Article;
import com.fastcampus.board.domain.type.SearchType;
import com.fastcampus.board.dto.ArticleDto;
import com.fastcampus.board.dto.ArticleUpdateDto;
import com.fastcampus.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;


@DisplayName("비즈니스로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @InjectMocks  private ArticleService sut;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticles(){
        //Given
        //SearchParameters param = SearchParameters.of(SearchType.TITLE,"search keyword");
        //when
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE,"search keyword");
        //then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenRead_thenReturnsArticle(){
        //Given
        //SearchParameters param = SearchParameters.of(SearchType.TITLE,"search keyword");
        //when
        List<ArticleDto> articles = sut.readArticle("1L");
        //then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void givenArticleFields_whenCreateArticle_thenReturnsNewArticle(){
        //Given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        //when
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(),"hj","title","content","#java");

        //then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID와 수정 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void givenArticleIdAndFields_whenUpdateArticle_thenUpdateArticle(){
        //Given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        //when
        sut.updateArticle("1L", ArticleUpdateDto.of("title","content","#java"));
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(),"hj","title","content","#java");

        //then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeleteArticle_thenDeleteArticle(){
        //Given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        //when
        sut.deleteArticle("1L");
        //then
        then(articleRepository).should().delete(any(Article.class));
    }


}