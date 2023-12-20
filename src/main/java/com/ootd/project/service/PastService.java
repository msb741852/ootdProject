package com.ootd.project.service;

import com.ootd.project.dao.PastDao;
import com.ootd.project.domain.past.Past;
import com.ootd.project.domain.past.PastUpdateItem;
import com.ootd.project.domain.past.PastItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PastService {

    @Autowired
    PastDao pastDao;

    public String memberPastAdd(Past past) {
        if(pastDao.pastAdd(past) == 1) {
            return "오늘의 착장 등록 완료!";
        } else {
            return "오늘의 착장 등록 실패!";
        }
    }

    public List<PastItem> memberPastListShow(Map<String, Integer> map) {
        return pastDao.showPastList(map);
    }

    public String memberPastItemDelete(int pastIdx) {
        return pastDao.deletePastItem(pastIdx) == 1 ? "삭제 완료!" : "삭제 실패!" ;
    }

    public String memberPastEdit(PastUpdateItem pastUpdateItem) {
        return pastDao.updatePast(pastUpdateItem) == 1 ? "수정 완료!" : "수정 실패!";
    }
}
