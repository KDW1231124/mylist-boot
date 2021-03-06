package com.eomcs.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {

  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList3.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    ArrayList3.add(board);
    return ArrayList3.size;
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= ArrayList3.size) {
      return "";
    }
    Board board = (Board) ArrayList3.list[index];
    board.viewCount++; 
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }

    Board old = (Board) ArrayList3.list[index];
    board.viewCount = old.viewCount;
    board.createdDate = old.createdDate;

    return ArrayList3.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }
    ArrayList3.remove(index);
    return 1;
  }
}




