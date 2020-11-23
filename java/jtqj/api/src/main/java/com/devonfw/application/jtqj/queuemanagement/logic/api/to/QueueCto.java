package com.devonfw.application.jtqj.queuemanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Queue
 */
public class QueueCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private QueueEto queue;

  public QueueEto getQueue() {

    return queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

}
