package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.Interview;

public interface InterviewService {
	public int insert(Interview interview);
	public Interview queryByUerId(int userId);
	public int updateChecked(int interviewId);
	public int updateReplyed(int interviewId);
	public List<Interview> queryByAdminIdAndReply(int adminId);
	public int deleteByResumeId(int resumeId);
}
