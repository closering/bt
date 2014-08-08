package coml.jpush;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class Jpush {
	public void pushMessage(String alias, String message){
		JPushClient jpushClient = new JPushClient("ce641348230f9930b2ba9e57", "61cbd176d99b34ec17d5926a");
        PushPayload payload = buildPushObject_message(alias, message);
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
	
	public void pushAlert(String alias, String alert){
		JPushClient jpushClient = new JPushClient("ce641348230f9930b2ba9e57", "61cbd176d99b34ec17d5926a");
        PushPayload payload = buildPushObject_alert(alias, alert);
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
	public PushPayload buildPushObject_message(String alias, String message) {
        return PushPayload.newBuilder().setPlatform(Platform.android())
        		.setAudience(Audience.alias(alias))
        		.setMessage(Message.content(message))
        		.setOptions(Options.newBuilder()
        						.setTimeToLive(5)
        						.build())
        		.build();
    }
	
	public PushPayload buildPushObject_alert(String alias, String alert) {
        return PushPayload.newBuilder().setPlatform(Platform.android())
        		.setAudience(Audience.alias(alias))
        		.setNotification(Notification.alert(alert))
        		.build();
    }
}
