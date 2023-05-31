package com.neusoft.dao;

import com.neusoft.entity.Card;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICardDao {
    void addCard(Card card);
    //If标签的使用
    Card queryCardById(int id);
    List<Card> queryCardByIdAndName(@Param("id") int id, @Param("name") String name);

    List<Card> queryCardByIdGroup(List<Integer> idList);

    void updateCard(Card card);
}
