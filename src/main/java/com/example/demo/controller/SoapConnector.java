package com.example.demo.controller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.tempuri.*;
import lombok.NoArgsConstructor;

@Component
public class SoapConnector extends WebServiceGatewaySupport{
	
	public int add(int a, int b) {
		Add addRequest = new Add();
		addRequest.setIntA(a);
		addRequest.setIntB(b);

		AddResponse response = (AddResponse) getWebServiceTemplate()
				.marshalSendAndReceive(addRequest,
						new SoapActionCallback("http://www.dneonline.com/calculator.asmx"));
		
		return 0;
	}

}
