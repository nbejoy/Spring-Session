package com.demo.controllers;

//import java.io.FileOutputStream;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.model.Account;

//import com.demo.model.Account;


@Controller
@SessionAttributes("aNewAccount")
public class myDemoController 
{
@ModelAttribute
public void addaccountToModel(Model model)
{
	System.out.println("Making sure account object is on model");
	if(!model.containsAttribute("aNewAccount"))
	{
		Account a=new Account();
		model.addAttribute("aNewAccount",a);
	}
}


@RequestMapping(value="/createAccount")
	
public String createAccount(@ModelAttribute ("aNewAccount") Account account)
	{
		
		System.out.println(account.getFirstName() +" "+ account.getLastName()+ " "+account.getAddress()+" "+account.getEmail()+ " "+account.getAge());
		return "createAccount";
	
	}
@RequestMapping(value="/doCreate")
public String doCreate(@ModelAttribute ("aNewAccount") Account account)
{
	
	System.out.println("Do create: New account info: "+account.getFirstName() +" "+ account.getLastName()+ " "+account.getAddress()+" "+account.getEmail()+ " "+account.getAge());
	System.out.println("Do create: Going off and creating an actual account ");
	return "redirect:accConfirm.html";
}
		

@RequestMapping(value="/accConfirm")
public String accConfirm(@ModelAttribute ("aNewAccount") Account account)
{
	
	System.out.println("Account Confirmed:Welcome "+account.getFirstName() +" "+ account.getLastName());
	
	return "accConfirm";
}

}
