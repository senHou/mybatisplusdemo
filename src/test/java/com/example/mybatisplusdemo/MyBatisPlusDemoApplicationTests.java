package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.mybatisplusdemo.entity.UserInfo;
import com.example.mybatisplusdemo.mapper.UserInfoMapper;
import com.example.mybatisplusdemo.service.UserInfoService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MyBatisPlusDemoApplicationTests {

    @Autowired
    UserInfoService userInfoService;
    private Logger log = LoggerFactory.getLogger(getClass());
    @BeforeEach
    public void before()  {
        log.info("init some data");
    }
    @AfterEach
    public void after(){
        log.info("clean some data");
    }

    @Test
    public void save()  {
        log.info("your method test Code");

        for(int i =1;i<10;i++) {
            UserInfo ui =  new UserInfo();
            ui.setUserId(i+"id");
            userInfoService.removeById(i+"id");
            ui.setUsername("HBLOG"+i);
            ui.setAge(i);
            userInfoService.save(ui);
        }
    }

    @Test
    public void search() {
        UserInfo userInfo = userInfoService.getById("6id");
        assertEquals("HBLOG6", userInfo.getUsername());
    }

    @Test
    public void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setRemark("This is a remark");
        LambdaUpdateWrapper<UserInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(UserInfo::getUserId, "6id");
        userInfoService.update(userInfo, lambdaUpdateWrapper);
    }

}
