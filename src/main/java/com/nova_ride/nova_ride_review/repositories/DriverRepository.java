package com.nova_ride.nova_ride_review.repositories;


import org.novaride.modelentity.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);
    Optional<Driver> findByLicenseNumber(String licenseNumber);

//    @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id=:id AND license_number=:license")
//    Optional<Driver> rawFindByIdAndLicenseNumber(@Param("id") Long id,@Param("license")  String license);



    List<Driver> findAllByIdIn(List<Long> driverIds);


}
