package cn.jcera.fileservice.controller;

import cn.jcera.fileservice.core.entity.ResultBean;
import cn.jcera.fileservice.core.exception.ExceptionEnum;
import cn.jcera.fileservice.core.version.ApiVersion;
import cn.jcera.fileservice.util.FileDfsUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@ApiVersion(1)
public class FileController {

    @Resource
    private FileDfsUtil fileDfsUtil;

    @ApiOperation(value = "上传文件",notes = "FastDFS文件上传")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResultBean<String> upload(MultipartFile file) throws Exception {
        String result ;
        String path = fileDfsUtil.upload(file) ;
        if (!StringUtils.isEmpty(path)){
            result = path ;
        } else {
            result = "上传失败" ;
        }
        return ResultBean.success(result);
    }

    @ApiOperation(value = "通过文件路径删除文件",notes = "FastDFS文件删除")
    @RequestMapping(value = "/deleteByPath", method = RequestMethod.DELETE)
    public ResultBean<String> deleteByPath (String path){
        if (StringUtils.isEmpty(path)) {
            return new ResultBean<>(ExceptionEnum.ARGUMENTS_INVALID, "未指定参数path");
        }
        fileDfsUtil.deleteFile(path);
        return ResultBean.success("SUCCESS") ;
    }
}
