package org.event;

/**
 * 自定义事件监听器具体实现类
 */
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {
	
	public void onMethodBegin(MethodExecutionEvent evt) {
		String methodName = evt.getMethodName();
		System.out.println("start to execute the method["+methodName+"].");
	}
	public void onMethodEnd(MethodExecutionEvent evt) { String methodName = evt.getMethodName();
		System.out.println("finished to execute the method["+methodName+"].");
	}
	
}
