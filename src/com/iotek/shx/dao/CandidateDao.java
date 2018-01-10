package com.iotek.shx.dao;

import java.util.List;

import com.iotek.shx.entity.Candidate;

public interface CandidateDao {
	public  int saveCandidate(Candidate candidate);
	public int deleteCandidate(int id);
	public List<Candidate> queryAll();

}
