package com.hzz.thenewsweb.action;

import com.hzz.thenewsweb.util.ActionUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;


@ParentPackage("struts-default")
public class ImgeUploadAction extends ActionSupport {
    private static final long serialVersionUID = 1149450310707652640L;

    @Action(value = "multipartAction")
    public void multipartAction() throws Exception {
        ActionUtils.ImgsUploadResponse("D:\\hzz\\temp");
    }

    @Action(value = "logingimgup")
    public void loginimgAction() throws Exception {

        ActionUtils.ImgsUploadResponse("D:\\hzz\\temp");
    }
}
