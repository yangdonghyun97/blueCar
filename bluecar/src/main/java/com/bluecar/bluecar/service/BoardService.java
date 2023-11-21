package com.bluecar.bluecar.service;

import com.bluecar.bluecar.dto.BoardDTO;
import com.bluecar.bluecar.dto.PageDTO;
import com.bluecar.bluecar.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    public int save(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public int update(BoardDTO boardDTO) {
        return boardRepository.update(boardDTO);
    }

    public int delete(BoardDTO boardDTO) {
        return boardRepository.delete(boardDTO);
    }

    public List<BoardDTO> pagingList(int page) {
        // -1해주는 이유는 리스트 인덱스는 0부터 시작이기 떄문
        int pagingStart = (page - 1) * pageLimit;
        Map<String, Integer> pagingParms = new HashMap<>();
        pagingParms.put("start", pagingStart);
        pagingParms.put("limit", pageLimit);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParms);
        return pagingList;
    }
    int pageLimit = 5; // 한 페이지당 보여줄 글 갯수
    int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
    public PageDTO pagingParma(int page) {
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardCount();
        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
        int endPage = startPage + blockLimit - 1;
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }

    public List<BoardDTO> findByCategory(BoardDTO boardDTO) {
        return boardRepository.findByCategory(boardDTO);
    }
}
