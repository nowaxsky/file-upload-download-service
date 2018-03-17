package org.cpm.zwl.service;

import javax.servlet.http.HttpServletResponse;
import org.cpm.zwl.constrants.FileStatus;
import org.cpm.zwl.exception.FudsBaseException;
import org.springframework.web.multipart.MultipartFile;


/**
 * 樂園一般功能
 * 
 * @author Chuck
 *
 */

public interface FileUploadDownloadService {

  /**
   * 檔案上傳並變更狀態
   * 
   * @param file
   * @param statusFrom
   * @param statusTo
   * @return
   * @throws LdsBaseException
   */
  public boolean uploadFile(MultipartFile file, FileStatus statusFrom, FileStatus statusTo)
      throws FudsBaseException;

  /**
   * 直接將資料下載成檔案(不落地)
   * 
   * @param param
   * @param response
   * @return
   * @throws FudsBaseException
   */
  public boolean downloadFileWithoutBuild(String param, HttpServletResponse response)
      throws FudsBaseException;
}
