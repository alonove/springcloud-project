package com.jun.service.fallback;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jun.entity.Dept;
import com.jun.service.DeptClientService;

import feign.hystrix.FallbackFactory;

/**
 * 远程服务调用出错后的回调实现
 * @Author Jun
 * @date 2019年12月6日 下午2:11:51
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {

		return new DeptClientService() {

			@Override
			public List<Dept> list() {
				return Arrays.asList(Dept.builder().name("未查询到相关信息").source("NO DB SOURCE").build());
			}

			@Override
			public Dept get(Long id) {
				return Dept.builder().id(id).name("未查询到ID为"+id+"的信息").source("NO DB SOURCE").build();
			}
		};
	}

}
