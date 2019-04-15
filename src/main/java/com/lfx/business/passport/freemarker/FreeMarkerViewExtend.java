package com.lfx.business.passport.freemarker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liufeixiang on 2019/3/13.
 */
@Slf4j
public class FreeMarkerViewExtend extends FreeMarkerView {

    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request){

        try {
            super.exposeHelpers(model, request);
        } catch (Exception e) {
            log.error("FreeMarkerViewExtend 加载父类出现异常。请检查。",e);
        }
    }
}
