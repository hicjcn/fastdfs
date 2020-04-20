package cn.jcera.fileservice.controller;

import cn.jcera.fileservice.core.version.ApiVersion;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiVersion(1)
public class FileController {

    @ApiOperation(value = "接口的功能介绍",notes = "提示接口使用者注意事项",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "name",value = "姓名",required = true)
    @RequestMapping(value = "/demo")
    public String index(String name) {

        return "hello "+ name;
    }
}
