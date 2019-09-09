package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.DinarModel;
import com.example.demo.service.DinarService;

@Controller
@RequestMapping ("/dinar")
public class DinarController {
	
	@Autowired
	private DinarService dinarService;
	
	@RequestMapping("/home")
	public String doHome() {
		String page = "/dinar/home";
		return page;
	}
	
	@RequestMapping("/tambah")
	public String doAdd(Model model) {
		this.doGenerateKode(model);
		String page = "/dinar/add";
		return page;
	}
	
	
	@RequestMapping("/create")
	public String doCreate(HttpServletRequest request) throws ParseException { //request untuk ambil nilai dari html
		
		
		String nomorNota = request.getParameter("nomorNota");
		String tanggalNota = request.getParameter("tanggalNota");
		String vendor = request.getParameter("vendor");		
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
				
		DinarModel dinarModel = new DinarModel();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(tanggalNota);
		
		
		dinarModel.setNomorNota(nomorNota);	
		dinarModel.setTanggalNota(date1);
		dinarModel.setVendor(vendor);
		dinarModel.setKadar(916);
		dinarModel.setBerat(425);
		dinarModel.setQuantity(quantity);
		
		
				
		this.dinarService.save(dinarModel);
		
		String page = "/dinar/home";
		return page;
	}
	
	@RequestMapping("/data")
	public String doList(Model model) {
		List<DinarModel> dinarModelList = new ArrayList<DinarModel>();
		dinarModelList = this.dinarService.read();
		model.addAttribute("dinarModelList", dinarModelList);
		
		String page = "/dinar/list";
		return page;
	}
	
	@RequestMapping("/detail")
	public String doDetail(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		DinarModel dinarModel = new DinarModel();
		dinarModel = this.dinarService.searchIdDinar(id);
		model.addAttribute("dinarModel", dinarModel);		
		
		return "/dinar/detail";
	}
	
	@RequestMapping("/ubah")
	public String doUbah(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		DinarModel dinarModel = new DinarModel();
		dinarModel = this.dinarService.searchIdDinar(id);
		model.addAttribute("dinarModel", dinarModel);
		
		return "/dinar/edit";
	}
	
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest request) throws ParseException {
		
		String nomorNotaSb = request.getParameter("nomorNotaSb");
		String nomorNota = request.getParameter("nomorNota");
		String tanggalNota = request.getParameter("tanggalNota");
		String vendor = request.getParameter("vendor");		
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(nomorNota);
		
		DinarModel dinarModel = new DinarModel();
		dinarModel = this.dinarService.searchNomorNota(nomorNotaSb);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(tanggalNota);
		System.out.println(nomorNota);
		
		dinarModel.setNomorNota(nomorNota);	
		dinarModel.setTanggalNota(date1);
		dinarModel.setVendor(vendor);
		dinarModel.setKadar(916);
		dinarModel.setBerat(425);
		dinarModel.setQuantity(quantity);
		this.dinarService.update(dinarModel);
		
		return "/dinar/home";
	}
	
	@RequestMapping ("/hapus")
	public String doHapus(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		DinarModel dinarModel = new DinarModel();
		dinarModel = this.dinarService.searchIdDinar(id);
		
		this.dinarService.delete(dinarModel);
		
		
		return "/dinar/home";
	}
	
	public void doGenerateKode(Model model) {
		
		Integer maxId = 0;
		maxId = this.dinarService.searchMaxId();
		if (maxId == null) {
			maxId = 1;
		} else {
			maxId += 1;
		}
		
		String kodeGenerator = "D00"+maxId;
		model.addAttribute("kodeGenerator", kodeGenerator);
	}
	
	/*
	 * @RequestMapping("/search/nama") public String doSearchNama(HttpServletRequest
	 * request, Model model) { String namadinar = request.getParameter("namadinar");
	 * 
	 * List<DinarModel> dinarModelList = new ArrayList<DinarModel>(); dinarModelList
	 * = this.dinarService.searchNamadinar(namadinar);
	 * model.addAttribute("dinarModelList", dinarModelList);
	 * 
	 * return "/dinar/list"; }
	 */
}
