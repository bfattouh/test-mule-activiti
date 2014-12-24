package com.appnovation.activiti.test;


import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;


/**
 * 
 * @author bfattouh
 *
 */
public class StartProcessInstanceTest extends FunctionalTestCase {
	
	@Override
	protected String getConfigResources()
	{
	    return "test-activiti.xml";
	}
	
	
	@Test
	public void testStartProcessInstance() throws Exception{
		MuleClient client = new MuleClient(muleContext);
	    String payload = "{\"processDefinitionKey\":\"create-account\"}";
	    MuleMessage result = client.send("jms://StartPIQueue", payload, null);
	    System.out.println("Test result: " + result.getPayloadAsString());
	    
	    //{"id":"7525","url":"http://localhost:8080/activiti-rest/service/runtime/process-instances/7525","businessKey":null,
	    //"suspended":false,"ended":false,"processDefinitionId":"create-account:1:20003",
	    //"processDefinitionUrl":"http://localhost:8080/activiti-rest/service/repository/process-definitions/create-account:1:20003",
	    //"activityId":"usertask1","variables":[],"tenantId":"","completed":false}
	}

}
