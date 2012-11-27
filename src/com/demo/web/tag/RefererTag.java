package com.demo.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport {
	private String site;
	private String page;

	public void setSite(String site) {
		this.site = site;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// 得到来访者的referer
		PageContext pageContext = (PageContext) this.getJspContext();

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();

		String referer = request.getHeader("referer");
		if (referer == null || !referer.startsWith(site)) {

			if (page.startsWith(request.getContextPath())) {
				response.sendRedirect(page);
				return;
			} else if (page.startsWith("/")) {
				response.sendRedirect(request.getContextPath() + page);
			} else {
				response.sendRedirect(request.getContextPath() + "/" + page);
			}
			throw new SkipPageException();
		}
		
	}

}
