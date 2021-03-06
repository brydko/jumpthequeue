package com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase;

import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeEto;

/**
 * Interface of UcManageAccessCode to centralize documentation and signatures of methods.
 */
public interface UcManageAccessCode {

  /**
   * Deletes a accessCode from the database by its id 'accessCodeId'.
   *
   * @param accessCodeId Id of the accessCode to delete
   * @return boolean <code>true</code> if the accessCode can be deleted, <code>false</code> otherwise
   */
  void deleteAccessCode(long accessCodeId);

  /**
   * Saves a accessCode and store it in the database.
   *
   * @param accessCode the {@link AccessCodeEto} to create.
   * @return the new {@link AccessCodeEto} that has been saved with ID and version.
   */
  AccessCodeEto saveAccessCode(AccessCodeEto accessCode);

}
