package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.InterviewDao;
import com.iotek.shx.entity.Interview;
import com.iotek.shx.service.InterviewService;
@Service("interviewService")
public class InterviewServcieImpl implements InterviewService {
	@Autowired
	private InterviewDao interviewDao;

	@Override
	public int insert(Interview interview) {
		return interviewDao.insert(interview);
	}

	@Override
	public Interview queryByUerId(int userId) {
		return interviewDao.queryByUerId(userId);
	}

	@Override
	public int updateChecked(int interviewId) {
		return interviewDao.updateChecked(interviewId);
	}

	@Override
	public int updateReplyed(int interviewId) {
		return interviewDao.updateReplyed(interviewId);
	}

	@Override
	public List<Interview> queryByAdminIdAndReply(int adminId) {
		return interviewDao.queryByAdminIdAndReply(adminId);
	}

	@Override
	public int deleteByResumeId(int resumeId) {
		return interviewDao.deleteByResumeId(resumeId);
	}

}
