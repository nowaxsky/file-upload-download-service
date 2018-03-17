package org.cpm.zwl.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.cpm.zwl.commons.log.factories.ZwlLogFactory;
import org.cpm.zwl.commons.utils.ParseUtil;
import org.cpm.zwl.constrants.FileStatus;
import org.cpm.zwl.constrants.FudsErrorCode;
import org.cpm.zwl.exception.FudsBaseException;
import org.cpm.zwl.service.FileUploadDownloadService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadDownloadServiceImpl implements FileUploadDownloadService {
  private final Logger logger = ZwlLogFactory.getLogger(FileUploadDownloadServiceImpl.class);

  @Override
  public boolean uploadFile(MultipartFile file, FileStatus statusFrom, FileStatus statusTo)
      throws FudsBaseException {
    logger.info("===service-uploadFile starts===");
    try {
      List<String> contentByLine = ParseUtil.readCsv(file.getInputStream());
      contentByLine.stream().forEach(logger::info);
      logger.info(statusFrom.getValue());
      logger.info(statusTo.getValue());

    } catch (Exception e) {
      logger.error(FudsErrorCode.FUDS_UPLOAD_FILE_ERROR.getErrorCode(), e);
      throw new FudsBaseException(FudsErrorCode.FUDS_UPLOAD_FILE_ERROR);
    }

    logger.info("===service-uploadFile ends===");
    return true;
  }

  @Override
  public boolean downloadFileWithoutBuild(String param, HttpServletResponse response)
      throws FudsBaseException {
    logger.info("===service-downloadFileWithoutBuild starts===");
    logger.info("param: " + param);
    String fileName = "file";
    String source = "test";
    try {
      InputStream is = IOUtils.toInputStream(source, "UTF-8");
      IOUtils.copy(is, response.getOutputStream());
      response.setContentType("application/octet-stream");
      response.setHeader("Content-Disposition", "inline; filename=" + fileName);
      response.flushBuffer();

    } catch (IOException e) {
      logger.error(FudsErrorCode.FUDS_UNKNOW_ERROR.getErrorCode(), e);
      throw new FudsBaseException(FudsErrorCode.FUDS_UNKNOW_ERROR);
    }
    logger.info("===service-downloadFileWithoutBuild starts===");
    return true;
  }

}
