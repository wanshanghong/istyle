package com.istyle.service;

import com.istyle.pojo.TbEvaluation;

import java.util.List;

public interface EvaluationService {
    //    查询测评数量
    Long selectEvaluationCountByUserId(Long userId);
    //    查询造型师昵称及图片
    List<TbEvaluation> selectEvaluationByUserId(Long userId);
}
