package com.topalps.learn;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector;

public class StaticServer {

	public static void main(String[] args) throws Exception{
		Server server = new Server();
		
		NetworkTrafficSelectChannelConnector connector = new NetworkTrafficSelectChannelConnector(server);
		connector.setPort(9000);
		
		server.addConnector(connector);
		
		ResourceHandler handler = new ResourceHandler();
		handler.setDirectoriesListed(true);
		handler.setWelcomeFiles(new String[]{"index.html"});

		handler.setResourceBase("/Users/chengda/Sites");
		handler.setEtags(true);
		server.setHandler(handler);
		
		server.start();
		server.join();
		
	}

}
