package lsq.dao;

import lsq.model.Html;

public interface HtmlMapper {
    int deleteByPrimaryKey(String htmlid);

    int insert(Html record);

    int insertSelective(Html record);

    Html selectByPrimaryKey(String htmlid);

    int updateByPrimaryKeySelective(Html record);

    int updateByPrimaryKey(Html record);
}