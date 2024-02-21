package com.ispan.eeit69.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "discountTypeImage")
public class DiscountTypeImage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer image_id;
	   @Column(name = "discount_type")
	    private String discountType;
	   
	    @Lob
	    @Column(name = "image_data")
	    private byte[] imageData;

	    
	    
		public DiscountTypeImage() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DiscountTypeImage(Integer image_id, String discountType, byte[] imageData) {
			super();
			this.image_id = image_id;
			this.discountType = discountType;
			this.imageData = imageData;
		}

		public Integer getImage_id() {
			return image_id;
		}

		public void setImage_id(Integer image_id) {
			this.image_id = image_id;
		}

		public String getDiscountType() {
			return discountType;
		}

		public void setDiscountType(String discountType) {
			this.discountType = discountType;
		}

		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		@Override
		public String toString() {
			return "DiscountTypeImage [image_id=" + image_id + ", discountType=" + discountType + ", imageData="
					+ Arrays.toString(imageData) + "]";
		}


}
