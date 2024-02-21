package com.ispan.eeit69.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ispan.eeit69.dao.DiscountTypeImageDao;
import com.ispan.eeit69.model.DiscountTypeImage;

@Repository
public class DiscountTypeImageDaoImpl implements DiscountTypeImageDao {

	@PersistenceContext
	EntityManager  entityManager;
	
	@Override
	public  Optional<DiscountTypeImage> getImageByDiscountType(String discountType){	
	    try {
            String hql = "FROM DiscountTypeImage WHERE discountType = :eid";
            DiscountTypeImage result = entityManager.createQuery(hql, DiscountTypeImage.class)
                                .setParameter("eid", discountType)
                                .getSingleResult();
            return Optional.ofNullable(result);
        } catch (NoResultException e) {
            return Optional.empty(); // 沒有找到符合的結果
        } catch (Exception e) {
            // 其他錯誤處理
            return Optional.empty();
        }
	}

}
