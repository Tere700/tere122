package com.ispan.eeit69.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit69.dao.DiscountTypeImageDao;
import com.ispan.eeit69.model.DiscountTypeImage;
import com.ispan.eeit69.service.DiscountTypeImageService;

@Service
@Transactional
public class DiscountTypeImageServiceImpl implements DiscountTypeImageService  {

	DiscountTypeImageDao discountTypeImageDao;
	
//	@Autowired
	public DiscountTypeImageServiceImpl(DiscountTypeImageDao discountTypeImageDao) {
		this.discountTypeImageDao = discountTypeImageDao;
	}

	@Override
	public byte[] getImageByDiscountType(String discountType){
	    Optional<DiscountTypeImage> optionalImage = discountTypeImageDao.getImageByDiscountType(discountType);
	    System.out.println(optionalImage);
	    if (optionalImage.isPresent()) {
	    	//System.out.println(optionalImage.get().getImageData());
	        return optionalImage.get().getImageData();
	    } else {
	        // Handle error, e.g., throw an exception or return a default image
	        return null;
	    }
	    
	}
	
}
