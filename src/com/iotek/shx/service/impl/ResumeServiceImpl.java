package com.iotek.shx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.ResumeDao;
import com.iotek.shx.dao.ResumeInfoDao;
import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.service.ResumeService;
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ResumeInfoDao resumeInfoDao;
	@Override
	public int addResume(Resume resume) {
		return resumeDao.saveResume(resume);
	}

	@Override
	public int updateResume(Resume resume) {
		return resumeDao.updateResume(resume);
	}

	@Override
	public Resume findResume(int userId) {
		return resumeDao.queryResume(userId);
	}

	@Override
	public Resume findByResumeId(int resumeId) {
		return resumeDao.queryByResumeId(resumeId);
	}

	@Override
	public int updateDepartAndPosition(Resume resume, Administrator admin, Position position) {
		return resumeDao.updateDepartAndPosition(resume, admin, position);
	}

	@Override
	public boolean changeInfoCheckedById(int rid) {
		return resumeInfoDao.updateCheck(rid)>0?true:false;
	}

	@Override
	public boolean changeInfoSendedById(int rid) {
		return resumeInfoDao.updateSend(rid)>0?true:false;
	}

}
