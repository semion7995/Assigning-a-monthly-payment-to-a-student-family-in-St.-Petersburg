package edu.javacourse.student.dao;

import edu.javacourse.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT st FROM Student st WHERE st.lastName = :lastName AND st.firstName = :firstName AND st.middleName = :middleName AND " +
            "st.dateOfBirth = :dateOfBirth AND st.passportSerial = :passportSerial AND st.passportNumber = :passportNumber AND st.passportDate = :passportDate")
    List<Student> findStudent(@Param("lastName") String lastName,
                              @Param("firstName") String firstName,
                              @Param("middleName") String middleName,
                              @Param("dateOfBirth") LocalDate dateOfBirth,
                              @Param("passportSerial") String passportSerial,
                              @Param("passportNumber") String passportNumber,
                              @Param("passportDate") LocalDate passportDate);



}
/**
 * public interface MarriageDao extends JpaRepository<MarriageCertificate, Long> {
 * //    List<MarriageCertificate> findByNumberContaining(String number);
 *     List<MarriageCertificate> findByNumber(String number);
 *
 *
 *     List<MarriageCertificate> findByNum(@Param("number") String number);
 *
 *     @Query("SELECT mc FROM MarriageCertificate mc WHERE mc.number = :number")
 *     List<MarriageCertificate> findSomething(@Param("number") String number);
 * }
 */
