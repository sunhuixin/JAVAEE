package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.ResumeInfoDao;
import com.iotek.shx.entity.ResumeInfo;
import com.iotek.shx.service.ResumeInfoService;
@Service("resumeInfoService")
public class ResumeInfoServiceImpl implements ResumeInfoService {
	@Autowired
	private ResumeInfoDao resumeInfoDao;

	@Override
	public List<ResumeInfo> findByAdminId(int adminId) {
		return resumeInfoDao.queryByAdminId(adminId);
	}

	@Override
	public List<Integer> onlyfindResumeId() {
		return resumeInfoDao.onlyQueryResumeId();
	}

	@Override
	public int updateCheck(int rid) {
		return resumeInfoDao.updateCheck(rid);
	}

	@Override
	public int updateSend(int rid) {
		return resumeInfoDao.updateSend(rid);
	}

	@Override
	public ResumeInfo findByResumeId(int resumeId) {
		return resumeInfoDao.queryByResumeId(resumeId);
	}

	@Override
	public int updateHire(int rid) {
		return resumeInfoDao.updateHire(rid);
	}

	@Override
	public int deleteByResumeId(int rid) {
		return resumeInfoDao.deleteByResumeId(rid);
	}

}
