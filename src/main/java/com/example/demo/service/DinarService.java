package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DinarModel;
import com.example.demo.repository.DinarRepository;

@Service
@Transactional
public class DinarService {

	@Autowired
	private DinarRepository dinarRepository; //konek ke dinarRepository
	
	public void save(DinarModel dinarModel) {
		dinarRepository.save(dinarModel);
	}
	
	public List<DinarModel> read() {
		return this.dinarRepository.findAll();
	}
	
	/*
	 * public DinarModel searchKodeDinar(String kode) { return
	 * this.dinarRepository.searchKodeDinar(kode); }
	 */
	
	public DinarModel searchIdDinar(Integer id) {
		return this.dinarRepository.searchIdDinar(id);
	}
	
	public void update(DinarModel dinarModel) {
		dinarRepository.save(dinarModel);
	}
	
	public void delete(DinarModel dinarModel) {
		dinarRepository.delete(dinarModel);
	}
	
	public Integer searchMaxId () {
		return this.dinarRepository.searchMaxId();
	}
	
	public DinarModel searchNomorNota(String nomorNota) {
		return this.dinarRepository.searchNomorNota(nomorNota);
	}
}
