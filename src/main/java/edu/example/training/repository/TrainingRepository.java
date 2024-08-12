package edu.example.training.repository;

import edu.example.training.entity.Training;

import java.util.List;

public interface TrainingRepository {
    List<Training> selectAll();


    void selectTitle(String title);
    void selectTitle(String id, String title);  //여러 컬럼     "
//    void selectStart(String id);                //날짜         "
//    void selectCount();                         //숫자         "
//
//    void selectReserveds();             //여러 레코드에서 한 컬럼 가져오기
//    void selectTrainingMap(String id);  //한 레코드에서 Map으로 가져오기
//    void selectTrainingMapList();       //여러 레코드 Map을 List로 가져오기
//
//    void selectTraining(String id);     //레코드를 Entity 객체로 가져오기
//    void selectTrainingList();          //레코드 Entity를 List로 가져오기
}
