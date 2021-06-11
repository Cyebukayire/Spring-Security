package com.example.classbdemo;

import com.example.classbdemo.enumerations.ERoleName;
import com.example.classbdemo.model.Role;
import com.example.classbdemo.repositories.IRoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ClassbDemoApplicationTests {

	@Autowired
	private IRoleRepository roleRepository;

	@Test
	public void testCreateRoles(){
		roleRepository.deleteAll();
		Role admin = new Role(ERoleName.ROLE_ADMIN);
		Role user = new Role(ERoleName.ROLE_USER);

		roleRepository.saveAll(List.of(admin,admin,user));
		List<Role> listRoles = roleRepository.findAll();

		Assertions.assertThat(listRoles.size()).isEqualTo(2);
	}

	@Test
	void contextLoads() {
	}

}
