package service;

import dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements MemberDao{

    @Autowired
    MemberDao memberDao;

    @Override
    public String save() {
        return null;
    }
}
