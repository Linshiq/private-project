package lsq.dao;

import lsq.model.Task;

public interface TaskMapper {
    int insert(Task record);

    int insertSelective(Task record);
}