package com.open.spring.mq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class BuyTopicListener implements MessageListener {

	public static Logger logger = Logger.getLogger(BuyTopicListener.class);

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			// 消息转化
			String msg = "";
			try {
				msg = ((TextMessage) message).getText();
				System.out.println("从BuyTopic收到消息:" + msg);
			} catch (Exception ex) {
				logger.error(ex);
				ex.printStackTrace();
				return;
			}
		}
	}
}
