package com.mfi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping("/checker")
	public String checkerDashboard() {
		return "checker_dashboard";
	}
	
	@RequestMapping("/maker")
	public String makerDashboard() {
		return "maker_dashboard";
	}
	
	@RequestMapping("/role")
	public String role() {
		return "MFI_ROL_01";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "MFI_CUR_02";
	}
	
	@RequestMapping("/customerRegister")
	public String customerRegistration() {
		return "MFI_CRM_01";
	}
	
	@RequestMapping("/customerSearch")
	public String customerSearch() {
		return "MFI_CRM_02";
	}
	@RequestMapping("/loanRegister")
	public String loanRegistration() {
		return "MFI_LON_01";
	}
	
	@RequestMapping("/loanSearch")
	public String loanSearch() {
		return "MFI_LON_02";
	}
	@RequestMapping("/currentAccount")
	public String currentAccount() {
		return "MFI_CAC_02";
	}
	@RequestMapping("/savingAccount")
	public String savingAccount() {
		return "MFI_SAC_02";
	}
	@RequestMapping("/loanAccount")
	public String loanAccount() {
		return "MFI_LAC_02";
	}
	@RequestMapping("/deposit")
	public String deposit() {
		return "MFI_DSP_01";
	}
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "MFI_WTD_01";
	}
	@RequestMapping("/disbursement")
	public String disbursement() {
		return "MFI_DIS_01";
	}
	@RequestMapping("/repayment")
	public String repayment() {
		return "MFI_RPM_02";
	}
	@RequestMapping("/coa")
	public String coa() {
		return "MFI_COA_02";
	}
	@RequestMapping("/createBlackList")
	public String createBlackList() {
		return "MFI_BLT_01";
	}
	@RequestMapping("/searchBlackList")
	public String searchBlackList() {
		return "MFI_BLT_02";
	}
	
	@RequestMapping("triBalance")
	public String triBalance() {
		return "MFI_RPT_TRI";
	}
	@RequestMapping("transactionListing")
	public String transactionListing() {
		return "MFI_RPT_TRS";
	}
	@RequestMapping("customerListing")
	public String customerListing() {
		return "MFI_RPT_CUS";
	}
	@RequestMapping("accountListing")
	public String accountListing() {
		return "MFI_RPT_ACC";
	}
	@RequestMapping("overdueListing")
	public String overdueListing() {
		return "MFI_RPT_ODD";
	}
	@RequestMapping("loanOutstanding")
	public String loanOutstandingBalance() {
		return "MFI_RPT_LOB";
	}
	@RequestMapping("customerLedger")
	public String customerLedgerBalance() {
		return "MFI_RPT_CLB";
	}
}
