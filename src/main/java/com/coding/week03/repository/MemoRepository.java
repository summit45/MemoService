package com.coding.week03.repository;

import com.coding.week03.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc(); //생성시간 최신순으로 정렬

    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end); //특정 기간 내 생성된 메모를 최신순으로 정렬

    @Query("SELECT m FROM Memo m WHERE m.modifiedAt BETWEEN ?1 AND ?2 ORDER BY m.modifiedAt DESC")
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDescWithQuery(LocalDateTime start, LocalDateTime end); //특정 기간 내 생성된 메모를 최신순으로 정렬
}
