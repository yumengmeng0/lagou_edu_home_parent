package org.example.mapper;

import org.example.domain.Test;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/16
 * @version: 1.0.0
 * @description:
 */
public interface TestMapper {

    public List<Test> findAll();
}
