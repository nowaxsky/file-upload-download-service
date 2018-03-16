package org.cpm.zwl.presentation;

import javax.servlet.http.HttpServletResponse;
import org.cpm.zwl.commons.log.factories.ZwlLogFactory;
import org.cpm.zwl.commons.response.JsonResponse;
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
@RequestMapping(value = "/wonderlandGeneral")
public class FileUploadDownloadController implements FileUploadDownloadRest {

  private final Logger logger = ZwlLogFactory.getLogger(FileUploadDownloadController.class);

  @Autowired
  private FileUploadDownloadService service;

  @Override
  public JsonResponse<Boolean> uploadFile(MultipartFile file, FileStatus statusFrom,
      FileStatus statusTo) throws FudsBaseException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void downloadFile() throws FudsBaseException {
    // TODO Auto-generated method stub

  }

  @Override
  public void downloadFileWithoutBuild(String param, HttpServletResponse response)
      throws FudsBaseException {
    // TODO Auto-generated method stub

  }



}
