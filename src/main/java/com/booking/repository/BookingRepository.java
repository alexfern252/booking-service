/**
 * 
 */
package com.booking.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.model.entity.PhoneMasterDetails;

/**
 * @author Alexandre Fernandes
 *
 */
@Repository
@Transactional(readOnly = true)
public interface BookingRepository extends JpaRepository<PhoneMasterDetails, Long> {

	Optional<PhoneMasterDetails> findByPhoneId(Long id);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Transactional
	@Query("SELECT a FROM PhoneMasterDetails a WHERE a.phoneId = ?1")
	Optional<PhoneMasterDetails> getPhoneObjectForUpdate(Long id);

	 @Query("SELECT  a  FROM PhoneMasterDetails a LEFT JOIN BookingDetails b"
	 		+ " on a.phoneId= b.phoneMaster group by a.phoneId")
	 List<PhoneMasterDetails> findAllByBookingUsers();
	

}
