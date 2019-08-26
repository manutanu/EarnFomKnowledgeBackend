package com.KnowledgeQuizApp.config;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

@Component
public class WebSocketSessionListener
{
    
    private List<String> connectedClientId = new ArrayList<String>();

    @EventListener
    public void connectionEstablished(SessionConnectedEvent sce)
    {
//    	System.out.println(sce.toString());
    	Message mm=sce.getMessage();
//    	System.out.println(mm.toString());
        MessageHeaders msgHeaders = sce.getMessage().getHeaders();
//        System.out.println(mm.getHeaders());
//        System.out.println(mm.getHeaders().containsKey("simpSessionId"));
        GenericMessage generic=(GenericMessage)mm.getHeaders().get("simpConnectMessage");
        MessageHeaders hh=generic.getHeaders();
//        System.out.println(hh.get("nativeHeaders"));
        Map<String,Object> lastmap=(Map<String,Object>)hh.get("nativeHeaders");
//        System.out.println(lastmap.get("username"));
        List<String> list=(List<String>)lastmap.get("username");
        String usernameOfcurrentSession=list.get(0);
        
        mm.getHeaders().get("simpSessionId");
//        System.out.println(ob);
//        Principal princ = (Principal) msgHeaders.get("simpUser");
//        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sce.getMessage());
//        List<String> nativeHeaders = sha.getNativeHeader("username");
//        System.out.println(nativeHeaders);
        
        if( usernameOfcurrentSession != null )
        {
            String userId = usernameOfcurrentSession;
            connectedClientId.add(userId);
           
                System.out.println("User with username => "+userId+"  connected !");
            
        }
        else
        {
//            String userId = princ.getName();
            connectedClientId.add("");
            
            
                System.out.println("User with username => "+""+"  connected !");
            
        }
        System.out.println("connected People "+connectedClientId);
    }
    
    
    
    @EventListener
    public void webSockectDisconnect(SessionUnsubscribeEvent sde)
    {
//    	System.out.println(sde.toString());
    	Message mm=sde.getMessage();
//    	System.out.println(mm.toString());
        MessageHeaders msgHeaders = sde.getMessage().getHeaders();
//        System.out.println(mm.getHeaders());
//        System.out.println(mm.getHeaders().containsKey("nativeHeaders"));
//        GenericMessage generic=(GenericMessage)mm.getHeaders().get("simpConnectMessage");
//        MessageHeaders hh=generic.getHeaders();
//        System.out.println(hh.get("nativeHeaders"));
//        System.out.println(mm.getHeaders().get("nativeHeaders"));
        Map<String,List<String>> mapmm= (Map<String,List<String>>)mm.getHeaders().get("nativeHeaders");
        String username=mapmm.get("id").get(0);
        
        
        
        if( username != null )
        {
            String userId = username;
            connectedClientId.remove(userId);
           
                System.out.println("User with username => "+userId+"  disconnected !");
           
        }
        else
        {
            String userId = "";
            connectedClientId.remove(userId);
            
            
                System.out.println("User with username => "+userId+"  disconnected !");
            
        }
        System.out.println("connected People from disconnecd section "+connectedClientId);
    }

    public List<String> getConnectedClientId()
    {
        return connectedClientId;
    }
    public void setConnectedClientId(List<String> connectedClientId)
    {
        this.connectedClientId = connectedClientId;
    }
}