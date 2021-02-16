package com.xzd.spring.cloud.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xzd.spring.cloud.entity.Employee;
import com.xzd.spring.cloud.factory.MyFallBackFactory;
import com.xzd.spring.cloud.util.ResultEntity;

@FeignClient(value = "xzd-provider" ,fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote();
	@RequestMapping("/provider/get/emp/remote")
	List<Employee> getEmpListRemote(@RequestParam("keyword")String keyword);
	@RequestMapping("/provider/get/emp/with/circuit/breaker")
	public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal);
}
