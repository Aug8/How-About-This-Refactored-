package com.HUFS19.backend.repository.chatRoom;

import com.HUFS19.backend.dto.chatRoom.ChatRoomDetail;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ChatRoomRepositoryImp implements ChatRoomRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;

    private QChatRoom chatRoom = QChatRoom.chatRoom;

    public ChatRoomRepositoryImp(EntityManager em){
        this.em=em;
        query = new JPAQueryFactory(em);
    }

    @Override
    public int save(ChatRoom chatRoom) {
        em.persist(chatRoom);
        return chatRoom.getId();
    }

    @Override
    public Optional<ChatRoom> findById(int id) {
        return Optional.ofNullable(em.find(ChatRoom.class, id));
    }

    @Override
    public Optional<ChatRoom> findByProductId(int productId) {
        List<ChatRoom> result= em.createQuery("select c from ChatRoom c where c.product.id = :productId", ChatRoom.class)
                .setParameter("productId", productId)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<ChatRoomDetail> findByUserId(String userId) {

        return query.select(
                Projections.bean(
                        ChatRoomDetail.class,
                        chatRoom.id,
                        chatRoom.user.id.as("userId"),
                        chatRoom.inquirer.id.as("inquirerId"),
                        chatRoom.product.id.as("productId"),
                        chatRoom.product.name.as("productName")

                ))
                .from(chatRoom)
                .where(
                        (chatRoom.user.id.eq(userId))
                        .or(chatRoom.inquirer.id.eq(userId)))
                .fetch();
    }

    @Override
    public Optional<Integer> findByProductInquirer(int productId, String inquirerId) {

        return Optional.ofNullable(
                query.select(chatRoom.id)
                        .from(chatRoom)
                        .where(
                                (chatRoom.product.id.eq(productId))
                                .and(chatRoom.inquirer.id.eq(inquirerId))
                        ).fetchOne());

    }
}
