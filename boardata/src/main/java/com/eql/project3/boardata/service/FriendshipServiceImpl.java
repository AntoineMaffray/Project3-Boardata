package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Friendship;
import com.eql.project3.boardata.models.User;
import com.eql.project3.boardata.repository.FriendshipRepository;
import com.eql.project3.boardata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService{

    @Autowired
    FriendshipRepository friendshipRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveFriendship(Friendship friendship) {
        friendshipRepository.save(friendship);
    }

    @Override
    public List<Friendship> findAllFriendships() {
        return friendshipRepository.findAll();
    }

    @Override
    public Friendship findFriendshipByID(Long id) {
        return friendshipRepository.getReferenceById(id);
    }

    @Override
    public List<User> findMyFriends(User connectedUser) {
        List<Friendship> friendships = friendshipRepository.findAll();
        List<Friendship> myFriendShips = new ArrayList<>();
        List<User> myfriends = new ArrayList<>();
        for (Friendship friendship : friendships) {
            if (friendship.getFriend() == connectedUser || friendship.getRequester() == connectedUser) {
                myFriendShips.add(friendship);
            }
        }
        for (Friendship myFriendShip : myFriendShips) {
            if (myFriendShip.getFriend() == connectedUser && myFriendShip.isActive()) {
                myfriends.add(myFriendShip.getRequester());
            } else if (myFriendShip.getRequester() == connectedUser && myFriendShip.isActive()){
                myfriends.add(myFriendShip.getFriend());
            }
        }
        return myfriends;
    }

    @Override
    public List<User> findMyPendingFriends(User connectedUser) {
        List<Friendship> friendships = new ArrayList<>();
        friendships = friendshipRepository.findAll();
        List<Friendship> myFriendShips = new ArrayList<>();
        List<User> myBarelyFriends = new ArrayList<>();
        for (Friendship friendship : friendships) {
            if (friendship.getFriend() == connectedUser || friendship.getRequester() == connectedUser) {
                myFriendShips.add(friendship);
            }
        }
        for (Friendship myFriendShip : myFriendShips) {
            if (myFriendShip.getRequester() == connectedUser && !myFriendShip.isActive()){
                myBarelyFriends.add(myFriendShip.getFriend());
            }
        }
        return myBarelyFriends;
    }

    @Override
    public List<User> askedFriends(User connectedUser) {
        List<Friendship> friendships = new ArrayList<>();
        friendships = friendshipRepository.findAll();
        List<User> askedFriends = new ArrayList<>();
        for (Friendship friendship : friendships) {
            if (friendship.getFriend() == connectedUser && !friendship.isActive()){
                askedFriends.add(friendship.getRequester());
            }
        }
        return askedFriends;
    }


    @Override
    public List<User> dontFindMyFriends(User connectedUser) {
        List<User> notMyfriends = new ArrayList<>();
        notMyfriends = userRepository.findAll();
        List<Friendship> friendships = new ArrayList<>();
        friendships = friendshipRepository.findAll();
        List<Friendship> myFriendShips = new ArrayList<>();
        List<User> myfriends = new ArrayList<>();
        for (Friendship friendship : friendships) {
            if (friendship.getFriend() == connectedUser || friendship.getRequester() == connectedUser) {
                myFriendShips.add(friendship);
            }
        }
        for (Friendship myFriendShip : myFriendShips) {
            if (myFriendShip.getFriend() == connectedUser && myFriendShip.isActive()) {
                myfriends.add(myFriendShip.getRequester());
            } else if (myFriendShip.getRequester() == connectedUser && myFriendShip.isActive()){
                myfriends.add(myFriendShip.getFriend());
            }
        }
        for (User myfriend : myfriends) {
            notMyfriends.remove(myfriend);
        }
        return notMyfriends;
    }

//    @Override
//    public List<User> dontFindMyFriends(User connectedUser) {
//        List<Friendship> friendships = new ArrayList<>();
//        friendships = friendshipRepository.findAll();
//        List<Friendship> myFriendShips = new ArrayList<>();
//        List<User> notMyfriends = new ArrayList<>();
//        for (Friendship friendship : friendships) {
//            if (friendship.getFriend() != connectedUser || friendship.getRequester() != connectedUser) {
//                myFriendShips.add(friendship);
//            }
//        }
//        for (Friendship myFriendShip : myFriendShips) {
//            notMyfriends.add(myFriendShip.getFriend());
//        }
//        return notMyfriends;
//    }

    @Override
    public Friendship findFrienshipByIds(User requester, User friend) {
        List<Friendship> allFriendships = friendshipRepository.findAll();
        Friendship thisFriendship=null;
        for (Friendship aFrienship : allFriendships) {
            if (aFrienship.getFriend() == friend && aFrienship.getRequester() == requester) {
                thisFriendship = aFrienship;
            }
        }
        return thisFriendship;
    }
}

