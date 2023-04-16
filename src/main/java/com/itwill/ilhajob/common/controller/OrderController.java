package com.itwill.ilhajob.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.ilhajob.common.dto.PaymentDto;
import com.itwill.ilhajob.common.dto.ProductDto;
import com.itwill.ilhajob.common.service.OrdersService;
import com.itwill.ilhajob.common.service.ProductService;
import com.itwill.ilhajob.user.dto.UserDto;

@Controller
public class OrderController {
	
	private final OrdersService ordersService;
	private final ProductService productService;
	
	@Autowired
	public OrderController(OrdersService ordersService, ProductService productService) {
		this.ordersService = ordersService;
		this.productService = productService;
	}
	
	@GetMapping("/pricing")
	public String pricing(HttpServletRequest request,Model model) throws Exception {
		if(request.getSession().getAttribute("role").equals("user")) {
			List<ProductDto> productList = productService.selectByDiv("user");
			model.addAttribute("productList", productList);
		}
		if(request.getSession().getAttribute("role").equals("corp")) {
			model.addAttribute("productList", productService.selectByDiv("corp"));
		}
		String forwardPath = "pricing";
		return forwardPath;
	}
	
	@GetMapping("/dashboard-change-password")
	public String changePassword(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "dashboard-change-password";
		return forwardPath;
	}
	
	@GetMapping("/shop-checkout")
	public String shopChecked(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "shop-checkout";
		return forwardPath;
	}
	
	@GetMapping("/order-completed")
	public String orderCompleted(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "order-completed";
		return forwardPath;
	}
	
	@GetMapping("/invoice")
	public String invoice(HttpServletRequest request, Model model) {
		String forwardPath = "";
		request.getSession().getAttribute("role");
		List<PaymentDto> paymentList = ordersService.findPayment("user", 1L);
		int totalPrice = paymentList.stream().mapToInt(PaymentDto::getPaymentPrice).sum();
		model.addAttribute("paymentList", paymentList);
		model.addAttribute("totalPrice", totalPrice);

		forwardPath = "invoice";
		return forwardPath;
	}
	
	@GetMapping("/dashboard-packages")
	public String packages(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "dashboard-packages";
		return forwardPath;
	}
}
