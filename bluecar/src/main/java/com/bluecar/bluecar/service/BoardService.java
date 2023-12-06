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
        int pagingStart = (page - 1) * pageLimit;
        Map<String, Integer> pagingParms = new HashMap<>();
        pagingParms.put("start", pagingStart);
        pagingParms.put("limit", pageLimit);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParms);
        return pagingList;
    }
    int pageLimit = 5;
    int blockLimit = 3;
    public PageDTO pagingParma(int page) {
        int boardCount = boardRepository.boardCount();

        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));

        int startPage = (((int) (Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;

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
