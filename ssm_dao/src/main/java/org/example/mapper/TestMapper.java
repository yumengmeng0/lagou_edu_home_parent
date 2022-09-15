package org.example.mapper;

import org.example.domain.Test;

import java.util.List;

/**
 * @author
 */
public interface TestMapper {

    /**
     * 查找所有
     *
     * @return
     */
    List<Test> findAll();
}
