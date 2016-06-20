package cn.wudi.crm.utils;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

public class UserCtxTag extends ConditionalTagSupport {

	private static final long serialVersionUID = 65885563370430692L;

	private String permissionName;

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Override
	protected boolean condition() throws JspTagException {
		if (permissionName == null || "".equals(permissionName.trim())) {
			return false;
		}
		return UserContext.hasPermissionByName(permissionName);
	}

}
