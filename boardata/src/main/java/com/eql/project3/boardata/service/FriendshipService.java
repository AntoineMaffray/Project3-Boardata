package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Friendship;
import com.eql.project3.boardata.models.Game;
import com.eql.project3.boardata.models.User;

import java.util.List;

public interface FriendshipService {

    void saveFriendship(Friendship friendship);

    List<Friendship> findAllFriendships();

    Friendship findFriendshipByID (Long id);

    List<User> findMyFriends(User connectedUser);

    List<User> findMyPendingFriends(User connectedUser);

    List<User> askedFriends(User connectedUser);

    List<User> dontFindMyFriends(User connectedUser);

    Friendship findFrienshipByIds (User requester, User friend);

}
