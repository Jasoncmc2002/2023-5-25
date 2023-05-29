package com.neusoft.dao;

import com.neusoft.entity.Card;

public interface ICardDao {
    void addCard(Card card);
    Card queryCardById(int id);
}
