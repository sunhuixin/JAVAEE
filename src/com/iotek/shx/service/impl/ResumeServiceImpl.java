package com.iotek.shx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.ResumeDao;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.service.ResumeService;
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeDao resumeDao;
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
		// TODO Auto-generated method stub
		return resumeDao.queryResume(userId);
	}

}
