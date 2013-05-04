package com.topalps.learn;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.topalps.learn.servlet.HelloServlet;
import com.topalps.learn.servlet.HiSevlet;

public class ServletServer {

	public static void main(String[] args) throws Exception{
		Server server = new Server();
		
		NetworkTrafficSelectChannelConnector connector = new NetworkTrafficSelectChannelConnector(server);
		connector.setPort(9000);
		
		server.addConnector(connector);
		
		ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/");
		
		server.setHandler(context);
		context.addServlet(HelloServlet.class, "/hello");
		
		context.addServlet(new ServletHolder(HiSevlet.class), "/hi");
		
		server.start();
		server.join();
	}

}
