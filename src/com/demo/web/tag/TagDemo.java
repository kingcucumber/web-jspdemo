package com.demo.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return Tag.EVAL_BODY_INCLUDE;
	}
	
}
