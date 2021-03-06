package com.simplemall.pay.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplemall.micro.serv.common.bean.RestAPIResult;
import com.simplemall.pay.service.IPayService;

@RestController
@RequestMapping("/payController")
public class PayController {

	@Autowired
	IPayService payService;
	
	/**
	 * pay 
	 * 
	 * @param serialNo
	 * @param payType
	 * @return
	 */
	@RequestMapping(value = "/pay",method = RequestMethod.POST)
	public RestAPIResult<Integer> pay(@RequestParam("serialNo") String serialNo,@RequestParam("payType") String payType,@RequestParam("status") String status){
		int result = payService.pay(serialNo, payType, status);
		RestAPIResult<Integer> apiResult = new RestAPIResult<Integer>();
		apiResult.setRespData(result);
		return apiResult;
	}
}
