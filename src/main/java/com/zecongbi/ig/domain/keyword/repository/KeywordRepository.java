package com.zecongbi.ig.domain.keyword.repository;

import com.zecongbi.ig.domain.keyword.entity.Keyword;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

  boolean existsKeywordByKeyword(String keyword);

  Keyword findKeywordByKeyword(String keyword);
}
