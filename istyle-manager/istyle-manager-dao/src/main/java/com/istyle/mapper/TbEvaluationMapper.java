package com.istyle.mapper;

import com.istyle.pojo.TbEvaluation;

import java.util.List;

public interface TbEvaluationMapper {
    Long selectEvalCountByUserId(Long userId);
    List<TbEvaluation> selectEvalByUserId(Long userId);
}
