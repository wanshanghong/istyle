package com.istyle.service.impl;

import com.istyle.mapper.TbEvaluationMapper;
import com.istyle.pojo.TbEvaluation;
import com.istyle.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private TbEvaluationMapper tbEvaluationMapper;

    @Override
    public Long selectEvaluationCountByUserId(Long userId) {
        return tbEvaluationMapper.selectEvalCountByUserId(userId);
    }

    @Override
    public List<TbEvaluation> selectEvaluationByUserId(Long userId) {
        return tbEvaluationMapper.selectEvalByUserId(userId);
    }
}
