package com.test;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class testPush {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPushClient jpushClient = new JPushClient("ce641348230f9930b2ba9e57", "61cbd176d99b34ec17d5926a");
        PushPayload payload = buildPushObject_all_all_alert();
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);

        } catch (APIConnectionException e) {
        	System.out.println("Connection error, should retry later"+ e);

        } catch (APIRequestException e) {
        	System.out.println("Should review the error, and fix the request"+ e);
        	System.out.println("HTTP Status: " + e.getStatus());
        	System.out.println("Error Code: " + e.getErrorCode());
        	System.out.println("Error Message: " + e.getErrorMessage());
        }
	}
	public static PushPayload buildPushObject_all_all_alert() {
        //return PushPayload.alertAll("nishi shei a !!!");
        return PushPayload.newBuilder().setPlatform(Platform.android())
        		.setAudience(Audience.tag("student"))
        		.setAudience(Audience.alias("bucengyaoyuan1"))
        		.setNotification(Notification.alert("wo shi zhang bingbing"))
        		.setMessage(Message.content(""))
        		.build();
    }
}
