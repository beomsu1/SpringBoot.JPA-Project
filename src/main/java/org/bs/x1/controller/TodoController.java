package org.bs.x1.controller;

import java.util.Map;

import org.bs.x1.dto.PageResponseDTO;
import org.bs.x1.dto.TodoDTO;
import org.bs.x1.service.TodoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/todos/")
@RequiredArgsConstructor
@CrossOrigin
@Log4j2
public class TodoController {

    private final TodoService todoService;

    @GetMapping("list")
    public PageResponseDTO<TodoDTO> list(){
        
        return todoService.getList();
    }

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable("tno") Long tno){

        return todoService.getOne(tno);
    }

    @PostMapping("/")
    public TodoDTO register(@RequestBody TodoDTO todoDTO){

        log.info("register-------------");
        log.info(todoDTO);

        return todoService.register(todoDTO);
    }

    // 삭제
    @DeleteMapping("/{tno}")
    public Map<String,String> delete(@PathVariable("tno") Long tno){

        todoService.remove(tno);

        return Map.of("result","success");
    }

    // 수정
    @PutMapping("/{tno}")
    public Map<String,String> modify(@PathVariable("tno")Long tno , @RequestBody TodoDTO todoDTO){

        todoService.modify(todoDTO);

        return Map.of("result" , "success");
    }




    
}
