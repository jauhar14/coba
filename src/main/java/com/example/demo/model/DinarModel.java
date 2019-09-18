package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="T_DINAR")
public class DinarModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Integer id;	
	
	@Column(name="NOMOR_NOTA")
	private String nomorNota;
	
	@Column(name="TANGGAL_NOTA")
	private Date tanggalNota;
	
	@Column(name="VENDOR")
	private String vendor;
	
	@Column(name="KADAR")
	private Integer kadar;
	
	@Column(name="BERAT")
	private Integer berat;

	@Column(name="QUANTITY")
	private Integer quantity;
	
	public DinarModel(Integer id, String nomorNota, Date tanggalNota, String vendor, Integer kadar, Integer berat, Integer quantity ) {
		this.id = id;
		this.nomorNota = nomorNota;
		this.tanggalNota = tanggalNota;
		this.vendor = vendor;
		this.kadar = kadar;
		this.berat = berat;
		this.quantity = quantity;
	}

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 * 
	 * 
	 * public String getNomorNota() { return nomorNota; }
	 * 
	 * public void setNomorNota(String nomorNota) { this.nomorNota = nomorNota; }
	 * 
	 * public Date getTanggalNota() { return tanggalNota; }
	 * 
	 * public void setTanggalNota(Date tanggalNota) { this.tanggalNota =
	 * tanggalNota; }
	 * 
	 * public String getVendor() { return vendor; }
	 * 
	 * public void setVendor(String vendor) { this.vendor = vendor; }
	 * 
	 * public Integer getKadar() { return kadar; }
	 * 
	 * public void setKadar(Integer kadar) { this.kadar = kadar; }
	 * 
	 * public Integer getBerat() { return berat; }
	 * 
	 * public void setBerat(Integer berat) { this.berat = berat; }
	 * 
	 * public Integer getQuantity() { return quantity; }
	 * 
	 * public void setQuantity(Integer quantity) { this.quantity = quantity; }
	 */
	
	
	
}
