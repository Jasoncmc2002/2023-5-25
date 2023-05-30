package com.neusoft.dao;

import com.neusoft.entity.Leader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ILeaderDao {
    void addLeader(Leader leader);
    //Insert into the relationship table
    void addRelation(@Param("lid") int lid,@Param("uid") int uid);
    List<Leader> queryLeaderByUid(int uid);
}
