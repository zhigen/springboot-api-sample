package com.zglu.api.config;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zglu.api.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 拦截错误统一处理
 *
 * @author zglu
 */
@Api(tags = "1.错误配置")
@ApiSupport(order = 1)
@Controller
@AllArgsConstructor
public class MyErrorController implements ErrorController {
    /**
     * 错误入口
     */
    private static final String ERROR_PATH = "/error";
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        // 指定错误入口
        return ERROR_PATH;
    }

    /**
     * 拦截原始错误页面，处理信息后输出内容到页面
     *
     * @param request 页面请求
     */
    @GetMapping(value = ERROR_PATH, produces = "text/html")
    public void error(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> m = getErrorAttributes(request);
        response.getWriter().write(Result.error(m).toString());
    }

    /**
     * 拦截原始错误请求，处理后返回统一响应对象
     *
     * @param request 接口请求
     * @return 统一响应对象
     */
    @ResponseBody
    @GetMapping(value = ERROR_PATH)
    @ApiOperation("1.错误请求")
    @ApiOperationSupport(order = 1)
    public Result<Void> restError(HttpServletRequest request) {
        Map<String, Object> m = getErrorAttributes(request);
        return Result.error(m);
    }

    /**
     * 获取错误信息
     *
     * @param request 请求
     * @return 错误信息
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(servletWebRequest, true);
    }
}
