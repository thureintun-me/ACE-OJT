package com.mfi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.mfi.model.Transaction;
import com.mfi.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	ReportService reportService;

	@PostMapping("/transactionSearch")
	public String transactionSearch(@Param("start")String start, @Param("end")String end, Model model) {
		Date startdate = Date.valueOf(start);
		Date enddate = Date.valueOf(end);
		System.out.println(enddate);
		List<Transaction> transList = reportService.selectByStartDate(startdate,enddate);
		model.addAttribute("tranList",transList);
		return "reports/MFI_RPT_TRS";
	}
}
