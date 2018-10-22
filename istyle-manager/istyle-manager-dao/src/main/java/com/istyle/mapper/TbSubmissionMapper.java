package com.istyle.mapper;

import com.istyle.pojo.TbSubmission;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface TbSubmissionMapper {

    /**
     * 通过id查询投稿信息
     * @param userId
     * @return
     */
    List<TbSubmission> findSubmissionIdByUserId(Long userId);

    /**通过id查询投稿数量
     * @param userId
     * @return
     */
    Long selectSubCountByUserId(Long userId);
}
