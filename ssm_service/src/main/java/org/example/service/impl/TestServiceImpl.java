package org.example.service.impl;

import org.example.domain.Test;
import org.example.mapper.TestMapper;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/16
 * @version: 1.0.0
 * @description:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {
        return testMapper.findAll();
    }
}
