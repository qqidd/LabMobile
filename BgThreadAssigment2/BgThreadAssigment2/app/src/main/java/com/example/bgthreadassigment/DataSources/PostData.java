package com.example.bgthreadassigment.DataSources;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.bgthreadassigment.Models.PostModel;
import com.example.bgthreadassigment.Models.UserModel;
import com.example.bgthreadassigment.R;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class PostData {
    private final Context context;
    private static Boolean isRefresh = false;

    public PostData(Context context) {
        this.context = context;
    }

    private static final UserModel
            user1 = new UserModel("chaewon", "Kim Chae Won", R.drawable.chae),
            user2 = new UserModel("eunchae", "Hong Eun Chae", R.drawable.eun),
            user3 = new UserModel("kazuha", "Kazuha Nakamura", R.drawable.kazu),
            user4 = new UserModel("sakura", "Sakura Miyawaki", R.drawable.saku),
            user5 = new UserModel("yunjin", "Huh Yun Jin", R.drawable.yun);
    private static Deque<PostModel> posts;

    private void setData(){
        posts = new LinkedList<>();
        posts.push(new PostModel(user3, BitmapFactory.decodeResource(context.getResources(), R.drawable.kazuha), "My Calvins"));
        posts.push(new PostModel(user4, BitmapFactory.decodeResource(context.getResources(), R.drawable.sakura), "ㅋㅋㅋㅋㅋ"));
        posts.push(new PostModel(user5, BitmapFactory.decodeResource(context.getResources(), R.drawable.yunjin), "우리는! 제주돌!"));
        posts.push(new PostModel(user2, BitmapFactory.decodeResource(context.getResources(), R.drawable.eunchae), "내가 좋아하는"));
        posts.push(new PostModel(user1, BitmapFactory.decodeResource(context.getResources(), R.drawable.chaewon), "오늘 한국시간 저녁 11시에 있을 디올 쇼도 기대해주세요!"));
    }

    public void setPost(PostModel postModel) {
        posts.push(postModel);
    }

    public ArrayList<PostModel> getPosts() {
        if (!isRefresh) setData();
        return new ArrayList<>(posts);
    }

    public ArrayList<UserModel> getUserPosts() {
        ArrayList<UserModel> userPosts = new ArrayList<>();
        ArrayList<PostModel> posts = getPosts();
        for (PostModel post : posts) {
            if (!userPosts.contains(post.getUser())) userPosts.add(post.getUser());
        }
        return userPosts;
    }

    public void setRefresh(Boolean refresh) {
        isRefresh = refresh;
    }

    public Boolean getRefresh() {
        return isRefresh;
    }
}
