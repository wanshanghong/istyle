package com.istyle.mapper;

import com.istyle.pojo.TbSubmission;

import java.util.List;

public interface TbSubmissionMapper {
//    通过id查询投稿信息
    List<TbSubmission> findSubmissionIdByUserId(Long userId);
//    通过id查询投稿数量
    Long selectSubCountByUserId(Long userId);
}
