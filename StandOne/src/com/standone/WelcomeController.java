package com.standone;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.standone.web.manager.DropDownManager;

public class WelcomeController extends AbstractController {

	protected final Log logger = LogFactory.getLog(getClass());
	private DropDownManager ddMgr;
	public DropDownManager getDdMgr() {
		return ddMgr;
	}
	public void setDdMgr(DropDownManager ddMgr) {
		this.ddMgr = ddMgr;
	}
	@Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ddMgr.prepareDropDowns();
        return new ModelAndView("welcome");
    }
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
