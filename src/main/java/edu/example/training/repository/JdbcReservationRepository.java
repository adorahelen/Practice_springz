package edu.example.training.repository;

import edu.example.training.entity.Reservation;
import edu.example.training.entity.StudentType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcReservationRepository implements ReservationRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insert(Reservation reservation) {
        int result = jdbcTemplate.update("INSERT INTO Reservation VALUES(?, ?, ?, NOW(), ?, ?, ?)",
                reservation.getId(),
                reservation.getTrainingId(),
                reservation.getStudentTypeId(),
                reservation.getName(),
                reservation.getPhone(),
                reservation.getEmailAddress());
        return result == 1;
    }


    @Override
    public Reservation selectById(String id){
        String query ="""
             SELECT r.id, 
                    r.studentTypeId, 
                    r.name, 
                    r.phone, 
                    r.emailAddress, 
                    r.reservationDateTime,
                    st.id AS student_type_id, 
                    st.code, 
                    st.name AS student_type_name
             FROM reservation r
             LEFT OUTER JOIN student_type st
             ON r.studentTypeId = st.id
             WHERE r.id = ?
             """;
        return jdbcTemplate.queryForObject(
                query,
                new ReservationRowMapper(),
                id);
    }
    static class ReservationRowMapper implements RowMapper<Reservation> {
        @Override
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reservation reservation = new Reservation();
            reservation.setId(rs.getString("id"));
            reservation.setStudentTypeId(rs.getString("studentTypeId"));
            reservation.setName(rs.getString("name"));

            StudentType studentType = new StudentType();
            studentType.setId(rs.getString("student_type_id"));
            studentType.setCode(rs.getString("code"));
            studentType.setName(rs.getString("student_type_name"));

            reservation.setStudentType(studentType);
            return reservation;


        }
        // 기존에 제공되던 매퍼로는, 조인한걸 받을 수 없기에 오버라이딩 해서 매퍼를 재정의 한 후 매핑시킨다.
    }
}
