package com.itmayi.day01.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {

    // 利用aop技术，创建单独的线程执行，
    @Async
    public String addMember() {
       /*
        相当于
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("3");

            }
        }).start();*/
        log.info("2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("3");

        return "addMember";
    }

}
