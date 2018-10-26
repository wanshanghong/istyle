package com.istyle.service;

import com.istyle.pojo.TbEvaluation;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface EvaluationService {
    /**
     * 查询测评数量
     * @param userId
     * @return
     */
    Long selectEvaluationCountByUserId(Long userId);

    /**
     * 查询造型师昵称及图片
     * @param userId
     * @return
     */
    List<TbEvaluation> selectEvaluationByUserId(Long userId);
}
