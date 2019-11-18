package com.example.demo.dao;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.demo.model.dto.Add;
import com.example.demo.model.dto.AddResponse;
@Component
public class SoapConnector extends WebServiceGatewaySupport{
	public int add(int a, int b) {
		Add addRequest = new Add();
		addRequest.setIntA(a);
		addRequest.setIntB(b);
		//String result;
		AddResponse response = (AddResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/endpoint", addRequest,
						new SoapActionCallback(
								"http://www.dneonline.com/calculator.asmx"));
		
		return 0;
	}

}
