package site.metacoding.test1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SearchController {

    private final SearchRepository searchrepository;

    @GetMapping({ "/", "/search" })
    public String search(@RequestParam(defaultValue = "") String keyword, Model model) { // keyword=스프링

        List<Board> posts = searchrepository.mSearch(keyword);
        System.out.println("포스트 크기 : " + posts.size());
        model.addAttribute("boards", posts);
        return "/post/list";
    }

}
