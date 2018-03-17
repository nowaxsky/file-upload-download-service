package org.cpm.zwl.presentation.interfaces;

import javax.servlet.http.HttpServletResponse;
import org.cpm.zwl.commons.response.JsonResponse;
import org.cpm.zwl.constrants.FileStatus;
import org.cpm.zwl.exception.FudsBaseException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * file upload download service rest
 * 
 * @author Chuck
 *
 */
@FeignClient("file-upload-download-service")
public interface FileUploadDownloadRest {

  /**
   * 檔案上傳並變更狀態
   * 
   * @param file
   * @param statusFrom
   * @param statusTo
   * @return
   * @throws FudsBaseException
   */
  @ApiOperation(value = "檔案上傳並變更狀態", notes = "")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "file", value = "檔案", required = true, dataType = "__file",
          paramType = "form"),
      @ApiImplicitParam(name = "statusFrom", value = "初始狀態", allowableValues = "STATUS_A, STATUS_B",
          required = false, dataType = "FileStatus", paramType = "query"),
      @ApiImplicitParam(name = "statusTo", value = "欲變更狀態", allowableValues = "STATUS_A, STATUS_B",
          required = false, dataType = "FileStatus", paramType = "query")})
  @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
  JsonResponse<Boolean> uploadFile(@RequestParam("file") MultipartFile file,
      @RequestParam("statusFrom") FileStatus statusFrom,
      @RequestParam("statusTo") FileStatus statusTo) throws FudsBaseException;


  void downloadFile() throws FudsBaseException;


  /**
   * 直接將資料下載成檔案(不落地)
   * 
   * @param param
   * @param response
   * @throws FudsBaseException
   */
  @ApiOperation(value = "直接將資料下載成檔案(不落地)", notes = "")
  @ApiImplicitParam(name = "param", value = "參數", required = false, dataType = "string",
      paramType = "query")
  @RequestMapping(path = "/downloadFileWithoutBuild", method = RequestMethod.GET,
      produces = "text/csv")
  void downloadFileWithoutBuild(@RequestParam("param") String param, HttpServletResponse response)
      throws FudsBaseException;



}
