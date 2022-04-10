package site.metacoding.test1;

import org.springframework.data.domain.Sort;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SearchApiController {

    private final SearchRepository searchrepository;

    @GetMapping("/api/post")
    public ResponseDto<?> list(Integer page) {
        PageRequest pq = PageRequest.of(page, 9, Sort.by(Direction.DESC, "id"));
        Page<Board> boards = searchrepository.findAll(pq);
        // 응답의 DTO를 만들어서 <- posts 를 옮김. (라이브러리 있음)
        return new ResponseDto<>(1, "성공", boards);
    }

    @GetMapping("/api/search")
    public ResponseDto<?> search(@RequestParam(defaultValue = "") String keyword) {
        List<Board> boards = searchrepository.mSearch(keyword);
        return new ResponseDto<>(1, "성공", boards); // MessageConverter 발동 - 자바오브젝트를 JSON으로 변환
    }
}
