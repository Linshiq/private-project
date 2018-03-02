package lsq.dao;

import lsq.model.Photo;

public interface PhotoMapper {
    int insert(Photo record);

    int insertSelective(Photo record);
}