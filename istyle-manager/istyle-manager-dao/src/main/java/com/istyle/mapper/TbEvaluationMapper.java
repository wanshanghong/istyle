package com.istyle.mapper;

import com.istyle.pojo.TbEvaluation;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface TbEvaluationMapper {
    /**
     * 根据id查询测评数量
     * @param userId
     * @return
     */
    Long selectEvalCountByUserId(Long userId);

    /**
     * 根据id查询测评
     * @param userId
     * @return
     */
    List<TbEvaluation> selectEvalByUserId(Long userId);
}
