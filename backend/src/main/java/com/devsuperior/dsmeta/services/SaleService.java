package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		LocalDate min;
		LocalDate max;
		/*
		 * LocalDate agora = LocalDate.now(); if (minDate.equals("")) { min =
		 * (LocalDate.of(agora.getYear(), agora.getMonth(),
		 * agora.getDayOfMonth())).minusYears(1);
		 * 
		 * }else { min = LocalDate.parse(minDate); } if (maxDate.equals("")) { max =
		 * (LocalDate.of(agora.getYear(), agora.getMonth(), agora.getDayOfMonth()));
		 * }else { max = LocalDate.parse(maxDate); }
		 */
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

			min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
			max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return repository.findSales(min, max, pageable);
	}
}
