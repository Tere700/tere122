package com.ispan.eeit69.dao;

import java.util.Optional;

import com.ispan.eeit69.model.DiscountTypeImage;

public interface DiscountTypeImageDao {

	 Optional<DiscountTypeImage> getImageByDiscountType(String discountType);
}
