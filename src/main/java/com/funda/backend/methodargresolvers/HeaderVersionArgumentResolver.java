/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.methodargresolvers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 *
 * @author phanic
 */
public class HeaderVersionArgumentResolver
        implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(Version.class) != null;
    }

    @Override
    public Object resolveArgument(
        MethodParameter methodParameter,
        ModelAndViewContainer modelAndViewContainer,
        NativeWebRequest nativeWebRequest,
        WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request
                = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        return request.getHeader("Version");
    }
}
