package com.ispan.eeit69.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ispan.eeit69.model.Coupon;
import com.ispan.eeit69.model.DiscountTypeImage;
import com.ispan.eeit69.service.CouponService;
import com.ispan.eeit69.service.DiscountTypeImageService;

@Controller
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	private CouponService couponService;
	@Autowired
	private DiscountTypeImageService discountTypeImageService;

	@GetMapping("/showCoupons")
	public String showCoupons(Model model) {
		List<Coupon> coupons = couponService.findAllCoupons();
		model.addAttribute("coupons", coupons);
		// System.out.println("Fetched coupons:EEQQ " + coupons);
		// 假設每個coupon都有一個對應的discount_type
		
		 Map<String, String> discountTypeImagesBase64 = new HashMap<>();
		
		   for (Coupon coupon : coupons) {
	            String discountType = coupon.getDiscount_type(); // 假設 Coupon 有這個方法
	            byte[] imageBytes = discountTypeImageService.getImageByDiscountType(discountType);
	            String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
	            discountTypeImagesBase64.put(discountType, imageBase64);
	        }       
	        model.addAttribute("discountTypeImages", discountTypeImagesBase64);
	        //System.out.println(discountTypeImagesBase64);
	    
		return "coupon";
	}

	@GetMapping("/all")
	public List<Coupon> getAllCoupons() {
		List<Coupon> coupons = couponService.findAllCoupons();
		System.out.println("Fetched coupons:QQ " + coupons); // 或使用Logger
		return coupons;
	}

	@GetMapping("/{id}")
	public Coupon getCouponById(@PathVariable Integer id) {
		return couponService.findByCouponId(id);
	}

	@PostMapping("/create")
	public String createCoupon(@ModelAttribute Coupon coupon) {
		couponService.createCoupon(coupon);
		return "redirect:/coupons"; // 重定向到優惠卷列表页面
	}

	@PostMapping("/updateCoupon")
	public String update(@ModelAttribute Coupon coupon) {
		couponService.updateCoupon(coupon);
		return "redirect:/coupons"; // 重定向到優惠卷列表页面
	}

	@PostMapping("/delete/{id}")
	public String deleteCoupon(@PathVariable Integer id) {
		couponService.deleteCoupon(id);
		return "redirect:/coupons"; // 重定向到優惠卷列表页面
	}

	@PostMapping("/updateImage")
	public String updateImage(DiscountTypeImage discountTypeImage) {
		// 你的代碼
		return "redirect:/coupons"; // 重定向到優惠卷列表页面
	}

}
