package service;

import java.util.ArrayList;

import dto.Post;

public interface PostService {

	ArrayList<Post> getAllPosts();

	Post getPostByID(int id);

	void addPost(Post post);

	void updatePost(Post post);

	void deletePostById(int id);

}
