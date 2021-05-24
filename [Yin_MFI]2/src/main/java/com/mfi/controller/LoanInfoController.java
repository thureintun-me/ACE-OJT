/*
 * package com.mfi.controller;
 * 
 * import java.sql.Date; import java.util.List;
 * 
 * import javax.validation.Valid;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.mfi.formmodel.CurrentForm; import com.mfi.formmodel.LoanInfoForm;
 * import com.mfi.model.CurrentAccount; import com.mfi.model.Customer; import
 * com.mfi.model.LoanInfo; import com.mfi.model.User; import
 * com.mfi.service.CurrentAccountService; import
 * com.mfi.service.CustomerService; import com.mfi.service.LoanAccountService;
 * import com.mfi.service.LoanInfoService;
 * 
 * @Controller public class LoanInfoController {
 * 
 * @Autowired private CustomerService crmService;
 * 
 * @Autowired private LoanInfoService loanService;
 * 
 * @Autowired private CurrentAccountService currentService;
 * 
 * @Autowired private LoanAccountService loanAccountService;
 * 
 * @PostMapping("/loanRegister") public String
 * searchAll(@ModelAttribute("crmBean") Customer crm, Model model){
 * List<Customer> crmList = crmService.searchNameOrNrc(crm.getCustomerCode());
 * model.addAttribute("crmList", crmList); return "MFI_LON_01"; }
 * 
 * @GetMapping("/loanRegistration/{id}") public String
 * setuploanRegistration(@PathVariable("id")String id,Model model) {
 * model.addAttribute("loaninfo", new LoanInfoForm()); model.addAttribute("crm",
 * crmService.selectOne(id)); return "mfi/loan/MFI_LON_01_01"; }
 * 
 * @PostMapping("/loanRegistration/{id}") public String
 * loanRegistration(@PathVariable("id")String
 * id, @ModelAttribute("loaninfo") @Valid LoanInfoForm loanInfo,BindingResult
 * result, Model model) { if (result.hasErrors()) { return
 * "mfi/loan/MFI_CRM_01_01"; }
 * 
 * Customer customerCode = crmService.selectOne(id); LoanInfo loan = new
 * LoanInfo(); List<LoanInfo> loanlist= loanService.selectAll();
 * if(loanlist.isEmpty()) { String LoanId = String.format("LON0001");
 * loan.setLoanInfoId(LoanId); loan.setLoanAmount(loanInfo.getLoanAmount());
 * loan.setRegisterDate(loanInfo.getRegisterDate());
 * loan.setDescription(loanInfo.getDescription());
 * loan.setPeriod(loanInfo.getPeriod());
 * loan.setNumberOfPayment(loanInfo.getNumberOfPayment());
 * 
 * loan.setInterestRate(0.2); loan.setCustomer(customerCode);
 * loan.setCreditScore(100); loan.setStatus("Pending"); loanService.save(loan);
 * return "redirect:/loanSearch"; } else { int i = loanlist.size(); int gid =
 * i+1; String LoanId= String.format("LON%04d", gid);
 * loan.setLoanInfoId(LoanId); loan.setLoanAmount(loanInfo.getLoanAmount());
 * loan.setRegisterDate(loanInfo.getRegisterDate());
 * loan.setDescription(loanInfo.getDescription());
 * loan.setPeriod(loanInfo.getPeriod());
 * loan.setNumberOfPayment(loanInfo.getNumberOfPayment());
 * 
 * loan.setInterestRate(0.2); loan.setCustomer(customerCode);
 * loan.setCreditScore(100); loan.setStatus("Pending"); loanService.save(loan);
 * return "redirect:/loanSearch"; } }
 * 
 * @RequestMapping("/LONSearch") public String
 * LONSearch(@ModelAttribute("LoanBean") LoanInfo loanInfo, Model model){
 * LoanInfo loanList = loanService.selectOne(loanInfo.getLoanInfoId());
 * model.addAttribute("loanList", loanList); return "mfi/loan/MFI_LON_02";
 * 
 * 
 * }
 * 
 * @GetMapping("/checkerLoanList") public String checkerLoanList(Model model) {
 * String status = "pending";
 * model.addAttribute("loanList",loanService.selectSatus(status)); return
 * "mfi/loan/MFI_LON_03_01"; }
 * 
 * @RequestMapping("loanDetail/{id}") public String
 * loanDetail(@PathVariable("id")String id,Model model) {
 * model.addAttribute("loanDeatil", loanService.selectOne(id)); return
 * "mfi/loan/MFI_LON_04_01"; }
 * 
 * @RequestMapping("approveLoan/{id}") public String
 * approveLoan(@PathVariable("id")String id,Model model) { LoanInfo loanList =
 * loanService.selectOne(id);
 * 
 * // Current Account Create Double balance = loanList.getLoanAmount() - 1000;
 * CurrentAccount current = new CurrentAccount();
 * current.setCustomer(loanList.getCustomer()); current.setAccountStatus(true);
 * current.setBalance(balance);
 * 
 * List<CurrentAccount> currentList= currentService.selectAll();
 * if(currentList.isEmpty()) { String d = String.format("CRM0001");
 * current.setCurrentAccountNumber("1101000011110001");
 * 
 * 
 * return "redirect:/customerSearch"; } else { int i = currentList.size(); int
 * gid = i+1; String number = String.format("110100001111%04d", gid);
 * current.setCurrentAccountNumber(number); } currentService.save(current);
 * 
 * // loan account create
 * 
 * return "redirect:/checkerLoanList"; } }
 */