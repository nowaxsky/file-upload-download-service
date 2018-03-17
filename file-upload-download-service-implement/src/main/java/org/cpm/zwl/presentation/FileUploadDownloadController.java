package org.cpm.zwl.presentation;

import javax.servlet.http.HttpServletResponse;
import org.cpm.zwl.commons.log.factories.ZwlLogFactory;
import org.cpm.zwl.commons.response.JsonResponse;
import org.cpm.zwl.commons.utils.JsonResponseUtil;
import org.cpm.zwl.constrants.FileStatus;
import org.cpm.zwl.exception.FudsBaseException;
import org.cpm.zwl.presentation.interfaces.FileUploadDownloadRest;
import org.cpm.zwl.service.FileUploadDownloadService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/fileuploaddownload")
public class FileUploadDownloadController implements FileUploadDownloadRest {

  private final Logger logger = ZwlLogFactory.getLogger(FileUploadDownloadController.class);

  @Autowired
  private FileUploadDownloadService service;

  @Override
  public JsonResponse<Boolean> uploadFile(MultipartFile file, FileStatus statusFrom,
      FileStatus statusTo) throws FudsBaseException {
    logger.info("===controller-uploadFile starts===");
    JsonResponse<Boolean> response = null;
    boolean result = service.uploadFile(file, statusFrom, statusTo);
    response = JsonResponseUtil.getSuccess(result, null);
    logger.info("===controller-uploadFile ends===");
    return response;
  }

  @Override
  public void downloadFile() throws FudsBaseException {
    // TODO Auto-generated method stub

  }

  @Override
  public void downloadFileWithoutBuild(String param, HttpServletResponse response)
      throws FudsBaseException {
    logger.info("===controller-downloadFileWithoutBuild starts===");
    service.downloadFileWithoutBuild(param, response);
    logger.info("===controller-downloadFileWithoutBuild ends===");
    return;

  }



}
