package com.mfi.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mfi.formmodel.CustomerForm;
import com.mfi.model.Customer;
import com.mfi.model.LoanInfo;
import com.mfi.model.Transaction;
import com.mfi.service.DisbursementService;
import com.mfi.service.LoanInfoService;
import com.mfi.service.ReportService;

@Controller
public class DashboardController {
	@Autowired
	LoanInfoService loanInfoService;
	@Autowired
	DisbursementService disService;
	@Autowired
	ReportService reportService;
	
	@RequestMapping("/checker")
	public String checkerDashboard(Model model) {
		String status = "pending";
		List<LoanInfo> loanList = loanInfoService.selectSatus(status);
		int pendingloanList = loanList.size();
//		System.out.println(pendingloanList);
		model.addAttribute("pendingloanList",pendingloanList);
		return "dashboard/checker_dashboard";
	}
	
	@RequestMapping("/maker")
	public String makerDashboard() {
		return "dashboard/maker_dashboard";
	}
	
	
	
	@RequestMapping("/role")
	public String role() {
		return "user/MFI_ROL_01";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "user/MFI_CUR_02";
	}
	
	@RequestMapping("/customerRegister")
	public String customerRegistration(Model model) {
		model.addAttribute("crmBean", new CustomerForm());
		return "customer/MFI_CRM_01"; 	
	}
	
	@RequestMapping("/customerSearch")
	public String customerSearch(Model model) {
		model.addAttribute("crmBean", new Customer());
		return "customer/MFI_CRM_02";
	}
	@RequestMapping("/loanRegister")
	public String loanRegistration() {
		
		return "loan/MFI_LON_01";
	}
	
	@RequestMapping("/loanSearch")
	public String loanSearch() {
		return "loan/MFI_LON_02";
	}
	@RequestMapping("/currentAccount")
	public String currentAccount() {
		return "account/MFI_CAC_02";
	}
	@RequestMapping("/savingAccount")
	public String savingAccount() {
		return "account/MFI_SAC_02";
	}
	@RequestMapping("/loanAccount")
	public String loanAccount() {
		return "account/MFI_LAC_02";
	}
	@RequestMapping("/deposit")
	public String deposit(Model model) {
		model.addAttribute("depositBean", new Transaction());
		return "transaction/MFI_DSP_01";
	}
	@RequestMapping("/withdraw")
	public String withdraw(Model model) {
		model.addAttribute("withdrawBean", new Transaction());
		return "transaction/MFI_WTD_01";
	}
	@RequestMapping("/disbursement")
	public String disbursement(Model model) {
		String status = "approve"; 
		model.addAttribute("disList", disService.selectDisbursement(status));
		return "transaction/MFI_DIS_01";
	}
	@RequestMapping("/repayment")
	public String repayment() {
		return "transaction/MFI_RPM_02";
	}
	@RequestMapping("/coa")
	public String coa() {
		return "coa/MFI_COA_02";
	}
	@RequestMapping("/createBlackList")
	public String createBlackList() {
		return "blacklist/MFI_BLT_01";
	}
	@RequestMapping("/searchBlackList")
	public String searchBlackList() {
		return "blacklist/MFI_BLT_02";
	}
	
	@RequestMapping("triBalance")
	public String triBalance() {
		return "reports/MFI_RPT_TRI";
	}
	@RequestMapping("transactionListing")
	public String transactionListing(Model model) {
		List<Transaction> tranList = reportService.selectAllTransaction();
		
		model.addAttribute("tranList",tranList);
		return "reports/MFI_RPT_TRS";
	}
	@RequestMapping("customerListing")
	public String customerListing(Model model) {
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		List<Customer> customerListing = reportService.findCustomerByTodayDate(date);
		model.addAttribute("customerList",customerListing);
		return "reports/MFI_RPT_CUS";
	}
	@RequestMapping("accountListing")
	public String accountListing() {
		return "reports/MFI_RPT_ACC";
	}
	@RequestMapping("overdueListing")
	public String overdueListing() {
		return "reports/MFI_RPT_ODD";
	}
	@RequestMapping("loanOutstanding")
	public String loanOutstandingBalance() {
		return "reports/MFI_RPT_LOB";
	}
	@RequestMapping("customerLedger")
	public String customerLedgerBalance() {
		return "reports/MFI_RPT_CLB";
	}
}
