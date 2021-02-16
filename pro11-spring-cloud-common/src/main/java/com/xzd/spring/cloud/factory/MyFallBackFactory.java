package com.xzd.spring.cloud.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xzd.spring.cloud.api.EmployeeRemoteService;
import com.xzd.spring.cloud.entity.Employee;
import com.xzd.spring.cloud.util.ResultEntity;

import feign.hystrix.FallbackFactory;
@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService>{

	@Override
	public EmployeeRemoteService create(Throwable cause) {
		return new EmployeeRemoteService() {

			@Override
			public Employee getEmployeeRemote() {
				return null;
			}

			@Override
			public List<Employee> getEmpListRemote(String keyword) {
				return null;
			}

			@Override
			public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal) {
				return ResultEntity.failed(cause.getMessage());
			}
			
		};
	}
	
}
