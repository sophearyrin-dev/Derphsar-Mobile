package com.kshrd.derphsar_api;

import com.kshrd.derphsar_api.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DerphsarApiApplicationTests {
    @Test
    void test () {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.matches("admin", "$2a$10$LndTbMDRPcuNtw80vyXKMu3WGtxU8mVfH8GHpJ9yRSterD35Z/F4m"));
    }
//
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Test
//	void getProduct() {
//		System.out.println(productRepository.getProducts());
//	}

//    @Autowired
//    private WishListRepository wishListRepository;
//
//    @Test
//    void test() {
//        System.out.println(wishListRepository.get(4));
//    }
}
