package code.gym.controller;

import code.gym.dto.BloggerDto;
import code.gym.model.Blogger;
import code.gym.service.IBloggerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogger/v1")
public class BloggerRestController {
    @Autowired
    private IBloggerService iBloggerService;

    @GetMapping("")
    public ResponseEntity<List<Blogger>> getCategoryList(@PageableDefault(value = 2)Pageable pageable) {
        Page<Blogger> blogers = iBloggerService.findAll(pageable);
        if (blogers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogers.getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBlogger(@RequestBody BloggerDto bloggerDto) {
        Blogger blogger = new Blogger();
        BeanUtils.copyProperties(bloggerDto, blogger);
        iBloggerService.save(blogger);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity view(@PathVariable int id) {
        Blogger blogger = iBloggerService.findById(id);
        if (blogger == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogger, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blogger> updateCategory(@PathVariable int id,
                                                  @RequestBody BloggerDto bloggerDto) {
        Blogger blogger = iBloggerService.findById(id);
        if (blogger == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blogger blogger1 = new Blogger();
        BeanUtils.copyProperties(bloggerDto , blogger1);
        iBloggerService.save(blogger1);
        return new ResponseEntity<>(blogger1, HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity<List<Blogger>> search(@RequestParam String BloggerName){
//        List<Blogger> bloggerList;
//        if (BloggerName.equals("")){
//            iBloggerService.findAll();
//        }else {
//            bloggerList = iBloggerService.findBloggerByName(BloggerName);
//        }
//        return bloggerList;
//    }

    @GetMapping("/search")
    public ResponseEntity<List<Blogger>> searchName(@RequestParam String name){
        List<Blogger> bloggers = iBloggerService.findByName(name);
        if (bloggers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bloggers, HttpStatus.OK);
    }
}
