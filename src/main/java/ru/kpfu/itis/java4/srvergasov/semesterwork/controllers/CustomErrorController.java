package ru.kpfu.itis.java4.srvergasov.semesterwork.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String getErrorPage(HttpServletRequest request, ModelMap modelMap) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String attrName = "errorText";
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                modelMap.addAttribute(attrName, "We haven't this page");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                modelMap.addAttribute(attrName, "Some problems with server, please contact us");
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                modelMap.addAttribute(attrName, "No access");
            } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                modelMap.addAttribute(attrName, "Some problems with request");
            } else if (statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
                modelMap.addAttribute(attrName, "Timeout");
            } else if (statusCode == HttpStatus.REQUEST_TIMEOUT.value()) {
                modelMap.addAttribute(attrName, "Some problems with request");
            } else if (statusCode == HttpStatus.I_AM_A_TEAPOT.value()) {
                modelMap.addAttribute(attrName, "i am a teapot");
            } else if (statusCode == HttpStatus.LOCKED.value()) {
                modelMap.addAttribute(attrName, "locked");
            } else if (statusCode == HttpStatus.NOT_IMPLEMENTED.value()) {
                modelMap.addAttribute(attrName, "not implemented");
            } else if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
                modelMap.addAttribute(attrName, "bad gateway");
            } else if (statusCode == HttpStatus.TOO_MANY_REQUESTS.value()) {
                modelMap.addAttribute(attrName, "too many requests");
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                modelMap.addAttribute(attrName, "you not authorized");
            } else {
                modelMap.addAttribute(attrName, "Some errors...");
            }
        } else {
            modelMap.addAttribute(attrName, "Unknown error");
        }
        return "errorPage";
    }

}
