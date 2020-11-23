package com.devonfw.application.jtqj.common.api.builders;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.QueueEntity;

/**
 * Test data builder for QueueEntity generated with cobigen.
 */
public class QueueEntityBuilder {

  private List<Consumer<QueueEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public QueueEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param name the name to add.
   * @return the builder for fluent population of fields.
   */
  public QueueEntityBuilder name(final String name) {

    this.parameterToBeApplied.add(target -> target.setName(name));

    return this;
  }

  /**
   * @param logo the logo to add.
   * @return the builder for fluent population of fields.
   */
  public QueueEntityBuilder logo(final String logo) {

    this.parameterToBeApplied.add(target -> target.setLogo(logo));

    return this;
  }

  /**
   * @param currentNumber the currentNumber to add.
   * @return the builder for fluent population of fields.
   */
  public QueueEntityBuilder currentNumber(final String currentNumber) {

    this.parameterToBeApplied.add(target -> target.setCurrentNumber(currentNumber));

    return this;
  }

  /**
   * @param attentionTime the attentionTime to add.
   * @return the builder for fluent population of fields.
   */
  public QueueEntityBuilder attentionTime(final Timestamp attentionTime) {

    this.parameterToBeApplied.add(target -> target.setAttentionTime(attentionTime));

    return this;
  }

  /**
   * @param minAttentionTime the minAttentionTime to add.
   * @return the builder for fluent population of fields.
   */
  public QueueEntityBuilder minAttentionTime(final Timestamp minAttentionTime) {

    this.parameterToBeApplied.add(target -> target.setMinAttentionTime(minAttentionTime));

    return this;
  }

  /**
   * @param active the active to add.
   * @return the builder for fluent population of fields.
   */
  public QueueEntityBuilder active(final Boolean active) {

    this.parameterToBeApplied.add(target -> target.setActive(active));

    return this;
  }

  /**
   * @param customers the customers to add.
   * @return the builder for fluent population of fields.
   */
  public QueueEntityBuilder customers(final int customers) {

    this.parameterToBeApplied.add(target -> target.setCustomers(customers));

    return this;
  }

  /**
   * @return the populated QueueEntity.
   */
  public QueueEntity createNew() {

    QueueEntity queueentity = new QueueEntity();
    for (Consumer<QueueEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(queueentity);
    }
    return queueentity;
  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * @param em the {@link EntityManager}
   * @return the QueueEntity
   */
  public QueueEntity persist(EntityManager em) {

    QueueEntity queueentity = createNew();
    em.persist(queueentity);
    return queueentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of QueueEntity
   */
  public List<QueueEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<QueueEntity> queueentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      QueueEntity queueentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(queueentity);
      queueentityList.add(queueentity);
    }

    return queueentityList;
  }

}
