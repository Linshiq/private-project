package com.lsq.db.dao;

import com.lsq.db.model.Task;

public interface TaskMapper {
    int insert(Task record);

    int insertSelective(Task record);
}