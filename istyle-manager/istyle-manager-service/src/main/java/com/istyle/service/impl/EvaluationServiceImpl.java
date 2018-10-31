package com.istyle.service.impl;

import com.istyle.mapper.TbEvaluationMapper;
import com.istyle.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黄文伟
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private TbEvaluationMapper tbEvaluationMapper;

}
