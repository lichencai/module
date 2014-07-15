package org.event;

import java.util.EventObject;
/**
 * 自定义事件类型定义
 */
public class MethodExecutionEvent extends EventObject{
	
	private static final long serialVersionUID = 9035996506323512826L;
	private String methodName ;
	
	public MethodExecutionEvent(Object source) {
		super(source);
	}

	public MethodExecutionEvent(Object source, String methodName) {
		super(source);
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
