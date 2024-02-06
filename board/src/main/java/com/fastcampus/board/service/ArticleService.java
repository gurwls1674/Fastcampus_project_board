package com.fastcampus.board.service;

import com.fastcampus.board.domain.type.SearchType;
import com.fastcampus.board.dto.ArticleDto;
import com.fastcampus.board.dto.ArticleUpdateDto;
import com.fastcampus.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public List<ArticleDto> searchArticles(SearchType title, String search_keyword) {
        return List.of();
    }

    @Transactional(readOnly = true)
    public List<ArticleDto> searchArticle(SearchType title, String search_keyword) {
        return List.of();
    }

    @Transactional(readOnly = true)
    public List<ArticleDto> readArticle(String articleId) {
        return List.of();
    }

    @Transactional(readOnly = true)
    public void updateArticle(String s, ArticleUpdateDto of) {
    }

    @Transactional(readOnly = true)
    public void deleteArticle(String s) {
    }
}
