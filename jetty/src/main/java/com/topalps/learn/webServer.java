package com.topalps.learn;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class webServer {


	public static void main(String[] args) throws Exception{
		Server server = new Server();
		
		NetworkTrafficSelectChannelConnector connector = new NetworkTrafficSelectChannelConnector(server);
		connector.setPort(9000);
		server.addConnector(connector);

		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/test");
		webapp.setWar("/Users/chengda/jetty-learn/jetty/src/main/resources/test.war");
		
		server.setHandler(webapp);
		server.start();
		server.join();
	}

}
