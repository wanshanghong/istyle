package com.istyle.mapper;

import com.istyle.pojo.TbSubmission;

import java.util.List;

public interface TbSubmissionMapper {
    List<TbSubmission> findSubmissionIdByUserId(Long userId);
}
