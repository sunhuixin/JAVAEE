package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.AdministratorDao;
import com.iotek.shx.dao.InterviewDao;
import com.iotek.shx.dao.ResumeInfoDao;
import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Interview;
import com.iotek.shx.entity.ResumeInfo;
import com.iotek.shx.service.AdministratorService;
@Service("adminService")
public class AdministratorServiceImpl implements AdministratorService {
	@Autowired
	private AdministratorDao adminDao;
	@Autowired
	private ResumeInfoDao resumeInfoDao;
	@Autowired
	private InterviewDao interviewDao;
	@Override
	public Administrator findByNameAndPassword(Administrator admin) {
		return adminDao.queryByNameAndPassword(admin);
	}

	@Override
	public List<Administrator> findByDepartId(int departId) {
		return adminDao.queryByDepartId(departId);
	}

	@Override
	public Administrator findById(int adminId) {
		return adminDao.queryById(adminId);
	}

	@Override
	public List<ResumeInfo> getResumeInfoByAdminId(int adminId) {
		return resumeInfoDao.queryByAdminId(adminId);
	}

	@Override
	public List<Interview> receiveReply(int adminId) {
		return interviewDao.queryByAdminIdAndReply(adminId);
	}

	@Override
	public boolean sendInterview(Interview interview) {
		boolean flag =true;
		int resumeId = interview.getResume().getId();
		ResumeInfo resumeInfo=resumeInfoDao.queryByResumeId(resumeId);
		if(resumeInfo.getSend()==0){
			flag=false;
		}else{
			flag=interviewDao.insert(interview)==0?false:true;
			resumeInfoDao.updateSend(resumeId);
		}
		return flag;
	}

}
