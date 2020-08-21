package com.zglu.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zglu.api.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 拦截错误统一处理
 *
 * @author zglu
 */
@Log4j2
@Api(tags = "1. 错误拦截")
@ApiSupport(order = 1)
@Controller
@RequestMapping("/error")
@AllArgsConstructor
public class MyErrorController implements ErrorController {
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        // 指定错误入口
        return "/error";
    }

    /**
     * 拦截原始错误请求，处理后返回统一响应对象
     *
     * @param request 接口请求
     * @return 统一响应对象
     */
    @GetMapping
    @ResponseBody
    @ApiOperation("1. 错误请求")
    @ApiOperationSupport(order = 1)
    public Result<Void> error(HttpServletRequest request) {
        Map<String, Object> m = getErrorAttributes(request);
        return Result.error(m);
    }

    /**
     * 拦截原始错误页面，处理信息后输出内容到页面
     *
     * @param request 页面请求
     */
    @ApiIgnore
    @GetMapping(produces = "text/html")
    public void errorHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> m = getErrorAttributes(request);
        Result<Void> result = Result.error(m);
        String html = new ObjectMapper().writeValueAsString(result);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(html);
    }

    /**
     * 获取错误信息
     *
     * @param request 请求
     * @return 错误信息
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String, Object> map = this.errorAttributes.getErrorAttributes(servletWebRequest, true);
        log.warn("错误请求\n{}", map);
        return map;
    }
}
