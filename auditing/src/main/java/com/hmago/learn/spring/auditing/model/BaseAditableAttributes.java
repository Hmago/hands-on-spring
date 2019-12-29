package com.hmago.learn.spring.auditing.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAditableAttributes<T> {

    @CreatedBy
    T createdBy;

    @LastModifiedBy
    T modifiedBy;

    @CreationTimestamp
    LocalDateTime createdOn;

    @LastModifiedDate
    LocalDateTime modifiedOn;
}
