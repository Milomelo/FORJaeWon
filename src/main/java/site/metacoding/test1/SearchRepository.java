package site.metacoding.test1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SearchRepository extends JpaRepository<Board, Integer> {

    @Query(value = "SELECT * FROM board WHERE title like %:keyword%", nativeQuery = true)
    List<Board> mSearch(@Param("keyword") String keyword);

}