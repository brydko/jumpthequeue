package com.devonfw.application.jtqj.queuemanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.QueueEntity;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueCto;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueSearchCriteriaTo;
import com.devonfw.application.jtqj.queuemanagement.logic.api.usecase.UcFindQueue;
import com.devonfw.application.jtqj.queuemanagement.logic.base.usecase.AbstractQueueUc;

/**
 * Use case implementation for searching, filtering and getting Queues
 */
@Named
@Validated
@Transactional
public class UcFindQueueImpl extends AbstractQueueUc implements UcFindQueue {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindQueueImpl.class);

  @Override
  public QueueEto findQueue(long id) {

    LOG.debug("Get Queue with id {} from database.", id);
    Optional<QueueEntity> foundEntity = getQueueRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), QueueEto.class);
    else
      return null;
  }

  @Override
  public Page<QueueEto> findQueues(QueueSearchCriteriaTo criteria) {

    Page<QueueEntity> queues = getQueueRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(queues, QueueEto.class);
  }

  @Override
  public QueueCto findQueueCto(long id) {

    LOG.debug("Get QueueCto with id {} from database.", id);
    QueueEntity entity = getQueueRepository().find(id);
    QueueCto cto = new QueueCto();
    cto.setQueue(getBeanMapper().map(entity, QueueEto.class));

    return cto;
  }

  @Override
  public Page<QueueCto> findQueueCtos(QueueSearchCriteriaTo criteria) {

    Page<QueueEntity> queues = getQueueRepository().findByCriteria(criteria);
    List<QueueCto> ctos = new ArrayList<>();
    for (QueueEntity entity : queues.getContent()) {
      QueueCto cto = new QueueCto();
      cto.setQueue(getBeanMapper().map(entity, QueueEto.class));
      ctos.add(cto);
    }
    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), criteria.getPageable().getPageSize());

    return new PageImpl<>(ctos, pagResultTo, queues.getTotalElements());
  }

}
