package org.cpm.zwl.constrants;

import org.cpm.zwl.commons.constrants.ErrorCodeInterface;

public enum FudsErrorCode implements ErrorCodeInterface {

  /**
   * unknown
   */
  FUDS_UNKNOW_ERROR("FUDS_UNKNOW_ERROR", "unknown error"),

  /*
   * cannot upload file
   */
  FUDS_UPLOAD_FILE_ERROR("FUDS_UPLOAD_FILE_ERROR", "cannot upload file"),

  /*
   * cannot download file without buildind
   */
  FUDS_DOWNLOAD_FILE_WITHOUT_BUILD_ERROR("FUDS_DOWNLOAD_FILE_WITHOUT_BUILD_ERROR",
      "cannot download file without buildind"),;

  private String errorCode;
  private String message;

  FudsErrorCode(String errorCode, String message) {
    this.errorCode = errorCode;
    this.message = message;
  }

  @Override
  public String getErrorCode() {
    return this.errorCode;
  }

  @Override
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;

  }

  @Override
  public String getMessage() {
    return this.message;
  }

  @Override
  public void setMessage(String message) {
    this.message = message;

  }


}
