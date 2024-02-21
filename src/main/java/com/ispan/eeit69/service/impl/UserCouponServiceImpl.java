package com.ispan.eeit69.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit69.dao.UserCouponDao;
import com.ispan.eeit69.model.UserCoupon;
import com.ispan.eeit69.service.UserCouponService;

@Service
@Transactional
public class UserCouponServiceImpl implements UserCouponService {

	UserCouponDao userCouponDao;
	
//	@Autowired
	public UserCouponServiceImpl(UserCouponDao userCouponDao) {
		this.userCouponDao = userCouponDao;
	}

	@Override
	public void createUserCoupon(UserCoupon userCoupon) {
		userCouponDao.createUserCoupon(userCoupon);
	}

	@Override
	public void updateUserCoupon(UserCoupon usercoupon) {
		userCouponDao.createUserCoupon(usercoupon);
	}
	
	@Override
	public void deleteUserCoupon(Integer userCouponId){
		userCouponDao.deleteUserCoupon(userCouponId);
	}

	@Override
	public UserCoupon findByUserCouponId(Integer userCouponId) {
		return userCouponDao.findByUserCouponId(userCouponId);
	}

	@Override
	public List<UserCoupon> findAllUserCoupons() {
		return userCouponDao.findAllUserCoupons();
		}
	
	@Override
	public List<UserCoupon> findByUserId(Integer userId){
	    return userCouponDao.findByUserId(userId);
	}
	
	@Override
	public List<UserCoupon> findByUserIdAndUsageStatus(Integer userId, boolean used){
	    return userCouponDao.findByUserIdAndUsageStatus(userId, used);
	}
	
	@Override
	public List<UserCoupon> findByCreatedAtBetween(Date startDate, Date endDate){
	    return userCouponDao.findByCreatedAtBetween(startDate, endDate);
	}
	
}
