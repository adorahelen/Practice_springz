package edu.example.training.repository;

import edu.example.training.entity.Reservation;
import edu.example.training.entity.StudentType;
import edu.example.training.entity.Training;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    @Override
    public Training selectTrainingID(String id) {
        String query = """
                SELECT t.id AS t_id,
                       t.title,
                       t.start_date_time,
                       r.id AS r_id,
                       r.name
                FROM   training t
                LEFT OUTER JOIN reservation r
                ON     t.id = r.trainingId
                WHERE  t.id = ?
           
                """;
                return jdbcTemplate.query(query, new TrainingResultSetExtractor(), id);

    }
    static class TrainingResultSetExtractor implements ResultSetExtractor<Training> {

        @Override
        public Training extractData(ResultSet rs) throws SQLException, DataAccessException {
            Training training = null;
            while (rs.next()) {
                if (training == null) {
                    training = new Training();
                    training.setId(rs.getString("t_id"));
                    training.setTitle(rs.getString("title"));
                    training.setStartDateTime(rs.getTimestamp("start_date_time")
                            .toLocalDateTime());
                    training.setReservations(new ArrayList<>());
                }
                Reservation reservation = new Reservation();
                reservation.setId(rs.getString("r_id"));
                reservation.setTrainingId(rs.getString("t_id"));
                reservation.setName(rs.getString("name"));

                training.getReservations().add(reservation);
            }
            return training;
        }
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
