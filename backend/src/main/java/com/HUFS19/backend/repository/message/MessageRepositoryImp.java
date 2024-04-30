package com.HUFS19.backend.repository.message;

import com.HUFS19.backend.dto.message.LastMessageDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class MessageRepositoryImp implements MessageRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;
    private QMessage message = QMessage.message;
    public MessageRepositoryImp(EntityManager em){
        this.em=em;
        this.query=new JPAQueryFactory(em);
    }

    @Override
    public int save(Message message) {
        em.persist(message);
        return message.getId();
    }
    @Override
    public Optional<Message> findById(int id) {
        return Optional.ofNullable(em.find(Message.class, id));
    }

    @Override
    public List<Message> findAllByChatRoom(int chatRoomId) {
        return query.selectFrom(message).where(message.chatRoom.id.eq(chatRoomId)).fetch();
    }

    @Override
    public Optional<Message> findLastByChatRoom(int chatRoomId) {
        return Optional.ofNullable(
                query.selectFrom(message).
                        where(message.chatRoom.id.eq(chatRoomId)).
                        orderBy(message.time.desc()).
                        fetchFirst());
    }
}
