package service;

import java.util.ArrayList;

import dto.Post;
import repository.PostRepository;

public class PostServiceImpl implements PostService {

	private PostRepository repository;

	public PostServiceImpl() {
		repository = PostRepository.getInstance();
	}

	@Override
	public ArrayList<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return repository.getAllPosts();
	}

	@Override
	public Post getPostByID(int id) {
		return repository.getPostByID(id);
	}

	@Override
	public void addPost(Post post) {
		repository.addPost(post);
	}

	@Override
	public void updatePost(Post post) {
		repository.updatePost(post);
	}

	@Override
	public void deletePostById(int id) {
		repository.deletePostById(id);

	}

}
