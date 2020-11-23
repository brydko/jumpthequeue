package com.devonfw.application.jtqj.common.api.builders;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.devonfw.application.jtqj.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.QueueEntity;
import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.VisitorEntity;

/**
 * Test data builder for AccessCodeEntity generated with cobigen.
 */
public class AccessCodeEntityBuilder {

  private List<Consumer<AccessCodeEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public AccessCodeEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param ticketNumber the ticketNumber to add.
   * @return the builder for fluent population of fields.
   */
  public AccessCodeEntityBuilder ticketNumber(final String ticketNumber) {

    this.parameterToBeApplied.add(target -> target.setTicketNumber(ticketNumber));

    return this;
  }

  /**
   * @param creationTime the creationTime to add.
   * @return the builder for fluent population of fields.
   */
  public AccessCodeEntityBuilder creationTime(final Timestamp creationTime) {

    this.parameterToBeApplied.add(target -> target.setCreationTime(creationTime));

    return this;
  }

  /**
   * @param startTime the startTime to add.
   * @return the builder for fluent population of fields.
   */
  public AccessCodeEntityBuilder startTime(final Timestamp startTime) {

    this.parameterToBeApplied.add(target -> target.setStartTime(startTime));

    return this;
  }

  /**
   * @param endTime the endTime to add.
   * @return the builder for fluent population of fields.
   */
  public AccessCodeEntityBuilder endTime(final Timestamp endTime) {

    this.parameterToBeApplied.add(target -> target.setEndTime(endTime));

    return this;
  }

  /**
   * @param visitor the visitor to add.
   * @return the builder for fluent population of fields.
   */
  public AccessCodeEntityBuilder visitor(final VisitorEntity visitor) {

    this.parameterToBeApplied.add(target -> target.setVisitor(visitor));

    return this;
  }

  /**
   * @param queue the queue to add.
   * @return the builder for fluent population of fields.
   */
  public AccessCodeEntityBuilder queue(final QueueEntity queue) {

    this.parameterToBeApplied.add(target -> target.setQueue(queue));

    return this;
  }

  /**
   * @return the populated AccessCodeEntity.
   */
  public AccessCodeEntity createNew() {

    AccessCodeEntity accesscodeentity = new AccessCodeEntity();
    for (Consumer<AccessCodeEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(accesscodeentity);
    }
    return accesscodeentity;
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
   * @return the AccessCodeEntity
   */
  public AccessCodeEntity persist(EntityManager em) {

    AccessCodeEntity accesscodeentity = createNew();
    em.persist(accesscodeentity);
    return accesscodeentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of AccessCodeEntity
   */
  public List<AccessCodeEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<AccessCodeEntity> accesscodeentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      AccessCodeEntity accesscodeentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(accesscodeentity);
      accesscodeentityList.add(accesscodeentity);
    }

    return accesscodeentityList;
  }

}
