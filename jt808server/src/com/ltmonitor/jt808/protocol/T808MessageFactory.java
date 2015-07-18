﻿package com.ltmonitor.jt808.protocol;

import com.ltmonitor.jt808.tool.ClassUtils;
import com.ltmonitor.jt808.tool.Tools;


public final class T808MessageFactory
{
	public static IMessageBody Create(int messageType, byte[] messageBodyBytes)
	{

			String nameSpace = T808MessageFactory.class.getPackage().getName();
			String className = nameSpace + ".JT_" + Tools.ToHexString(messageType,2);
			
			Object messageBody = ClassUtils.getBean(className);
			if (messageBody != null)
			{
				IMessageBody msg = (IMessageBody)messageBody;
				msg.ReadFromBytes(messageBodyBytes);
				return msg;
			}
			return null;
	}

}