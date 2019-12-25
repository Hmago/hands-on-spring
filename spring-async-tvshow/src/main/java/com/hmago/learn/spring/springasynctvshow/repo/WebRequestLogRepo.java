package com.hmago.learn.spring.springasynctvshow.repo;

import com.hmago.learn.spring.springasynctvshow.model.WebRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "logs", path = "logs")
public interface WebRequestLogRepo extends JpaRepository<WebRequestLog, Long> {
}
